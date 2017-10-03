package com.aplicacion.spring.mvc.interfaces.impl;

import java.util.ArrayList;
import java.util.List;

import com.aplicacion.spring.mvc.interfaces.IEventoSistemaES;
import com.aplication.spring.mvc.entity.EventoSistema;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.jpa.util.AbstractJpaDao;
import com.aplication.spring.mvc.jpa.util.PersistenceManager;
import com.aplication.spring.mvc.layer.type.EventoSistemaType;

public class EventoSistemaESImpl extends AbstractJpaDao<Integer, EventoSistema> implements IEventoSistemaES {


	public EventoSistemaESImpl(PersistenceManager persistenceManager) {
		super(persistenceManager);
	}

	@Override
	public boolean registrarNuevoEvento(EventoSistema evento) {
		registrarEntity(evento);
		return true;
	}

	@Override
	public List<EventoSistemaType> buscarElencoEmailSistema() throws InternalServiceException {
		List<EventoSistemaType> listaType = new ArrayList<>();
		List<EventoSistema> listaEntity =buscarEntityListPorNameQueryConRetorno(EventoSistema.NamedQuery.BUSCAR_EMAIL_SISTEMA, null);
		for (EventoSistema eventoSistema : listaEntity) {
			listaType.add(new EventoSistemaType().toType(eventoSistema));
		}
		return listaType;
	}

}
