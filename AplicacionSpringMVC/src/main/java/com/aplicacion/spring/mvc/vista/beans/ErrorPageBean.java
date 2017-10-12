package com.aplicacion.spring.mvc.vista.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class ErrorPageBean {
	
	private Integer codigo;
	private Integer mensajeError;

	public ErrorPageBean() {
		// TODO Auto-generated constructor stub
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(Integer mensajeError) {
		this.mensajeError = mensajeError;
	}

	@Override
	public String toString() {
		return "ErrorPageBean [codigo=" + codigo + ", mensajeError=" + mensajeError + "]";
	}

}
