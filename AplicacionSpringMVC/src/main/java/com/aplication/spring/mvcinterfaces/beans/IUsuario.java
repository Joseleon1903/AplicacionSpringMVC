package com.aplication.spring.mvcinterfaces.beans;

import javax.ejb.Remote;

import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.exception.NotFoundObjectError;
import com.aplication.spring.mvc.layer.type.UsuarioType;

@Remote
public interface IUsuario {

	/**
	 * Descripcion: Permite buscar un usuario en base al codigo pasado por parametro.
	 * 
	 * @param codigoUsuario
	 * @return UsuarioType
	 * @throws InternalServiceException
	 * @throws NotFoundObjectError
	 */
	UsuarioType buscarUsuarioPorCodigo(String codigoUsuario) throws InternalServiceException, NotFoundObjectError;
	
	/**
	 * Descripcion: Permite guardar un usuario en base de datos.
	 * 
	 * @param usuario
	 * @return boolean
	 * @throws InternalServiceException
	 */
	Integer registrarNuevoUsuarioSistema(UsuarioType usuario) throws InternalServiceException;


}
