package com.aplicacion.spring.mvc.vista.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class EnviarEmailBean {
	
	private String destinatario;
	private String asunto;
	private String contenido;

	public EnviarEmailBean() {
		// TODO Auto-generated constructor stub
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	@Override
	public String toString() {
		return "EnviarEmailBean [destinatario=" + destinatario + ", asunto=" + asunto + ", contenido=" + contenido
				+ "]";
	}
	
}
