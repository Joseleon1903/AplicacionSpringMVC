package com.aplicacion.spring.mvc.interfaces.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.aplication.spring.mvc.entity.Usuario;
import com.aplication.spring.mvc.layer.type.UsuarioType;

@Service
@Scope("prototype")
public interface IUsuarioES {

	public UsuarioType buscarUsuarioPorCodigo(String nombre);
	
	public boolean ActualizarAccesoUsuario(Usuario usuario);
	
	public boolean registrarUsuario(Usuario usuario);

}
