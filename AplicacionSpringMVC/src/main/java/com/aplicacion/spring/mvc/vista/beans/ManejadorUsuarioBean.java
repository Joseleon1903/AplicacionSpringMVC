package com.aplicacion.spring.mvc.vista.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.aplicacion.spring.mvc.session.beans.UsuarioSession;

@Service
@Scope(value="prototype")
public class ManejadorUsuarioBean {
	
	public ManejadorUsuarioBean() {
	}
	
	public void loginUsuario(String nombre, String password){
//		UsuarioType user = null;
//		if (!ValidationUtil.isStringNotNullOrEmpty(nombre)) {
//			user = usuarioES.buscarUsuarioPorCodigo(nombre);
//		}
//		if (!ValidationUtil.isStringNotNullOrEmpty(password) && user.getPassword().equals(password)) {
//			sessionUsuario.setNombre(nombre);
//			sessionUsuario.setAutenticado(true);
//			sessionUsuario.setUsuarioId(user.getUsuarioId());
//		}
	}
	
	public String validandoSession(UsuarioSession session){
		if (session.isAutenticado()) {
			return "portal/pagina/jsp/Home";
		}
		return "index";		
	}

}
