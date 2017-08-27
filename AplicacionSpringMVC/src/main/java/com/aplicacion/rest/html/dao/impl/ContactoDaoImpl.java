package com.aplicacion.rest.html.dao.impl;

import javax.persistence.PersistenceException;
import javax.ws.rs.InternalServerErrorException;

import com.aplicacion.rest.html.dao.ContactoDao;
import com.aplicacion.rest.html.entity.Contacto;
import com.aplicacion.rest.html.jpa.util.AbstractJpaDao;
import com.aplicacion.rest.html.jpa.util.PersistenceManager;
import com.aplicacion.rest.html.layer.type.ContactoType;

public class ContactoDaoImpl extends AbstractJpaDao<Integer, Contacto> implements ContactoDao {

	public ContactoDaoImpl(PersistenceManager persistenceManager) {
		super(persistenceManager);
	}

	@Override
	public boolean actualizarContacto(Contacto contacto) throws InternalServerErrorException {
		return actualizarEntity(contacto);
	}

	@Override
	public ContactoType buscarContactoPorId(Integer contactoId) throws PersistenceException {
		Contacto contacto = buscarEntityPorId(Contacto.class, contactoId);
		return new ContactoType().toType(contacto);
	} 

}
