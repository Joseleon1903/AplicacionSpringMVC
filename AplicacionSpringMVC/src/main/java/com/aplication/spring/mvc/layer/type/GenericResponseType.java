package com.aplication.spring.mvc.layer.type;

import java.io.Serializable;

import com.aplication.spring.mvc.exception.ServiceFault;

public class GenericResponseType implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3633045803435869934L;

	public ServiceFault error;
	
	public Object respuesta;
	
	
	public GenericResponseType(){}
	

	public Object getRespuesta() {
		return respuesta;
	}
	
	public void setRespuesta(Object respuesta) {
		this.respuesta = respuesta;
	}

	public ServiceFault getError() {
		return error;
	}

	public void setError(ServiceFault error) {
		this.error = error;
	}


	@Override
	public String toString() {
		return "GenericResponseType [error=" + error + ", respuesta=" + respuesta + "]";
	}
	

}
