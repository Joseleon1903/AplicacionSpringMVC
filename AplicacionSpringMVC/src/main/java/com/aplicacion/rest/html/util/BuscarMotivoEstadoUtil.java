package com.aplicacion.rest.html.util;

import com.aplicacion.rest.html.ejb.impl.MotivoEstadoEjbImpl;
import com.aplicacion.rest.html.exception.InternalServiceException;
import com.aplicacion.rest.html.layer.type.MotivoEstadoType;

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
