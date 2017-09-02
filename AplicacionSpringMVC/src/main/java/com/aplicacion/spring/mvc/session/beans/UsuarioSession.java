package com.aplicacion.spring.mvc.session.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("session")
public class UsuarioSession {
	
	private boolean autenticado;
	private String nombre;
	private Integer usuarioId;
	
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
	

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	@Override
	public String toString() {
		return "UsuarioSession [autenticado=" + autenticado + ", nombre=" + nombre + ", usuarioId=" + usuarioId + "]";
	}

}
