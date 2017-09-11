package com.aplicacion.spring.mvc.vista.beans;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class ListaEmailEnviadasBean {
	
	private Integer envioId;
	private Date fechaEnvio;
	private String usuarioEnvio;
	private String asunto;
	private String destinatario;
	private String estado;


	public ListaEmailEnviadasBean() {
		// TODO Auto-generated constructor stub
	}

	public Integer getEnvioId() {
		return envioId;
	}

	public void setEnvioId(Integer envioId) {
		this.envioId = envioId;
	}

	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
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
		return "ListaEmailEnviadasBean [envioId=" + envioId + ", fechaEnvio=" + fechaEnvio + ", usuarioEnvio="
				+ usuarioEnvio + ", asunto=" + asunto + ", destinatario=" + destinatario + ", estado=" + estado + "]";
	}
	
}
