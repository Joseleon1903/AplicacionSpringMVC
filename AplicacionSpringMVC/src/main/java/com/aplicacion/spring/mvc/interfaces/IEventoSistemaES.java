package com.aplicacion.spring.mvc.interfaces;

import java.util.List;

import com.aplication.spring.mvc.entity.EventoSistema;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.layer.type.EventoSistemaType;

public interface IEventoSistemaES {

	public boolean registrarNuevoEvento(EventoSistema evento);
	
	public List<EventoSistemaType> buscarElencoEmailSistema() throws InternalServiceException;

}
