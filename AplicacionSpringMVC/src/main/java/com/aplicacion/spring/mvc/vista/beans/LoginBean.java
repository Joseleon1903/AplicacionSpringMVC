package com.aplicacion.spring.mvc.vista.beans;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import com.aplicacion.spring.mvc.constante.ParametrosErrorConstante;

@Component
public class LoginBean {
	
	@NotBlank(message=ParametrosErrorConstante.PARAMETRO_REQUERIDO)
	@Size(min = 3, max = 20, message=ParametrosErrorConstante.PARAMETRO_FUERA_DE_RANGO)
	private String codigoUsuario;
	@NotBlank(message=ParametrosErrorConstante.PARAMETRO_REQUERIDO)
	@Size(min = 3, max = 10, message=ParametrosErrorConstante.PARAMETRO_FUERA_DE_RANGO)
	private String password;
	
	private String mensajeError;
	private Integer codigoError;

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

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	public Integer getCodigoError() {
		return codigoError;
	}

	public void setCodigoError(Integer codigoError) {
		this.codigoError = codigoError;
	}	

}
