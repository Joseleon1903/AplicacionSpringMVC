package com.aplicacion.rest.html.ejb.interfaces;

import javax.ejb.Remote;

import com.aplicacion.rest.html.exception.DuplicateObjectException;
import com.aplicacion.rest.html.exception.InternalServiceException;
import com.aplicacion.rest.html.exception.InvalidDataException;
import com.aplicacion.rest.html.layer.type.EventoSistemaType;

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
