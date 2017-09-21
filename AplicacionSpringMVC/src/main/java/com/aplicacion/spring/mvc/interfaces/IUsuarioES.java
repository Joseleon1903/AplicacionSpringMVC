package com.aplicacion.spring.mvc.interfaces;

import com.aplication.spring.mvc.entity.Usuario;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.layer.type.UsuarioType;

public interface IUsuarioES {

	public UsuarioType buscarUsuarioPorCodigo(String nombre) throws InternalServiceException;

	public boolean ActualizarAccesoUsuario(Usuario usuario);

	public boolean registrarUsuario(Usuario usuario) throws InternalServiceException;

}
