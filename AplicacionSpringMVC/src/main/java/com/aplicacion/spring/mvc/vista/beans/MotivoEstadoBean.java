package com.aplicacion.spring.mvc.vista.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class MotivoEstadoBean {
	
	private Integer motivoId;
	private String descripcion;
	private String estado;

	public MotivoEstadoBean() {
		// TODO Auto-generated constructor stub
	}

	public Integer getMotivoId() {
		return motivoId;
	}

	public void setMotivoId(Integer motivoId) {
		this.motivoId = motivoId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "MotivoEstadoBean [motivoId=" + motivoId + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}

}
