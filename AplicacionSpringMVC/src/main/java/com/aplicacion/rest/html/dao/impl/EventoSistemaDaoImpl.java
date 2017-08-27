package com.aplicacion.rest.html.dao.impl;

import com.aplicacion.rest.html.dao.EventoSistemaDao;
import com.aplicacion.rest.html.entity.EventoSistema;
import com.aplicacion.rest.html.exception.InternalServiceException;
import com.aplicacion.rest.html.jpa.util.AbstractJpaDao;
import com.aplicacion.rest.html.jpa.util.PersistenceManager;
import com.aplicacion.rest.html.layer.type.EventoSistemaType;

public class EventoSistemaDaoImpl extends AbstractJpaDao<Integer, EventoSistema> implements EventoSistemaDao {

	public EventoSistemaDaoImpl(PersistenceManager persistenceManager) {
		super(persistenceManager);
	}

	@Override
	public Boolean registrarEmailEnviada(EventoSistemaType eventoSistema) throws InternalServiceException {
		boolean exito = false;
		try{
			registrarEntity(new EventoSistemaType().toEntity(eventoSistema)); 
			exito= true;
		}catch (Exception e) {
			System.out.println("Se produjo un error");
			System.out.println("Error: "+ e.getStackTrace());
			throw new InternalServiceException(); 
		}
		return exito;
	}

}
