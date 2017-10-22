package com.aplicacion.spring.mvc.jdbc.query;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.aplication.spring.mvc.layer.type.ContactoType;
import com.aplication.spring.mvc.layer.type.DetalleContactoType;
import com.aplication.spring.mvc.layer.type.UsuarioType;

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
		String INSERT_USUARIO          = "INSERT INTO USUARIO(USUARIO_ID, CODIGO_USUARIO,PASSWORD,FECHA_CREACION,FECHA_ULTIMO_ACCESO,CONTACTO_ID)"+ 
                                           "VALUES(?,?,?,?,?,?)";
		
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
	
	public static PreparedStatement agregarUsuarioStatement(PreparedStatement preparedStatement , UsuarioType user, Integer index) throws SQLException{
		preparedStatement.setInt(1, index);
		preparedStatement.setString(2, user.getCodigoUsuario());
		preparedStatement.setString(3, user.getPassword());
		preparedStatement.setDate(4, new java.sql.Date(user.getFechaCreacion().getTime()));
		preparedStatement.setDate(5, new java.sql.Date(user.getFechaUltimoAcceso().getTime()));
		preparedStatement.setInt(6, index);		
		return preparedStatement;
	}
	
	public static PreparedStatement agregarContactoStatement(PreparedStatement preparedStatement, ContactoType contacto,Integer index) throws SQLException {
		preparedStatement.setInt(1, index);
		preparedStatement.setString(2, contacto.getNombre());
		preparedStatement.setString(3, contacto.getApellido());
		preparedStatement.setString(4, contacto.getSexo());
		preparedStatement.setDate(5,  new java.sql.Date(contacto.getFechaNacimiento().getTime()));
		preparedStatement.setString(6, contacto.getEmail());
		preparedStatement.setInt(7, index);
		preparedStatement.setString(8, contacto.getEstado());
		return preparedStatement;
	}
	
	public static PreparedStatement agregarDetalleContactoStatement(PreparedStatement preparedStatement , DetalleContactoType detalle, Integer index) throws SQLException{
		preparedStatement.setInt(1, index);
		preparedStatement.setString(2, detalle.getCorreoAlterno());
		preparedStatement.setString(3, detalle.getDireccion());
		preparedStatement.setString(4, detalle.getTelefono());
		preparedStatement.setString(5, detalle.getCelular());
		return preparedStatement;
	}

}
