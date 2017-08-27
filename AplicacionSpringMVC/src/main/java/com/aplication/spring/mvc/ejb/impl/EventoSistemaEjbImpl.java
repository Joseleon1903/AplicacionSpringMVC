package com.aplication.spring.mvc.ejb.impl;

import com.aplication.spring.mvc.dao.EventoSistemaDao;
import com.aplication.spring.mvc.dao.impl.EventoSistemaDaoImpl;
import com.aplication.spring.mvc.ejb.interfaces.IEventoSistema;
import com.aplication.spring.mvc.exception.DuplicateObjectException;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.exception.InvalidDataException;
import com.aplication.spring.mvc.exception.ServiceFault;
import com.aplication.spring.mvc.jpa.util.PersistenceManager;
import com.aplication.spring.mvc.layer.type.EventoSistemaType;

public class EventoSistemaEjbImpl implements IEventoSistema {
	
	private PersistenceManager persistenceManager;

	public EventoSistemaEjbImpl() {}

	@Override
	public Boolean registrarEmailEnviada(EventoSistemaType eventoSistema)throws InternalServiceException, DuplicateObjectException, InvalidDataException {
	     System.out.println("param: "+eventoSistema );
	     boolean registrado = false;
	     System.out.println("registrado: "+registrado);
	     EventoSistemaDao dao = new EventoSistemaDaoImpl(persistenceManager);
	     try {
			registrado=  dao.registrarEmailEnviada(eventoSistema);
		} catch (ServiceFault e) {
			throw new InternalServiceException(e.getCodigo(), e.getDescripcion());
		}
		return registrado;
	}

}
