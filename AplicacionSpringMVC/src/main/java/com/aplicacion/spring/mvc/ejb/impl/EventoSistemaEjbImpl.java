package com.aplicacion.spring.mvc.ejb.impl;

import javax.ejb.Stateful;

import org.jboss.logging.Logger;

import com.aplication.spring.mvc.jpa.util.PersistenceManager;

@Stateful
public class EventoSistemaEjbImpl {
	
	private static final Logger logger = Logger.getLogger(EventoSistemaEjbImpl.class.getName());
	
	private PersistenceManager persistenceManager;

	public EventoSistemaEjbImpl() {
		// TODO Auto-generated constructor stub
	}

}
