package com.aplicacion.spring.mvc.vista.beans;

import org.springframework.stereotype.Service;

import com.aplicacion.spring.mvc.ejb.impl.UsuarioEjbImpl;
import com.aplicacion.spring.mvc.session.beans.UsuarioSession;
import com.aplication.spring.mvc.layer.type.UsuarioType;
import com.aplication.spring.mvc.util.ValidationUtil;

@Service
public class ManejadorUsuarioBean {
		
	private UsuarioEjbImpl usuarioES = new UsuarioEjbImpl();
	
	public ManejadorUsuarioBean() {
	}
	
	public String loginUsuario(String nombre, String password, UsuarioSession sessionUsuario){
		UsuarioType user = null;
		if (!ValidationUtil.isStringNotNullOrEmpty(nombre)) {
			user = usuarioES.buscarUsuarioPorCodigo(nombre);
		}
		if (!ValidationUtil.isStringNotNullOrEmpty(password) && user.getPassword().equals(password)) {
			sessionUsuario.setNombre(nombre);
			sessionUsuario.setAutenticado(true);
			sessionUsuario.setUsuarioId(user.getUsuarioId());
			return "portal/pagina/jsp/Home";
		}
		return "index";
	}
	
	public String validandoSession(UsuarioSession session){
		if (session.isAutenticado()) {
			return "portal/pagina/jsp/Home";
		}
		return "index";		
	}

}
