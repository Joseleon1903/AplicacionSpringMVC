package com.aplication.spring.mvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import com.aplication.spring.mvc.dao.MotivoEstadoDao;
import com.aplication.spring.mvc.entity.MotivoEstado;
import com.aplication.spring.mvc.jpa.util.AbstractJpaDao;
import com.aplication.spring.mvc.jpa.util.PersistenceManager;

public class MotivoEstadoDaoImpl extends AbstractJpaDao<Integer, MotivoEstado> implements MotivoEstadoDao{

	public MotivoEstadoDaoImpl(PersistenceManager persistenceManager) {
		super(persistenceManager);
	}

	@Override
	public MotivoEstado buscarMotivoEstadoPorId(Integer id) throws PersistenceException {
		MotivoEstado motivo = buscarEntityPorId(MotivoEstado.class,id);
		return motivo;
	}

	@Override
	public List<MotivoEstado> buscarTodosLosMotivos() throws PersistenceException {
		List<MotivoEstado> listaMotivos = new ArrayList<>();
		listaMotivos = buscarEntityListPorNameQueryConRetorno(MotivoEstado.Query.BUSCAR_TODOS_LOS_MOTIVOS, null);
		return listaMotivos;
	}

}
