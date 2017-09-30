package com.aplicacion.spring.mvc.ejb.impl;

import javax.ejb.Stateful;
import javax.persistence.PersistenceException;

import org.jboss.logging.Logger;

import com.aplicacion.spring.mvc.interfaces.IEventoSistemaES;
import com.aplicacion.spring.mvc.interfaces.impl.EventoSistemaESImpl;
import com.aplication.spring.mvc.jpa.util.PersistenceManager;
import com.aplication.spring.mvc.layer.type.EventoSistemaType;

@Stateful
public class EventoSistemaEjbImpl {
	
	private static final Logger logger = Logger.getLogger(EventoSistemaEjbImpl.class.getName());
	
	private PersistenceManager persistenceManager;

	public EventoSistemaEjbImpl() {
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
		IEventoSistemaES dao = new EventoSistemaESImpl(persistenceManager);
		try {
			exito = dao.registrarNuevoEvento(new EventoSistemaType().toEntity(evento));
		} catch (PersistenceException e) {
			logger.info("ocurrio un error registrando EnvioEmail");
			logger.info("ERROR " + e.getMessage());
		}
		return exito;
	}

}
