package com.aplicacion.spring.mvc.ejb.impl;

import javax.ejb.Stateful;

import org.jboss.logging.Logger;

import com.aplicacion.spring.mvc.interfaces.IUsuarioES;
import com.aplicacion.spring.mvc.interfaces.impl.UsuarioESImpl;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.jpa.util.PersistenceManager;
import com.aplication.spring.mvc.layer.type.UsuarioType;

@Stateful
public class UsuarioEjbImpl {
	
	private static final Logger logger = Logger.getLogger(UsuarioEjbImpl.class.getName());
	
	private PersistenceManager persistenceManager;
	
	public UsuarioEjbImpl() {
	}

	/**
	 * Descripcion: Capacidad que permite buscar un usuario por el codigo de usuario.
	 * 
	 * @param String: codigoUsuario
	 * @return UsuarioType
	 * @throws InternalServiceException
	 */
	public UsuarioType buscarUsuarioPorCodigo(String codigoUsuario) throws InternalServiceException{
		logger.info("Entrando en la capacidad buscarUsuarioPorCodigo");
		IUsuarioES dao = new UsuarioESImpl(persistenceManager);
		UsuarioType user = null;
		try {
			user = dao.buscarUsuarioPorCodigo(codigoUsuario);
		} catch (InternalServiceException e) {
			logger.info("ERROR realizando la consulta..");
			logger.info(e.getMessage());
			throw new InternalServiceException();
		}
		logger.info("Saliendo del metodo buscarUsuarioPorCodigo");
		logger.info("Returning: "+user );
		return user;
	}
	
	/**
	 * Descripcion: Capacidad que permite registar un nuevo usuario en el repositorio de USUARIO y CONTACTO del sistema.
	 *              Devuelve TRUE si el usuario fue registrado exitosamente, FALSE de lo contrario.
	 * 
	 * @param UsuarioType
	 * @return boolean
	 * @throws InternalServiceException
	 */
	public boolean registrarNuevoUsuarioSistema(UsuarioType user) throws InternalServiceException{
		logger.info("Entrando en la capacidad registrarNuevoUsuarioSistema");
		IUsuarioES dao = new UsuarioESImpl(persistenceManager);
		Boolean registrado = false;
		try {
			registrado = dao.registrarUsuario(new UsuarioType().toEntity(user));
		} catch (InternalServiceException e) {
			logger.info("ERROR realizando la consulta..");
			logger.info(e.getMessage());
			throw new InternalServiceException();
		}
		logger.info("Saliendo del metodo buscarUsuarioPorCodigo");
		logger.info("Returning: "+user );
		return registrado;
	}

}
