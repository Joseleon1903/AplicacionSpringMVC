package com.aplicacion.rest.html.ejb.impl;

import javax.ejb.Stateful;

import com.aplicacion.rest.html.dao.ContactoDao;
import com.aplicacion.rest.html.dao.impl.ContactoDaoImpl;
import com.aplicacion.rest.html.ejb.interfaces.IContacto;
import com.aplicacion.rest.html.exception.InternalServiceException;
import com.aplicacion.rest.html.jpa.util.PersistenceManager;
import com.aplicacion.rest.html.layer.type.ContactoType;

@Stateful
public class ContactoEjbImpl implements IContacto{
	
	private PersistenceManager persistenceManager;


	public ContactoEjbImpl() {}

	@Override
	public boolean actualizarContacto(ContactoType contacto) throws InternalServiceException {
		boolean exito = false;
		ContactoDao dao = new ContactoDaoImpl(persistenceManager);
		exito = dao.actualizarContacto(new ContactoType().toEntity(contacto));
		return exito;
	}

	@Override
	public ContactoType buscarContactoPorId(Integer contactoId) throws InternalServiceException {
		ContactoDao dao = new ContactoDaoImpl(persistenceManager);
		ContactoType contacto = dao.buscarContactoPorId(contactoId);
		return contacto;
	}

}
