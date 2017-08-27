package com.aplicacion.rest.html.ejb.impl;

import com.aplicacion.rest.html.dao.EventoSistemaDao;
import com.aplicacion.rest.html.dao.impl.EventoSistemaDaoImpl;
import com.aplicacion.rest.html.ejb.interfaces.IEventoSistema;
import com.aplicacion.rest.html.exception.DuplicateObjectException;
import com.aplicacion.rest.html.exception.InternalServiceException;
import com.aplicacion.rest.html.exception.InvalidDataException;
import com.aplicacion.rest.html.exception.ServiceFault;
import com.aplicacion.rest.html.jpa.util.PersistenceManager;
import com.aplicacion.rest.html.layer.type.EventoSistemaType;

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
