package com.aplicacion.rest.html.ejb.interfaces;

import javax.ejb.Remote;

import com.aplicacion.rest.html.exception.InternalServiceException;
import com.aplicacion.rest.html.exception.NotFoundObjectError;
import com.aplicacion.rest.html.layer.type.UsuarioType;

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
