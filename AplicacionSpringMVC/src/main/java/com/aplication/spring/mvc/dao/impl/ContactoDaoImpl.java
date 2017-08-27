package com.aplication.spring.mvc.dao.impl;

import javax.persistence.PersistenceException;
import javax.ws.rs.InternalServerErrorException;

import com.aplication.spring.mvc.dao.ContactoDao;
import com.aplication.spring.mvc.entity.Contacto;
import com.aplication.spring.mvc.jpa.util.AbstractJpaDao;
import com.aplication.spring.mvc.jpa.util.PersistenceManager;
import com.aplication.spring.mvc.layer.type.ContactoType;

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
