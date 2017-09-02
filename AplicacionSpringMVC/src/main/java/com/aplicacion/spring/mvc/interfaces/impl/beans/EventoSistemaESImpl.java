package com.aplicacion.spring.mvc.interfaces.impl.beans;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aplicacion.spring.mvc.interfaces.beans.IEventoSistemaES;
import com.aplication.spring.mvc.entity.EventoSistema;
import com.aplication.spring.mvc.jpa.util.AbstractJpaDao;
import com.aplication.spring.mvc.jpa.util.PersistenceManager;

@Repository
@Transactional
public class EventoSistemaESImpl extends AbstractJpaDao<Integer, EventoSistema> implements IEventoSistemaES {

	public EventoSistemaESImpl(PersistenceManager persistenceManager) {
		super(persistenceManager);
	}

	@Override
	public boolean registrarNuevoEvento(EventoSistema evento) {
		registrarEntity(evento);
		return true;
	}

}
