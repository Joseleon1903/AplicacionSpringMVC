package com.aplicacion.spring.mvc.interfaces.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aplicacion.spring.mvc.interfaces.IMotivoEstadoES;
import com.aplication.spring.mvc.layer.type.MotivoEstadoType;

@Repository
@Transactional
public class MotivoEstadoESImpl implements IMotivoEstadoES{

	

	@Override
	public MotivoEstadoType buscarMotivoEstadoPorId(Integer motivoId) {
//		MotivoEstado motivo = buscarEntityPorId(MotivoEstado.class, motivoId);
//		return new MotivoEstadoType().toType(motivo);
		return null;
	}

}
