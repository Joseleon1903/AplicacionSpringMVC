package com.aplication.spring.mvc.exception;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DuplicateObjectException")
public class DuplicateObjectException extends ServiceFault{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2635187262121725748L;
	public static final String DESCRIPCION = "ERROR DEL SERVICO EL OBJETO SE ENCUENTRA DUPLICADO";
	public static final Integer CODIGO = 8800;
	
	private String descripcion;
	private Integer codigoError;

	public DuplicateObjectException(Integer codigo, String descripcion) {
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
		return "DuplicateObjectException [descripcion=" + descripcion + ", codigoError=" + codigoError + "]";
	}

}
