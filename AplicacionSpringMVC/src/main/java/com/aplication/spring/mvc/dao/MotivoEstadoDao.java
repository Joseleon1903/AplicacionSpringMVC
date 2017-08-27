/**
 * 
 */
package com.aplication.spring.mvc.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import com.aplication.spring.mvc.entity.MotivoEstado;
import com.aplication.spring.mvc.exception.InternalServiceException;

/**
 * @author Jose Eduardo
 *
 */
public interface MotivoEstadoDao {
	
	/**
	 * Descripcion:Metodo que busca el motivo por el id
	 * 
	 * @param id
	 * @return MotivoEstadoType
	 * @throws InternalServiceException
	 */
	public MotivoEstado buscarMotivoEstadoPorId(Integer id) throws PersistenceException;
	
	/**
	 * Descripcion:Metodo que busca todos los motivos del sistema
	 * 
	 * @return List<MotivoEstado>
	 * @throws PersistenceException
	 */
	public List<MotivoEstado> buscarTodosLosMotivos() throws PersistenceException;

}
