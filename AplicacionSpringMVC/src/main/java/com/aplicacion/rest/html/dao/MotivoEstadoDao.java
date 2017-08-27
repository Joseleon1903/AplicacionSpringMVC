/**
 * 
 */
package com.aplicacion.rest.html.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import com.aplicacion.rest.html.entity.MotivoEstado;
import com.aplicacion.rest.html.exception.InternalServiceException;

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
