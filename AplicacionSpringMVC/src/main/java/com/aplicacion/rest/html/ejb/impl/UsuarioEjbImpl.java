package com.aplicacion.rest.html.ejb.impl;

import javax.ejb.Stateful;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import com.aplicacion.rest.html.dao.UsuarioDao;
import com.aplicacion.rest.html.dao.impl.UsuarioDaoImpl;
import com.aplicacion.rest.html.ejb.interfaces.IUsuario;
import com.aplicacion.rest.html.entity.Usuario;
import com.aplicacion.rest.html.exception.InternalServiceException;
import com.aplicacion.rest.html.exception.NotFoundObjectError;
import com.aplicacion.rest.html.jpa.util.PersistenceManager;
import com.aplicacion.rest.html.layer.type.MotivoEstadoType;
import com.aplicacion.rest.html.layer.type.UsuarioType;
import com.aplicacion.rest.html.util.BuscarMotivoEstadoUtil;

@Stateful
public class UsuarioEjbImpl implements IUsuario {
	
	private PersistenceManager persistenceManager;
	
	public UsuarioEjbImpl() {
	}

	@Override
	public UsuarioType buscarUsuarioPorCodigo(String codigoUsuario) throws InternalServiceException, NotFoundObjectError {
		UsuarioType userType = new UsuarioType();
		UsuarioDao dao = new UsuarioDaoImpl(persistenceManager);
		Usuario user = null;
		try {
			user = dao.buscarUsuarioPorCodigo(codigoUsuario);
		} catch (NoResultException ex) {
			MotivoEstadoType motivo = BuscarMotivoEstadoUtil.buscarMotivoPorId(504);
			throw new NotFoundObjectError(motivo.getMotivoId(), motivo.getDescripcion());
		}catch (PersistenceException e) {
			MotivoEstadoType motivo = BuscarMotivoEstadoUtil.buscarMotivoPorId(500);
			throw new NotFoundObjectError(motivo.getMotivoId(), motivo.getDescripcion());
		}
		userType = new UsuarioType().toType(user);
		return userType;
	}

	@Override
	public Integer registrarNuevoUsuarioSistema(UsuarioType usuario) throws InternalServiceException {
		UsuarioDao dao = new UsuarioDaoImpl(persistenceManager);
		return dao.registrarUsuario(new UsuarioType().toEntity(usuario));
	}
	
	public UsuarioType buscarusuarioPorId(Integer usuarioId)throws InternalServiceException{
		UsuarioType userType = new UsuarioType();
		UsuarioDao dao = new UsuarioDaoImpl(persistenceManager);
		Usuario user = null;
		user = dao.buscarUsuarioPorId(usuarioId);
		userType = new UsuarioType().toType(user);
		return userType;
	}

}
