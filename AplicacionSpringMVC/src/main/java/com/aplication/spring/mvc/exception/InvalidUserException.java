package com.aplication.spring.mvc.exception;

public class InvalidUserException extends ServiceFault{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 910066112723597804L;

	public static final String DESCRIPCION = "ERROR DE SESSION DEL PERFIL DE USUARIO";
	public static final Integer CODIGO = 502;
	
	private String descripcion;
	private Integer codigoError;

	public InvalidUserException(Integer codigo, String descripcion) {
		super(codigo, descripcion);
		this.codigoError = codigo;
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCodigoError() {
		return codigoError;
	}

	public void setCodigoError(Integer codigoError) {
		this.codigoError = codigoError;
	}

	@Override
	public String toString() {
		return "InvalidUserException [descripcion=" + descripcion + ", codigoError=" + codigoError + "]";
	}
	
}
