package com.aplication.spring.mvc.exception;

public class InvalidDataException extends ServiceFault {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5845109811446645862L;
	
	public static final String DESCRIPCION = "EXISTEN DATOS SOLICITADOS NO PROPORCIONADO";
	public static final Integer CODIGO = 4080;

	private String descripcion;
	private Integer codigoError;
	
	public InvalidDataException(){}
	
	public InvalidDataException(Integer codigo, String descripcion, String descripcion2, Integer codigoError) {
		super(codigo, descripcion);
		descripcion = descripcion2;
		this.codigoError = codigoError;
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
		return "InvalidDataException [descripcion=" + descripcion + ", codigoError=" + codigoError + "]";
	}
	
}
