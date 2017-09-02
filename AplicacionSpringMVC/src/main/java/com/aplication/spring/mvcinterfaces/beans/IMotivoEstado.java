package com.aplication.spring.mvcinterfaces.beans;

import java.util.List;

import javax.ejb.Remote;

import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.layer.type.MotivoEstadoType;

@Remote
public interface IMotivoEstado {
	
	
	/**
	 * Descripcion:Metodo que busca el motivo por el id
	 * 
	 * @param id
	 * @return MotivoEstadoType
	 * @throws InternalServiceException
	 */
	public MotivoEstadoType buscarMotivoPorId(Integer id) throws InternalServiceException;
	
	
	/**
	 * Descripcion:Metodo que busca todos los motivos del sistema
	 * 
	 * @return List<MotivoEstado>	
	 * @throws InternalServiceException
	 */
	public List<MotivoEstadoType> buscarTodosLosMotivos() throws InternalServiceException;

}
