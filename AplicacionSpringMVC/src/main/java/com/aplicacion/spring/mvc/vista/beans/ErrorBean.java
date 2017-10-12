package com.aplicacion.spring.mvc.vista.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class ErrorBean {
	
	private String descripcionError;
	private Integer codigo;
	private Integer usuarioId;
	private String nombreUsuario;
	
	public ErrorBean() {
		// TODO Auto-generated constructor stub
	}

	public String getDescripcionError() {
		return descripcionError;
	}

	public void setDescripcionError(String descripcionError) {
		this.descripcionError = descripcionError;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@Override
	public String toString() {
		return "ErrorBean [descripcionError=" + descripcionError + ", codigo=" + codigo + ", usuarioId=" + usuarioId
				+ ", nombreUsuario=" + nombreUsuario + "]";
	}
	

}
