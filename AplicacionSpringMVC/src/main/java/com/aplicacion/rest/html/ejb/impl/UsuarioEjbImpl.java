package com.aplicacion.rest.html.ejb.impl;

import javax.ejb.Stateful;

import org.jboss.logging.Logger;

import com.aplicacion.spring.mvc.interfaces.IUsuarioES;
import com.aplicacion.spring.mvc.interfaces.impl.UsuarioESImpl;
import com.aplication.spring.mvc.jpa.util.PersistenceManager;
import com.aplication.spring.mvc.layer.type.UsuarioType;

@Stateful
public class UsuarioEjbImpl {
	
	private static final Logger logger = Logger.getLogger(UsuarioEjbImpl.class.getName());
	
	private PersistenceManager persistenceManager;
	
	public UsuarioEjbImpl() {
	}

	public UsuarioType buscarUsuarioPorCodigo(String codigoUsuario){
		logger.info("Entrando en la capacidad buscarUsuarioPorCodigo");
		IUsuarioES dao = new UsuarioESImpl(persistenceManager);
		UsuarioType user = dao.buscarUsuarioPorCodigo(codigoUsuario);
		logger.info("Saliendo del metodo buscarUsuarioPorCodigo");
		logger.info("Returning: "+user );
		return user;
	}

//	@Override
//	public Integer registrarNuevoUsuarioSistema(UsuarioType usuario) throws InternalServiceException {
//		UsuarioDao dao = new UsuarioDaoImpl(persistenceManager);
//		return dao.registrarUsuario(new UsuarioType().toEntity(usuario));
//	}
//	
//	public UsuarioType buscarusuarioPorId(Integer usuarioId)throws InternalServiceException{
//		UsuarioType userType = new UsuarioType();
//		UsuarioDao dao = new UsuarioDaoImpl(persistenceManager);
//		Usuario user = null;
//		user = dao.buscarUsuarioPorId(usuarioId);
//		userType = new UsuarioType().toType(user);
//		return userType;
//	}

}
