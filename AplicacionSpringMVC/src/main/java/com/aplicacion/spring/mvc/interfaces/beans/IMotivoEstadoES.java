package com.aplicacion.spring.mvc.interfaces.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.aplication.spring.mvc.layer.type.MotivoEstadoType;

@Service
@Scope("prototype")
public interface IMotivoEstadoES {
	
	public MotivoEstadoType buscarMotivoEstadoPorId(Integer motivoId);

}
