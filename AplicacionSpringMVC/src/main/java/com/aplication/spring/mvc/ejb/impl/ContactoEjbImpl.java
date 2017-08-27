package com.aplication.spring.mvc.ejb.impl;

import javax.ejb.Stateful;

import com.aplication.spring.mvc.dao.ContactoDao;
import com.aplication.spring.mvc.dao.impl.ContactoDaoImpl;
import com.aplication.spring.mvc.ejb.interfaces.IContacto;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.jpa.util.PersistenceManager;
import com.aplication.spring.mvc.layer.type.ContactoType;

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
