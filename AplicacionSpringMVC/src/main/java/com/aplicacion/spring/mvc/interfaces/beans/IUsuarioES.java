package com.aplicacion.spring.mvc.interfaces.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aplication.spring.mvc.layer.type.UsuarioType;

@Service
@Scope("prototype")
@Transactional
public interface IUsuarioES {

	public UsuarioType buscarUsuarioPorCredenciales(String nombre, String password);


}
