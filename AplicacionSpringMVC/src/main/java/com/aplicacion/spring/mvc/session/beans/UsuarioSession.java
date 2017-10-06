package com.aplicacion.spring.mvc.session.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(value="session")
public class UsuarioSession {
	
	private Integer usuarioId;
	private boolean autenticado;
	private String nombre;
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
	
	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	@Override
	public String toString() {
		return "UsuarioSession [autenticado=" + autenticado + ", nombre=" + nombre + ", error=" + error
				+ ", mensajeError=" + mensajeError + "]";
	}

	@PostConstruct
	private void init(){
		this.usuarioId = 0;
		this.autenticado = false;
		this.error = false;
		this.nombre= "NONE";
		this.mensajeError= "NONE";
		
	}
	
	@PreDestroy
	public void destroy() throws Exception {
		this.usuarioId = 0;
		this.autenticado = false;
		this.error = false;
		this.nombre = "NONE";
		this.mensajeError = "NONE";
	}

}
