package com.aplicacion.spring.mvc.interfaces.impl.beans;

import com.aplicacion.spring.mvc.interfaces.beans.IMotivoEstadoES;
import com.aplication.spring.mvc.entity.MotivoEstado;
import com.aplication.spring.mvc.jpa.util.AbstractJpaDao;
import com.aplication.spring.mvc.jpa.util.PersistenceManager;
import com.aplication.spring.mvc.layer.type.MotivoEstadoType;

public class MotivoEstadoESImpl extends AbstractJpaDao<Integer, MotivoEstado> implements IMotivoEstadoES{

	public MotivoEstadoESImpl(PersistenceManager persistenceManager) {
		super(persistenceManager);
	}

	@Override
	public MotivoEstadoType buscarMotivoEstadoPorId(Integer motivoId) {
		MotivoEstado motivo = buscarEntityPorId(MotivoEstado.class, motivoId);
		return new MotivoEstadoType().toType(motivo);
	}

}
