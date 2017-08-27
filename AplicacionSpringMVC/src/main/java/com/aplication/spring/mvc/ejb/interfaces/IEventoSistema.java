package com.aplication.spring.mvc.ejb.interfaces;

import javax.ejb.Remote;

import com.aplication.spring.mvc.exception.DuplicateObjectException;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.exception.InvalidDataException;
import com.aplication.spring.mvc.layer.type.EventoSistemaType;

@Remote
public interface IEventoSistema {
	
	/**
	 * Decripcion: capacidad que registra en el sistema una email enviada.
	 * 
	 * @param eventoSistema
	 * @return Boolean
	 * @throws InternalServiceException
	 * @throws DuplicateObjectException
	 * @throws InvalidDataException
	 */
	public Boolean registrarEmailEnviada(EventoSistemaType eventoSistema) throws InternalServiceException, DuplicateObjectException,InvalidDataException;

}
