package com.aplicacion.spring.mvc.interfaces;

import com.aplication.spring.mvc.entity.Usuario;
import com.aplication.spring.mvc.layer.type.UsuarioType;

public interface IUsuarioES {

	public UsuarioType buscarUsuarioPorCodigo(String nombre);

	public boolean ActualizarAccesoUsuario(Usuario usuario);

	public boolean registrarUsuario(Usuario usuario);

}
