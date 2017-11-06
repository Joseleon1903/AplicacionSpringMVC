package com.aplicacion.spring.mvc.jdbc.query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aplication.spring.mvc.layer.type.ContactoType;
import com.aplication.spring.mvc.layer.type.DetalleContactoType;
import com.aplication.spring.mvc.layer.type.UsuarioType;
import com.aplication.spring.mvc.util.ValidationUtil;

/**
 * 
 * @author Jose Eduardo
 *
 */
public class UsuarioQuerySQL {
	
	/**
	 * 
	 * @Descripcion nombre tablas de usuario
	 *
	 */
	public static interface Tablas{
		String USUARIO_TBL          = "USUARIO";
		String CONTACTO_TBL         = "CONTACTO";
		String DETALLE_CONTACTO_TBL = "DETALLE_CONTACTO";
	}
	
	public static interface Consulta{
		
		/**
		 * Query para buscar un usuario por Id 
		 */
		String BUSCAR_USUARIO_POR_ID  = "SELECT us.USUARIO_ID, us.CODIGO_USUARIO, con.CONTACTO_ID, con.NOMBRE, con.APELLIDO, con.EMAIL, con.ESTADO, "
				+ "                            con.SEXO, con.FECHA_NACIMIENTO, con.DETALLE_CONTACTO_ID, con.ESTADO, det.DETALLE_CONTACTO_ID, det.EMAIL_ALTERNATIVA, "
				+ "                            det.TELEFONO, det.CELULAR, det.DIRECCION"
				+ "                        FROM USUARIO us JOIN CONTACTO con ON con.CONTACTO_ID = us.CONTACTO_ID"
				+ "                        LEFT JOIN DETALLE_CONTACTO det ON con.DETALLE_CONTACTO_ID = det.DETALLE_CONTACTO_ID"
				+ "                        WHERE us.USUARIO_ID = ?";
		
		/**
		 * Query para buscar un usuario codigo usuario
		 */
		String BUSCAR_USUARIO_POR_CODIGO_USUARIO  = "SELECT us.USUARIO_ID, us.CODIGO_USUARIO,us.PASSWORD, con.CONTACTO_ID, con.NOMBRE, con.APELLIDO, con.EMAIL, con.ESTADO, "
				+ "                                  con.SEXO, con.FECHA_NACIMIENTO, con.DETALLE_CONTACTO_ID, con.ESTADO, det.DETALLE_CONTACTO_ID, det.EMAIL_ALTERNATIVA, "
				+ "                                  det.TELEFONO, det.CELULAR, det.DIRECCION"
				+ "                             FROM USUARIO us JOIN CONTACTO con ON con.CONTACTO_ID = us.CONTACTO_ID"
				+ "                             LEFT JOIN DETALLE_CONTACTO det ON con.DETALLE_CONTACTO_ID = det.DETALLE_CONTACTO_ID"
				+ "                             WHERE us.CODIGO_USUARIO = ?";

	}
	
	/**
	 * 
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
		String INSERT_CONTACTO_CON_DETALLE        = "INSERT INTO CONTACTO (CONTACTO_ID,NOMBRE,APELLIDO,SEXO, FECHA_NACIMIENTO,EMAIL, DETALLE_CONTACTO_ID,ESTADO)"+
                                         "VALUES(?,?,?,?,?,?,?,?)";
		String INSERT_CONTACTO         = "INSERT INTO CONTACTO (CONTACTO_ID,NOMBRE,APELLIDO,SEXO, FECHA_NACIMIENTO,EMAIL,ESTADO)"+
                "VALUES(?,?,?,?,?,?,?)";
		/**
		 * Inserta nuevo Usuario en la tabla DETALLE_CONTACTO
		 */
		String INSERT_DETALLE_CONTACTO = "INSERT INTO DETALLE_CONTACTO (DETALLE_CONTACTO_ID,EMAIL_ALTERNATIVA,DIRECCION,TELEFONO,CELULAR) "+
		                                  "VALUES(?,?,?,?,?)";
	}
	
	public static interface Update{
		
		String ACTUALIZAR_CONTACTO_USUARIO = "UPDATE CONTACTO SET NOMBRE = ? , APELLIDO = ? , SEXO = ? , FECHA_NACIMIENTO= ?, EMAIL = ? WHERE CONTACTO_ID = ?";
		String ACTUALIZAR_DETALLE_CONTACTO_USUARIO = "UPDATE DETALLE_CONTACTO det SET det.EMAIL_ALTERNATIVA = ?, det.DIRECCION = ? , det.TELEFONO = ?, det.CELULAR = ? WHERE det.DETALLE_CONTACTO_ID = ?";
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
		if (!ValidationUtil.isObjectNotNull(contacto.getDetalleContactoId())) {
			preparedStatement.setInt(7, index);
			preparedStatement.setString(8, contacto.getEstado());
		}else{
			preparedStatement.setString(7, contacto.getEstado());
		}
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
	
	
	public static ContactoType casteoResulsetContactoType(ResultSet rs,boolean agregarContacto) throws SQLException{
		ContactoType contacto = new ContactoType();
		contacto.setContactoId(rs.getInt("CONTACTO_ID"));
		contacto.setNombre(rs.getString("NOMBRE"));
		contacto.setApellido(rs.getString("APELLIDO"));
		contacto.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
		contacto.setSexo(rs.getString("SEXO"));
		contacto.setEmail(rs.getString("EMAIL"));
		contacto.setEstado(rs.getString("ESTADO"));
		Integer detalleContacto = rs.getInt("DETALLE_CONTACTO_ID");
		if (!ValidationUtil.isObjectNotNull(detalleContacto) && agregarContacto) {
			DetalleContactoType detalle = new DetalleContactoType();
			detalle.setDetalleContactoId(rs.getInt("DETALLE_CONTACTO_ID"));
			detalle.setCelular(rs.getString("CELULAR"));
			detalle.setCorreoAlterno(rs.getString("EMAIL_ALTERNATIVA"));
			detalle.setTelefono(rs.getString("TELEFONO"));
			detalle.setDireccion(rs.getString("DIRECCION"));
			contacto.setDetalleContactoId(detalle);
		}		
		return  contacto;
	} 

}
