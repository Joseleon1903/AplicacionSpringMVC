package com.aplicacion.spring.mvc.interfaces.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.aplicacion.spring.mvc.interfaces.IEventoSistemaES;
import com.aplication.spring.mvc.entity.EventoSistema;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.jpa.util.AbstractJpaDao;
import com.aplication.spring.mvc.jpa.util.ParameterExpression;
import com.aplication.spring.mvc.layer.type.EventoSistemaType;

public class EventoSistemaESImpl extends AbstractJpaDao<Integer, EventoSistema> implements IEventoSistemaES {


	public EventoSistemaESImpl(EntityManager entityManager) {
		super(entityManager);
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

	@Override
	public List<EventoSistemaType> buscarEmailPorDatosGenerales(String nombreUsuario, String asunto, String destinatario,
			String estado) throws InternalServiceException {
		List<EventoSistema> listaEntity = new ArrayList<>();
		List<EventoSistemaType> listaType = new ArrayList<>();
		ParameterExpression parametrosQuery =  new ParameterExpression();
		parametrosQuery.addParam("nombreUsuario", nombreUsuario);
		parametrosQuery.addParam("asunto", asunto);
		parametrosQuery.addParam("destinatario", destinatario);
		parametrosQuery.addParam("estado", estado);
		listaEntity = buscarEntityListPorNameQueryConRetorno(EventoSistema.NamedQuery.BUSCAR_EMAIL_DATOS_GENERALES, parametrosQuery);
		if (!listaEntity.isEmpty()) {
			for (EventoSistema evento : listaEntity) {
				listaType.add(new EventoSistemaType().toType(evento));	
			}
		}
		return listaType;
	}

}
