package com.aplicacion.rest.html.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;

import com.aplicacion.rest.html.entity.Usuario;

public interface UsuarioDao {
	
	/**
	 * buscar todos los usuario
	 * 
	 * @return List<IUsuario>
	 */
	List<Usuario> buscarTodosLosUsuarios();
	
	/**
	 * Descripcion: buscar el usuario con el Id provisto por parametro.
	 * 
	 * @param id
	 * @return
	 * @throws PersistenceException
	 */
	Usuario buscarUsuarioPorId(Integer id) throws PersistenceException;
	
	/**
	 * Descripcion: registra el usuario por parametro.
	 * 
	 * @param usuario
	 * @return Integer
	 * @throws PersistenceException
	 */
	Integer registrarUsuario(Usuario usuario) throws PersistenceException;
	
	/**
	 * Descripcion: busca un usuario por el codigoUsuario.
	 * 
	 * @param codigo
	 * @return IUsuario
	 * @throws PersistenceException
	 */
	Usuario buscarUsuarioPorCodigo(String codigo) throws NoResultException,  NonUniqueResultException;

}
