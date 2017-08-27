package com.aplication.spring.mvc.dao;

import com.aplication.spring.mvc.exception.ServiceFault;
import com.aplication.spring.mvc.layer.type.EventoSistemaType;

public interface EventoSistemaDao {
	
	public Boolean registrarEmailEnviada(EventoSistemaType eventoSistema) throws ServiceFault;

}
