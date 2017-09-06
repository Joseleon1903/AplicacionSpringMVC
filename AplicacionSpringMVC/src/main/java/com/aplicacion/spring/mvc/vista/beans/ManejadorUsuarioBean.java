package com.aplicacion.spring.mvc.vista.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.aplicacion.spring.mvc.interfaces.IUsuarioES;
import com.aplicacion.spring.mvc.interfaces.impl.UsuarioESImpl;
import com.aplicacion.spring.mvc.session.beans.UsuarioSession;
import com.aplication.spring.mvc.jpa.util.PersistenceManager;
import com.aplication.spring.mvc.layer.type.UsuarioType;
import com.aplication.spring.mvc.util.ValidationUtil;

@Service
@Scope(value="prototype")
public class ManejadorUsuarioBean {
	
	private PersistenceManager persistence;
	
	private IUsuarioES usuarioES;
	
	public ManejadorUsuarioBean() {
	}
	
	public String loginUsuario(String nombre, String password, UsuarioSession sessionUsuario){
		UsuarioType user = null;
		usuarioES = new UsuarioESImpl(persistence);
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
