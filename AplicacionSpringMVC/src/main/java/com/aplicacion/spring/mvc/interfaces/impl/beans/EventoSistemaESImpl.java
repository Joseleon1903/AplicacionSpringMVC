package com.aplicacion.spring.mvc.interfaces.impl.beans;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aplicacion.spring.mvc.interfaces.beans.IEventoSistemaES;
import com.aplication.spring.mvc.entity.EventoSistema;

@Repository
@Transactional
public class EventoSistemaESImpl implements IEventoSistemaES {


	@Override
	public boolean registrarNuevoEvento(EventoSistema evento) {
//		registrarEntity(evento);
		return true;
	}

}
