package com.aplicacion.spring.mvc.repository.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aplicacion.spring.mvc.interfaces.IEventoSistemaES;
import com.aplicacion.spring.mvc.interfaces.impl.EventoSistemaESImpl;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.layer.type.EventoSistemaType;

@Repository("EventoSistemaDao")
@Transactional
public class EventoSistemaRepositoryDao {

	private static final Logger logger = Logger.getLogger(EventoSistemaRepositoryDao.class.getName());
	
	@PersistenceContext
	private EntityManager entityManager;

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
	public boolean registrarEnvioEmail(EventoSistemaType evento) {
		boolean exito = false;
		logger.info("Entrando en la capacidad : registrarEnvioEmail");
		logger.info("EventoSistemaType: " + evento);
		IEventoSistemaES dao = new EventoSistemaESImpl(entityManager);
		try {
			exito = dao.registrarNuevoEvento(new EventoSistemaType().toEntity(evento));
		} catch (PersistenceException e) {
			logger.info("ocurrio un error registrando EnvioEmail");
			logger.info("ERROR " + e.getMessage());
		}
		return exito;
	}
	
	/**
	 * Descripcion: Capacidad que retorna todos los registros almacenados en los repositorios de EVENTO_SISTEMA y ENVIO_SISTEMA.
	 * 
	 * @return List<EventoSistemaType>
	 */
	public List<EventoSistemaType> buscarListaEmailSistema() {
		logger.info("Entrando en la capacidad : buscarListaEmailSistema");
		logger.info("Iniciando busqueda email registrada en el sistema");
		List<EventoSistemaType> lista = new ArrayList<>();
		IEventoSistemaES dao = new EventoSistemaESImpl(entityManager);
		try {
			lista = dao.buscarElencoEmailSistema();
		} catch (InternalServiceException e) {
			logger.info("ocurrio un error registrando EnvioEmail");
			logger.info("ERROR " + e.getMessage());
		}
		logger.info("Terminando busqueda email sistema");
		logger.info("returnning: "+lista);
		return lista;
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
	public List<EventoSistemaType> buscarListaEmailPorDatosGenerales(String nombreUsuario, String asunto, String destinatario,
			String estado) {
		logger.info("Entrando en la capacidad : buscarListaEmailPorDatosGenerales");
		logger.info("Iniciando busqueda email registrada en el sistema");
		List<EventoSistemaType> lista = new ArrayList<>();
		IEventoSistemaES dao = new EventoSistemaESImpl(entityManager);
		try {
			lista = dao.buscarEmailPorDatosGenerales(nombreUsuario, asunto, destinatario, estado);
		} catch (InternalServiceException e) {
			logger.info("ocurrio un error buscando lista Email enviadas");
			logger.info("ERROR " + e.getMessage());
		}
		logger.info("Terminando busqueda email sistema");
		logger.info("returnning: "+lista);
		return lista;
	}


}
