package com.aplication.spring.mvc.dao;

import javax.persistence.PersistenceException;
import javax.ws.rs.InternalServerErrorException;

import com.aplication.spring.mvc.entity.Contacto;
import com.aplication.spring.mvc.layer.type.ContactoType;

public interface ContactoDao {
	
	/**
	 * Descripcion: Permite actualizar el contacto pasado por parametro. 
	 * 
	 * @param contacto
	 * @return boolean
	 * @throws InternalServerErrorException
	 */
	boolean actualizarContacto(Contacto contacto) throws PersistenceException;
	
	/**
	 * Descripcion: buscar el contacto con el Id provisto por parametro.
	 * 
	 * @param id
	 * @return ContactoType
	 * @throws PersistenceException
	 */
	ContactoType buscarContactoPorId(Integer contactoId) throws PersistenceException;
	

}
