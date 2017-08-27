package com.aplicacion.rest.html.dao;

import com.aplicacion.rest.html.exception.ServiceFault;
import com.aplicacion.rest.html.layer.type.EventoSistemaType;

public interface EventoSistemaDao {
	
	public Boolean registrarEmailEnviada(EventoSistemaType eventoSistema) throws ServiceFault;

}
