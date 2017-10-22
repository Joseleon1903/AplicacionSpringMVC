package com.aplicacion.spring.mvc.jdbc.query;

public class UsuarioQuerySQL {
	
	/**
	 * 
	 * @author Jose Eduardo
	 * @Descripcion nombre tablas de usuario
	 *
	 */
	public static interface Tablas{
		String USUARIO_TBL          = "USUARIO";
		String CONTACTO_TBL         = "CONTACTO";
		String DETALLE_CONTACTO_TBL = "DETALLE_CONTACTO";
	}
	
	/**
	 * 
	 * @author Jose Eduardo
	 * @category Query
	 * @Descripcion Query para insertar un nuevo usuario en el sistema.
	 *
	 */
	public static interface Insert{
		
		/**
		 * Inserta nuevo Usuario en la tabla USUARIO
		 */
		String INSERT_USUARIO          = "INSERT INTO USUARIO(CODIGO_USUARIO,PASSWORD,FECHA_CREACION,FECHA_ULTIMO_ACCESO,CONTACTO_ID)"+ 
                                           "VALUES(?,?,?,?,?)";
		
		/**
		 * Inserta nuevo Usuario en la tabla CONTACTO
		 */
		String INSERT_CONTACTO         = "INSERT INTO CONTACTO (CONTACTO_ID,NOMBRE,APELLIDO,SEXO, FECHA_NACIMIENTO,EMAIL, DETALLE_CONTACTO_ID,ESTADO)"+
                                         "VALUES(?,?,?,?,?,?,?,?)";
		
		/**
		 * Inserta nuevo Usuario en la tabla DETALLE_CONTACTO
		 */
		String INSERT_DETALLE_CONTACTO = "INSERT INTO DETALLE_CONTACTO (DETALLE_CONTACTO_ID,EMAIL_ALTERNATIVA,DIRECCION,TELEFONO,CELULAR) "+
		                                  "VALUES(?,?,?,?,?)";
	}
	
	public static String QUERY_VALOR_AUTOINCREMENT(String nombreTabla){
		
		return "select auto_increment from `information_schema`.tables where TABLE_SCHEMA = 'aplicacion_web_rest' "+
                "and TABLE_NAME ='"+nombreTabla+"'";
	}
	

}
