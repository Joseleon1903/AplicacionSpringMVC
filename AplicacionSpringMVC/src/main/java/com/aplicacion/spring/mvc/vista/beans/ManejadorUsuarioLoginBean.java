package com.aplicacion.spring.mvc.vista.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aplicacion.spring.mvc.interfaces.beans.IUsuarioES;
import com.aplicacion.spring.mvc.session.beans.UsuarioSession;
import com.aplication.spring.mvc.layer.type.UsuarioType;
import com.aplication.spring.mvc.util.ValidationUtil;

@Component("ManejadorUsuarioLoginBean")
public class ManejadorUsuarioLoginBean {
	
	@Autowired
	private UsuarioSession sessionUsuario;
	
	@Autowired
	private IUsuarioES usuarioES;

	public ManejadorUsuarioLoginBean() {
	}
	
	public void loginUsuario(String nombre, String password){
		UsuarioType user = null;
		if (!ValidationUtil.isStringNotNullOrEmpty(nombre)) {
			user = usuarioES.buscarUsuarioPorCodigo(nombre);
		}
		if (!ValidationUtil.isStringNotNullOrEmpty(password) && user.getPassword().equals(password)) {
			sessionUsuario.setNombre(nombre);
			sessionUsuario.setAutenticado(true);
			sessionUsuario.setUsuarioId(user.getUsuarioId());
		}
	}
	
	

}
