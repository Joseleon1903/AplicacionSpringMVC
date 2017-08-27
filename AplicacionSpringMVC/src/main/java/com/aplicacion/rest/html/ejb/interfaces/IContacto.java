package com.aplicacion.rest.html.ejb.interfaces;

import javax.ejb.Remote;
import javax.persistence.PersistenceException;

import com.aplicacion.rest.html.exception.InternalServiceException;
import com.aplicacion.rest.html.layer.type.ContactoType;

@Remote
public interface IContacto {
	
	/**
	 * Descripcion: Permite actualizar el contacto.
	 * 
	 * @param contacto
	 * @return boolean
	 */
	boolean actualizarContacto(ContactoType contacto) throws InternalServiceException;
	
	
	/**
	 * Descripcion: buscar el contacto con el Id provisto por parametro.
	 * 
	 * @param id
	 * @return ContactoType
	 * @throws PersistenceException
	 */
	ContactoType buscarContactoPorId(Integer contactoId) throws InternalServiceException;

}
