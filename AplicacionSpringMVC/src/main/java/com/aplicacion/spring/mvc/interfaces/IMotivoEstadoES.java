package com.aplicacion.spring.mvc.interfaces;

import java.util.List;

import com.aplication.spring.mvc.layer.type.MotivoEstadoType;

public interface IMotivoEstadoES {

	/**
	 * Descripcion: Busca el motivo Estado por el ID porporcionado por parametro,
	 * en el repositorio de MOTIVO_ESTADO.
	 * 
	 * @param motivoId
	 * @return
	 */
	public MotivoEstadoType buscarMotivoEstadoPorId(Integer motivoId);

	/**
	 * Descripcion: Devuelve la lista de motivos estado en el reporitorio de MOTIVO_ESTADO.
	 * 
	 * @return List<MotivoEstadoType>
	 */
	public List<MotivoEstadoType> buscarMotivoEstadoSistema();
}
