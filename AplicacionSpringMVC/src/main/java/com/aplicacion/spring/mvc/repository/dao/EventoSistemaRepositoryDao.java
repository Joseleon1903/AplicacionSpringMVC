package com.aplicacion.spring.mvc.repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedRuntimeException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aplicacion.spring.mvc.jdbc.query.SistemaQuerySQL;
import com.aplicacion.spring.mvc.jdbc.query.UsuarioQuerySQL;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.jpa.util.DatabaseUtil;
import com.aplication.spring.mvc.layer.type.ContactoType;
import com.aplication.spring.mvc.layer.type.EnvioSistemaType;
import com.aplication.spring.mvc.layer.type.EventoSistemaType;
import com.aplication.spring.mvc.util.ValidationUtil;

@Repository("EventoSistemaDao")
public class EventoSistemaRepositoryDao {

	private static final Logger logger = Logger.getLogger(EventoSistemaRepositoryDao.class.getName());
	
	@Autowired
	private DataSource dataSource;
	
    @Autowired
	private JavaMailSender mailSender;

	public EventoSistemaRepositoryDao() {	
		// TODO Auto-generated constructor stub
	}
	
	/**
	 *
	 * Descripcion: Capacidad que permite registar un nuevo evento en el repositorio de EVENTO_SISTEMA y ENVIO_SISTEMA del sistema.
	 *              Devuelve TRUE si el evento fue registrado exitosamente, FALSE de lo contrario.
	 *              
	 * @param EventoSistemaType: evento
	 * @return boolean
	 * @throws InternalServiceException 
	 */
	@Transactional(propagation= Propagation.REQUIRES_NEW)
	public boolean registrarEnvioEmail(EventoSistemaType evento) throws InternalServiceException {
		boolean exito = false;
		logger.info("Entrando en la capacidad registrarEnvioEmail");
		logger.info("Inicinado ejecucion funcion: "+ DatabaseUtil.OPTENER_VALOR_INDEX_TABLA_SQL);
		logger.info("Creando conexion desde el datasource.");
		Connection connexion = null;
		PreparedStatement stmt = null;
		try {
			logger.info("Opteneiendo conexion data Source");
			connexion = dataSource.getConnection();
			logger.info("Terminando optener conexion.");
			Integer indexId = DatabaseUtil.buscarValorIndexTabla(SistemaQuerySQL.Tablas.EVENTO_SISTEMA_TBL, connexion);
			logger.info("Index : "+ indexId);
			logger.info("Iniciando registrar envio sistema");
			stmt = connexion.prepareStatement(SistemaQuerySQL.Insert.INSERT_ENVIO_SISTEMA);
			boolean agregarMotivo = ValidationUtil.isObjectNotNull(evento.getEnvioId().getMotivoId());
			logger.info("Indicador Motivo: "+ agregarMotivo);
			if (!agregarMotivo) {
				stmt = connexion.prepareStatement(SistemaQuerySQL.Insert.INSERT_ENVIO_SISTEMA_MOTIVO);
			}
			stmt = SistemaQuerySQL.agregarEnvioSistemaStatement(stmt, evento, indexId, !agregarMotivo);
			stmt.executeUpdate();
			logger.info("Finalizando registrar envio sistema");
			logger.info("Registrando evento sistema.");
			stmt = connexion.prepareStatement(SistemaQuerySQL.Insert.INSERT_EVENTO_SISTEMA);
			stmt = SistemaQuerySQL.agregarEventoSistemaStatement(stmt, evento, indexId);
			stmt.executeUpdate();
			logger.info("Finalizando evento sistema");
		} catch (SQLException e) {
			logger.info("Error registrar envio sistema " + e.getMessage());
			throw new InternalServiceException();
		} finally {
			if (connexion != null) {
				try {
					connexion.close();
				} catch (SQLException e) {
				}
			}
		}
		logger.info("Terminando registrar eventoSistema");
		return exito;
	}
	
	/**
	 * Descripcion: Capacidad que retorna todos los registros almacenados en los repositorios de EVENTO_SISTEMA y ENVIO_SISTEMA.
	 * 
	 * @return List<EventoSistemaType>
	 */
	@Transactional(propagation= Propagation.REQUIRED)
	public List<EventoSistemaType> buscarListaEmailSistema(Integer contactoId) {
		logger.info("Entrando en la capacidad : buscarListaEmailSistema");
		logger.info("Inicinado ejecucion select: "+ SistemaQuerySQL.Consulta.BUSCAR_lISTA_EMAIL_POR_CONTACTO);
		logger.info("Creando conexion desde el datasource.");
		Connection connexion = null;
		PreparedStatement stmt = null;
		List<EventoSistemaType> listaOutput = new ArrayList<>();
		try {
			logger.info("Opteneiendo conexion data Source");
			connexion = dataSource.getConnection();
			logger.info("Finalizando Optener conexion datasource.");
			stmt = connexion.prepareStatement(SistemaQuerySQL.Consulta.BUSCAR_lISTA_EMAIL_POR_CONTACTO);
			stmt.setInt(1, contactoId);
			ResultSet rs = stmt.executeQuery();
			logger.info("Terminando efectuar consulta.");
			EventoSistemaType evento = null;
			EnvioSistemaType envio = null;
			ContactoType contacto = null;
			while(rs.next()){
				contacto = new ContactoType();
				contacto = UsuarioQuerySQL.casteoResulsetContactoType(rs, false);
				envio = new EnvioSistemaType();
				envio = SistemaQuerySQL.casteoResultSetEnvioSistemaType(rs);
				evento = new EventoSistemaType();
				evento = SistemaQuerySQL.casteoResultSetEventoSistemaType(rs, contacto, envio);
				listaOutput.add(evento);
			}
			logger.info("Finalizando casteo resultSet usuario : "+ listaOutput);
		} catch (SQLException e) {
			logger.info("Error realizando la consulta..");
			logger.info("Error: "+ e.getMessage());
		}
		logger.info("Terminando realizar Consulta.");	
		return listaOutput;
	}
	
	/**
	 * Descripcion: Capacidad que permite buscar el el repositorio de EVENTO_SISTEMA y ENVIO_SISTEMA 
	 *              filtrando los resultados por los parametrso proporcionados.
	 * 
	 * @param nombreUsuario
	 * @param asunto
	 * @param destinatario
	 * @param estado
	 * @return List<EventoSistemaType>
	 */
	@Transactional(propagation= Propagation.REQUIRED)
	public List<EventoSistemaType> buscarListaEmailPorDatosGenerales(String nombreUsuario, String asunto, String destinatario,
			String estado) {
		logger.info("Entrando en la capacidad : buscarListaEmailPorDatosGenerales");
		logger.info("Iniciando busqueda email registrada en el sistema");
		List<EventoSistemaType> lista = new ArrayList<>();
		Connection connexion = null;
		PreparedStatement stmt = null;
		try {
			logger.info("Opteneiendo conexion data Source");
			connexion = dataSource.getConnection();
			logger.info("Finalizando Optener conexion datasource.");
			String query = SistemaQuerySQL.Consulta.BUSCAR_lISTA_EMAIL_CON_DATOS_GENERALES;
			query = DatabaseUtil.remplazarParametroSelect(query, ":nombre", nombreUsuario);
			query = DatabaseUtil.remplazarParametroSelect(query, ":asunto", asunto);
			query = DatabaseUtil.remplazarParametroSelect(query, ":destinatario", destinatario);
			logger.info("Inicinado ejecucion select: "+ query);
			stmt = connexion.prepareStatement(query);
			stmt.setString(1, estado);
			ResultSet rs = stmt.executeQuery(); 
			logger.info("Terminando efectuar consulta.");
			EventoSistemaType evento = null;
			EnvioSistemaType envio = null;
			ContactoType contacto = null;
			while(rs.next()){
				contacto = new ContactoType();
				contacto = UsuarioQuerySQL.casteoResulsetContactoType(rs, false);
				envio = new EnvioSistemaType();
				envio = SistemaQuerySQL.casteoResultSetEnvioSistemaType(rs);
				evento = new EventoSistemaType();
				evento = SistemaQuerySQL.casteoResultSetEventoSistemaType(rs, contacto, envio);
				lista.add(evento);
			}
			logger.info("resultSet Sizer : "+ lista);
			logger.info("Finalizando casteo resultSet usuario : "+ lista);
		} catch (SQLException e) {
			logger.info("Error realizando la consulta..");
			logger.info("Error: "+ e.getMessage());
		}
		logger.info("Terminando realizar Consulta.");
		return lista;
	}
	
	public void enviarEmail(String asunto, String destinatario,String contenido) throws NestedRuntimeException{
		logger.info("Entrando en el metodo enviarEmail");
		logger.info("asunto : "+ asunto);
		logger.info("destinatario : "+ destinatario);
		logger.info("contenido : "+ contenido);
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(destinatario);
		email.setSubject(asunto);
		email.setText(contenido);
		logger.info("Iniciando Envio Email");
		mailSender.send(email);	
		logger.info("Finalizando Envio Email");
	}



}
