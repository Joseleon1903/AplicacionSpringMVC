package com.aplicacion.spring.mvc.repository.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aplicacion.spring.mvc.ejb.impl.UsuarioEjbImpl;
import com.aplicacion.spring.mvc.interfaces.IUsuarioES;
import com.aplicacion.spring.mvc.interfaces.impl.UsuarioESImpl;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.layer.type.UsuarioType;

@Repository("UsuarioDao")
@Transactional
public class UsuarioRepositoryDao {

	private static final Logger logger = Logger.getLogger(UsuarioEjbImpl.class.getName());
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public UsuarioRepositoryDao() {
		// TODO Auto-generated constructor stub
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
		IUsuarioES dao = new UsuarioESImpl(entityManager);
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
		IUsuarioES dao = new UsuarioESImpl(entityManager);
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
	
	public UsuarioType buscarUsuarioPorUsuarioId(Integer usuarioId) throws InternalServiceException{
		logger.info("Entrando en la capacidad buscarUsuarioPorUsuarioId");
		IUsuarioES dao = new UsuarioESImpl(entityManager);
		UsuarioType user = null;
		try {
			user = dao.buscarUsuarioPorId(usuarioId);
		} catch (InternalServiceException e) {
			logger.info("ERROR realizando la consulta..");
			logger.info(e.getMessage());
			throw new InternalServiceException();
		}
		logger.info("Saliendo del metodo buscarUsuarioPorUsuarioId");
		logger.info("Returning: "+user );
		return user;
	}
	
	public boolean actualizarUsuarioSistema(UsuarioType user) throws InternalServiceException{
		logger.info("Entrando en la capacidad actualizarUsuarioSistema");
		IUsuarioES dao = new UsuarioESImpl(entityManager);
		Boolean registrado = false;
		try {
			registrado = dao.ActualizarUsuarioSistema(new UsuarioType().toEntity(user));
		} catch (InternalServiceException e) {
			logger.info("ERROR realizando la actualizacion..");
			logger.info(e.getMessage());
			throw new InternalServiceException();
		}
		logger.info("Saliendo del metodo actualizarUsuarioSistema");
		logger.info("Returning: "+user );
		return registrado;
	}
	
	public UsuarioType buscarUsuarioPorNombre(String codigoUsuario) throws InternalServiceException{
		logger.info("Entrando en la capacidad buscarUsuarioPorCodigo");
		IUsuarioES dao = new UsuarioESImpl(entityManager);
		UsuarioType user = null;
		try {
			user = dao.buscarUsuarioNombre(codigoUsuario);
		} catch (InternalServiceException e) {
			logger.info("ERROR realizando la consulta..");
			logger.info(e.getMessage());
			throw new InternalServiceException();
		}
		logger.info("Saliendo del metodo buscarUsuarioPorCodigo");
		logger.info("Returning: "+user );
		return user;
	}



}
