package com.aplicacion.rest.html.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;

import com.aplicacion.rest.html.dao.UsuarioDao;
import com.aplicacion.rest.html.entity.Usuario;
import com.aplicacion.rest.html.jpa.util.AbstractJpaDao;
import com.aplicacion.rest.html.jpa.util.ParameterExpression;
import com.aplicacion.rest.html.jpa.util.PersistenceManager;

public class UsuarioDaoImpl extends AbstractJpaDao<Integer, Usuario> implements UsuarioDao{

	
	public UsuarioDaoImpl(PersistenceManager persistenceManager) {
		super(persistenceManager);
	}
	
	@Override
	public Usuario buscarUsuarioPorId(Integer id) throws PersistenceException {
		Usuario user = buscarEntityPorId(Usuario.class,id);
		return user;
	}

	@Override
	public List<Usuario> buscarTodosLosUsuarios() {
		 List<Usuario> out = buscarEntityListPorNameQueryConRetorno(Usuario.Query.BUSCAR_TODOS, null);
	     return out; 
	}


	@Override
	public Integer registrarUsuario(Usuario usuario) throws PersistenceException {
		Integer idUsuario = usuario.getUsuarioId();
		registrarEntity(usuario);
		return idUsuario;
	}


	@Override
	public Usuario buscarUsuarioPorCodigo(String codigo) throws  NonUniqueResultException, NoResultException {
		Usuario usuario = null;
		ParameterExpression parametros =  new ParameterExpression();
		parametros.addParam("codigoUsuario", codigo);
		usuario =  buscarEntityPorNameQueryConRetorno(Usuario.Query.BUSCAR_POR_CODIGO_USUARIO, parametros);
		return usuario;
	}

}
