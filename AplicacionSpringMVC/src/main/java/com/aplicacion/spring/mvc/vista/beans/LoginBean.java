package com.aplicacion.spring.mvc.vista.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class LoginBean {
	
	private String codigoUsuario;
	private String password;
	private String MensajeVista;

	public LoginBean() {
		// TODO Auto-generated constructor stub
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMensajeVista() {
		return MensajeVista;
	}

	public void setMensajeVista(String mensajeVista) {
		MensajeVista = mensajeVista;
	}

}
