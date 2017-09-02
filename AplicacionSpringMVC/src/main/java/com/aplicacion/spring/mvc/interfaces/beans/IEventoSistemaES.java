package com.aplicacion.spring.mvc.interfaces.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.aplication.spring.mvc.entity.EventoSistema;

@Service
@Scope("prototype")
public interface IEventoSistemaES {
	
	public boolean registrarNuevoEvento(EventoSistema evento);

}
