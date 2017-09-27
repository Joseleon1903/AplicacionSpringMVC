package com.aplicacion.spring.mvc.constante;

public class ParametrosErrorConstantes {

	/**
	 * CODIGO: 1909
	 * 
	 */
	public static final Integer DATOS_REQUERIDO_ERROR_COD = 1909;
	public static final String PARAMETRO_REQUERIDO = "[NOT FOUND  OBJECT] Existen datos requeridos no porporcionados.";
	
	/**
	 * CODIGO: 1919
	 * 
	 */
	public static final Integer PARAMETRO_FUERA_DE_RANGO_COD = 1919;
	public static final String PARAMETRO_FUERA_DE_RANGO = "[Invalid OBJECT ERROR] el campo se encuentra fuera del rango permitido.";


	/**
	 * CODIGO: 502 
	 * 
	 */
	public static final Integer USUARIO_INVALIDO_COD = 502;
	public static final String USUARIO_INVALIDO = "[Invalid User Error] Error en el inicio de sesión del servicio de perfil de usuario.";
	
	/**
	 * CODIGO: 504
	 *  
	 */
	public static final Integer INCIDENCIA_PASSWORD_ERROR_COD = 504;
	public static final String INCIDENCIA_PASSWORD_ERROR = "[Invalid OBJECT ERROR] Atención Las passwords deben de coincidir.";

	/**
	 * CODIGO: 802
	 *  
	 */
	public static final Integer USERNAME_DUPLICADO_ERROR_COD = 802;
	public static final String USERNAME_DUPLICADO_ERROR = "[DUPLICATE OBJECT ERROR] el username del nuevo usuario se encuentra ya registrado.";

	/**
	 * CODIGO: 500
	 * 
	 */
	public static final Integer INTERNAL_SERVER_ERROR_COD = 500;
	public static final String INTERNAL_SERVER_ERROR = "[Internal Server Error] Error Interno en el Servidor.'";

	
}
