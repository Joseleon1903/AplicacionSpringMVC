package com.aplicacion.spring.mvc.session.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(value="session")
public class UsuarioSession {
	
	@Value(value= "false")
	private boolean autenticado;
	private String nombre;
	@Value(value= "false")
	private boolean error;
	private String mensajeError;
	
	public UsuarioSession() {
		// TODO Auto-generated constructor stub
	}

	public boolean isAutenticado() {
		return autenticado;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	@Override
	public String toString() {
		return "UsuarioSession [autenticado=" + autenticado + ", nombre=" + nombre + ", error=" + error
				+ ", mensajeError=" + mensajeError + "]";
	}	

}
