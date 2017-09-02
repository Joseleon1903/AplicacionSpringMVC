package com.aplication.spring.mvc.util;

public final class ValidationUtil {

	private ValidationUtil() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Descripcion: devuelve true si el objeto por parametro esta nulo.
	 * 
	 * @param objeto
	 * @return boolean
	 */
	public static boolean isObjectNotNull(Object objeto){
		if (objeto == null) {
			return true;
		}
		return false;		
	}

	/**
	 * Descripcion: devuelve true si el objeto por parametro esta nulo.
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isStringNotNullOrEmpty(String string) {
		if (string == null || string.isEmpty()) {
			return true;
		}
		return false;
	}

}
