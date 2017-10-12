package com.aplicacion.spring.mvc.interfaces.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.aplicacion.spring.mvc.interfaces.IEventoSistemaES;
import com.aplication.spring.mvc.entity.Contacto;
import com.aplication.spring.mvc.entity.EnvioSistema;
import com.aplication.spring.mvc.entity.EventoSistema;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.jpa.util.AbstractJpaDao;
import com.aplication.spring.mvc.layer.type.EventoSistemaType;
import com.aplication.spring.mvc.util.ValidationUtil;

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
	public List<EventoSistemaType> buscarEmailPorDatosGenerales(String nombreUsuario, String asunto,
			String destinatario, String estado) throws InternalServiceException {
		List<EventoSistema> listaEntity = new ArrayList<>();
		List<EventoSistemaType> listaType = new ArrayList<>();
		// iniciando creacion de criteria query para la busqueda
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<EventoSistema> cq = cb.createQuery(EventoSistema.class);
		Root<EventoSistema> root = cq.from(EventoSistema.class);
		// join
		Join<EventoSistema, EnvioSistema> eventoEnvio = root.join("envioId");
		Join<EventoSistema, Contacto> eventoContacto = root.join("contactoId");
		// lista predicatso
		List<Predicate> predicateList = new ArrayList<>();
		if (!ValidationUtil.isStringNotNullOrEmpty(asunto)) {
			Predicate predicate1 = cb.equal(eventoEnvio.get("asunto"), asunto);
			predicateList.add(predicate1);
		}
		if (!ValidationUtil.isStringNotNullOrEmpty(destinatario)) {
			Predicate predicate2 = cb.equal(eventoEnvio.get("destinatario"), destinatario);
			predicateList.add(predicate2);
		}
		if (!ValidationUtil.isStringNotNullOrEmpty(nombreUsuario)) {
			Predicate predicate3 = cb.equal(eventoContacto.get("nombre"), nombreUsuario);
			predicateList.add(predicate3);
		}
		Predicate predicate4 = cb.equal(eventoEnvio.get("estado"), estado);
		predicateList.add(predicate4);
		Predicate[] pr = new Predicate[predicateList.size()];
		predicateList.toArray(pr);
		cq.where(pr);
		TypedQuery<EventoSistema> q = getEntityManager().createQuery(cq);
		listaEntity = q.getResultList();
		if (!listaEntity.isEmpty()) {
			for (EventoSistema evento : listaEntity) {
				listaType.add(new EventoSistemaType().toType(evento));
			}
		}
		return listaType;
	}
}
