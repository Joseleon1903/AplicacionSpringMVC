package com.aplication.spring.mvc.exception;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "NoSuchEntityException")
public class NoSuchEntityException extends ServiceFault {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7857001746027969475L;

	public static final String DESCRIPCION = "ERROR INTERNO NO SE PUDO ENCONTRAR LA INFORMACION SOLICITADA";
	public static final Integer CODIGO = 500;

	private String descripcion;
	private Integer codigoError;

	public NoSuchEntityException(Integer codigo, String descripcion) {
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
		return "NoSuchEntityException [descripcion=" + descripcion + ", codigoError=" + codigoError + "]";
	}

}
