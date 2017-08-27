package com.aplication.spring.mvc.util;

import com.aplication.spring.mvc.ejb.impl.MotivoEstadoEjbImpl;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.layer.type.MotivoEstadoType;

public class BuscarMotivoEstadoUtil {
	
	private static MotivoEstadoEjbImpl motivoEstado = new MotivoEstadoEjbImpl();

	private BuscarMotivoEstadoUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static MotivoEstadoType buscarMotivoPorId(Integer motivoId){
		MotivoEstadoType motivo = new MotivoEstadoType();
		try {
			motivo = motivoEstado.buscarMotivoPorId(motivoId);
		} catch (InternalServiceException e) {
			e.printStackTrace();
		}		
		return motivo;
	}

}
