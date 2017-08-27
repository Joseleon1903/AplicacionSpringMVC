package com.aplication.spring.mvc.exception;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "NotFoundObjectError")
public class NotFoundObjectError extends ServiceFault {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2509272058280749768L;
	
	public static final String DESCRIPCION = "ERROR NO SE PUDO ENCONTRAR EL OBJETO SOLICITADO";
	public static final Integer CODIGO = 404;

	private String descripcion;
	private Integer codigoError;

	public NotFoundObjectError(Integer codigo, String descripcion) {
		super(codigo, descripcion);
		this.codigoError = codigo;
		this.descripcion = descripcion;
	}
	
	public NotFoundObjectError() {
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
