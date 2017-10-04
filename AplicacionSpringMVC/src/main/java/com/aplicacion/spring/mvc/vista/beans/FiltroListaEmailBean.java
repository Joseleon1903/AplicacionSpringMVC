package com.aplicacion.spring.mvc.vista.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class FiltroListaEmailBean {
	
	private String usuarioEnvio;
	private String asunto;
	private String destinatario;
	private String estado;

	public FiltroListaEmailBean() {
		// TODO Auto-generated constructor stub
	}

	public String getUsuarioEnvio() {
		return usuarioEnvio;
	}

	public void setUsuarioEnvio(String usuarioEnvio) {
		this.usuarioEnvio = usuarioEnvio;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "FiltroListaEmailBean [usuarioEnvio=" + usuarioEnvio + ", asunto=" + asunto + ", destinatario="
				+ destinatario + ", estado=" + estado + "]";
	}

}
