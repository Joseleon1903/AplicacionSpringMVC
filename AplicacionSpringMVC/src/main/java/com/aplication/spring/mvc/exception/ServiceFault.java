package com.aplication.spring.mvc.exception;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ServiceFault")
public abstract class ServiceFault extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4949827611631059343L;
	
	public String descripcion;
	public Integer codigo;
	
	public ServiceFault(Integer codigo,String descripcion) {
		super();
		this.descripcion = descripcion;
		this.codigo = codigo;
	}
	
	public ServiceFault() {
		super();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "ServiceFault [descripcion=" + descripcion + ", codigo=" + codigo + "]";
	}

}
