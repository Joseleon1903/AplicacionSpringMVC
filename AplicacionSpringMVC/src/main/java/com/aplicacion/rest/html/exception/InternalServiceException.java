package com.aplicacion.rest.html.exception;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="InternalServiceException")
public class InternalServiceException extends ServiceFault {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3328025625408591438L;

	public static final String DESCRIPCION = "ERROR INTERNO DEL SERVICO CONTACTAR EL ADMINISTRADOR DEL SISTEMA";
	public static final Integer CODIGO = 1604;
	
	private String descripcion;
	private Integer codigoError;
	
	public InternalServiceException(Integer codigo, String descripcion) {
		super(codigo, descripcion);
		this.codigoError = codigo;
		this.descripcion = descripcion;
	}
	
	public InternalServiceException() {
		this.codigoError = CODIGO;
		this.descripcion = DESCRIPCION;
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
		return "InternalServiceException: "+ codigoError+ " : "+ descripcion;
	}
	
}
