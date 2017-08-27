package com.aplication.spring.mvc.ejb.impl;

import javax.ejb.Stateful;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import com.aplication.spring.mvc.dao.UsuarioDao;
import com.aplication.spring.mvc.dao.impl.UsuarioDaoImpl;
import com.aplication.spring.mvc.ejb.interfaces.IUsuario;
import com.aplication.spring.mvc.entity.Usuario;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.exception.NotFoundObjectError;
import com.aplication.spring.mvc.jpa.util.PersistenceManager;
import com.aplication.spring.mvc.layer.type.MotivoEstadoType;
import com.aplication.spring.mvc.layer.type.UsuarioType;
import com.aplication.spring.mvc.util.BuscarMotivoEstadoUtil;

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
