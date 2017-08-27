package com.aplicacion.rest.html.dao;

import javax.persistence.PersistenceException;
import javax.ws.rs.InternalServerErrorException;

import com.aplicacion.rest.html.entity.Contacto;
import com.aplicacion.rest.html.layer.type.ContactoType;

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
