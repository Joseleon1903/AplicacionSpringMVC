package com.aplicacion.spring.mvc.interfaces;

import com.aplication.spring.mvc.entity.Usuario;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.layer.type.UsuarioType;

public interface IUsuarioES {

	public UsuarioType buscarUsuarioPorCodigo(String nombre) throws InternalServiceException;
	
	public UsuarioType buscarUsuarioPorId(Integer usuarioId) throws InternalServiceException;

	public boolean ActualizarUsuarioSistema(Usuario usuario) throws InternalServiceException;

	public boolean registrarUsuario(Usuario usuario) throws InternalServiceException;
	
	public UsuarioType buscarUsuarioNombre(String nombre) throws InternalServiceException;

}
