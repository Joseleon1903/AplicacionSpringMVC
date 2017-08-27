package com.aplicacion.rest.html.exception;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DatoRequeridoNoProporcionadoException")
public class DatoRequeridoNoProporcionadoException extends ServiceFault{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6596636367499678371L;
	
	public static final String DESCRIPCION = "EXISTEN DATOS REQUERIDO NO PROPORCIONADO";
	public static final Integer CODIGO = 1909;

	private String descripcion;
	private Integer codigoError;
	
	public DatoRequeridoNoProporcionadoException(Integer codigo, String descripcion) {
		super(codigo, descripcion);
		this.codigoError = codigo;
		this.descripcion = descripcion;
	}
	
	public DatoRequeridoNoProporcionadoException() {
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
		return "InvalidObjectError [descripcion=" + descripcion + ", codigoError=" + codigoError + "]";
	}

}
