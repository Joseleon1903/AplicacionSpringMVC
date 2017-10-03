package com.aplicacion.spring.mvc.interfaces.impl;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;

import org.jboss.logging.Logger;

import com.aplicacion.spring.mvc.interfaces.IUsuarioES;
import com.aplication.spring.mvc.entity.Usuario;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.jpa.util.AbstractJpaDao;
import com.aplication.spring.mvc.jpa.util.ParameterExpression;
import com.aplication.spring.mvc.jpa.util.PersistenceManager;
import com.aplication.spring.mvc.layer.type.UsuarioType;

public class UsuarioESImpl extends AbstractJpaDao<Integer, Usuario> implements IUsuarioES{
	
	private static final Logger logger = Logger.getLogger(UsuarioESImpl.class.getName());

	public UsuarioESImpl(PersistenceManager persistenceManager) {
		super(persistenceManager);
	}

	@Override
	public UsuarioType buscarUsuarioPorCodigo(String nombre) throws InternalServiceException {
		ParameterExpression parametros = new ParameterExpression();
		parametros.addParam("codigoUsuario", nombre);
		Usuario user = null;
		try {
			user = buscarEntityPorNameQueryConRetorno(Usuario.NameQuery.BUSCAR_POR_CODIGO_USUARIO, parametros);
		} catch (NoResultException | NonUniqueResultException e) {
			throw new InternalServiceException();
		}
		return new UsuarioType().toType(user);
	}

	@Override
	public boolean ActualizarUsuarioSistema(Usuario usuario) throws InternalServiceException{
		boolean exitoso = actualizarEntity(Usuario.class, usuario.getUsuarioId(), usuario);
		return exitoso;
	}

	@Override
	public boolean registrarUsuario(Usuario usuario) throws InternalServiceException {
		try {
			registrarEntity(usuario);
		} catch (PersistenceException e) {
			logger.info("ERROR: "+e.getMessage());
			throw new InternalServiceException();
		}
		return true;
	}

	@Override
	public UsuarioType buscarUsuarioPorId(Integer usuarioId) throws InternalServiceException {

		Usuario user = null;
		try {
			user = buscarEntityPorId(Usuario.class, usuarioId);
		} catch (PersistenceException e) {
			throw new InternalServiceException();
		}
		return new UsuarioType().toType(user);
	}

}
