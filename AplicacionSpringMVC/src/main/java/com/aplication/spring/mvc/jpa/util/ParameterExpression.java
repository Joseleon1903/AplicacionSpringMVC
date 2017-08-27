package com.aplication.spring.mvc.jpa.util;

import java.util.HashMap;

public class ParameterExpression {

	private HashMap<String, Object> parametros;
	
	public ParameterExpression() {
		parametros = new HashMap<>();
	}
	
	public void addParam(String nombreParametro, Object valor){
		parametros.put(nombreParametro, valor);
	}
	
	/**
	 * @return the parametros
	 */
	public HashMap<String, Object> getParametros() {
		if (parametros == null) {
			parametros = new HashMap<>();
		}
		return parametros;
	}

	/**
	 * @param parametros the parametros to set
	 */
	public void setParametros(HashMap<String, Object> parametros) {
		this.parametros = parametros;
	}

	@Override
	public String toString() {
		return "ParameterExpression [parametros=" + parametros + "]";
	}
	
}
