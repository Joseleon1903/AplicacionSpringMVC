package com.aplication.spring.mvc.dao.impl;

import com.aplication.spring.mvc.dao.EventoSistemaDao;
import com.aplication.spring.mvc.entity.EventoSistema;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.jpa.util.AbstractJpaDao;
import com.aplication.spring.mvc.jpa.util.PersistenceManager;
import com.aplication.spring.mvc.layer.type.EventoSistemaType;

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
