package com.aplication.spring.mvcinterfaces.beans;

import javax.ejb.Remote;
import javax.persistence.PersistenceException;

import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.layer.type.ContactoType;

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
