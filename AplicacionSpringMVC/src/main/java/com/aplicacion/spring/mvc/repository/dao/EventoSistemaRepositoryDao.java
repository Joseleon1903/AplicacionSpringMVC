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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aplicacion.spring.mvc.jdbc.query.SistemaQuerySQL;
import com.aplicacion.spring.mvc.jdbc.query.UsuarioQuerySQL;
import com.aplication.spring.mvc.jpa.util.DatabaseUtil;
import com.aplication.spring.mvc.layer.type.ContactoType;
import com.aplication.spring.mvc.layer.type.EnvioSistemaType;
import com.aplication.spring.mvc.layer.type.EventoSistemaType;

@Repository("EventoSistemaDao")
public class EventoSistemaRepositoryDao {

	private static final Logger logger = Logger.getLogger(EventoSistemaRepositoryDao.class.getName());
	
	@Autowired
	private DataSource dataSource;

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
	 */
	@Transactional(propagation= Propagation.REQUIRES_NEW)
	public boolean registrarEnvioEmail(EventoSistemaType evento) {
		boolean exito = false;
//		logger.info("Entrando en la capacidad : registrarEnvioEmail");
//		logger.info("EventoSistemaType: " + evento);
//		IEventoSistemaES dao = new EventoSistemaESImpl(entityManager);
//		try {
//			exito = dao.registrarNuevoEvento(new EventoSistemaType().toEntity(evento));
//		} catch (PersistenceException e) {
//			logger.info("ocurrio un error registrando EnvioEmail");
//			logger.info("ERROR " + e.getMessage());
//		}
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


}
