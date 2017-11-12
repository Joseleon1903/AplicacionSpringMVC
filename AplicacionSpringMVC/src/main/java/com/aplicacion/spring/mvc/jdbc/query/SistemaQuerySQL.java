package com.aplicacion.spring.mvc.jdbc.query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aplication.spring.mvc.layer.type.ContactoType;
import com.aplication.spring.mvc.layer.type.EnvioSistemaType;
import com.aplication.spring.mvc.layer.type.EventoSistemaType;
import com.aplication.spring.mvc.layer.type.MotivoEstadoType;

/**
 * 
 * @author Jose Eduardo
 *
 */
public class SistemaQuerySQL {
	
	/**
	 * Descripcion: nombre de las tablas 
	 * 
	 *
	 */
	public static interface Tablas{
		String EVENTO_SISTEMA_TBL   = "EVENTO_SISTEMA";
		String ENVIO_SISTEMA_TBL    = "ENVIO_SISTEMA";
	}
	
	public static interface Consulta{
		
		/**
		 * Descripcion: consulta que permite buscar la lista email por el contacto Id. 
		 * 
		 */
		String BUSCAR_lISTA_EMAIL_POR_CONTACTO = "   SELECT even.ENVIO_ID,even.CONTACTO_ID,even.EVENTO_SISTEMA_ID,even.FECHA_EVENTO,"
				+ "                  con.CONTACTO_ID,con.NOMBRE, con.APELLIDO, con.EMAIL,"
				+ "                  con.SEXO, con.FECHA_NACIMIENTO, con.DETALLE_CONTACTO_ID,"
				+ "                  env.FECHA_ENVIO, env.ASUNTO, env.DESTINATARIO, env.CONTENIDO, env.ESTADO, env.MOTIVO_ID"
				+ "                  FROM EVENTO_SISTEMA even JOIN ENVIO_SISTEMA env ON even.ENVIO_ID = env.ENVIO_ID"
				+ "                  JOIN CONTACTO con ON even.CONTACTO_ID = con.CONTACTO_ID WHERE con.CONTACTO_ID = ?";
		
		
		String BUSCAR_lISTA_EMAIL_CON_DATOS_GENERALES = "SELECT even.ENVIO_ID,even.CONTACTO_ID,even.EVENTO_SISTEMA_ID,even.FECHA_EVENTO,"
											+ "          con.CONTACTO_ID,con.NOMBRE, con.APELLIDO, con.EMAIL,"
											+ "          con.SEXO, con.FECHA_NACIMIENTO, con.DETALLE_CONTACTO_ID,"
											+ "          env.FECHA_ENVIO, env.ASUNTO, env.DESTINATARIO, env.CONTENIDO, env.ESTADO, env.MOTIVO_ID"
											+ "          FROM EVENTO_SISTEMA even JOIN ENVIO_SISTEMA env ON even.ENVIO_ID = env.ENVIO_ID"
											+ "          JOIN CONTACTO con ON even.CONTACTO_ID = con.CONTACTO_ID"
											+ "			 WHERE (:nombre IS NULL OR con.NOMBRE = :nombre)"
											+ "          AND (:asunto IS NULL OR env.ASUNTO = :asunto)"
							                + "          AND (:destinatario IS NULL OR env.DESTINATARIO = :destinatario)"
							                + "          AND env.ESTADO= ?";	
	
	}
	
	public static interface Insert{
		
		/**
		 * Descripcion: sinsert para la tabla de EVENTO_SISTEMA
		 */
		String INSERT_EVENTO_SISTEMA = "INSERT INTO EVENTO_SISTEMA (EVENTO_SISTEMA_ID,CONTACTO_ID, FECHA_EVENTO, ENVIO_ID) VALUES(?,?,?,?)";
		
		/**
		 * Descripcion: Insert para la tabla de ENVIO_SISTEMA
		 */
		String INSERT_ENVIO_SISTEMA ="INSERT INTO ENVIO_SISTEMA (ENVIO_ID,FECHA_ENVIO, ASUNTO, DESTINATARIO, CONTENIDO, ESTADO)"
				+ " VALUES(?,?,?,?,?,?)";
		
		/**
		 * Descripcion: Insert para la tabla de ENVIO_SISTEMA y Motivo
		 */
		String INSERT_ENVIO_SISTEMA_MOTIVO ="INSERT INTO ENVIO_SISTEMA (ENVIO_ID,FECHA_ENVIO, ASUNTO, DESTINATARIO, CONTENIDO, ESTADO, MOTIVO_ID)"
				+ " VALUES(?,?,?,?,?,?,?)";
	}
	
	public static PreparedStatement agregarEnvioSistemaStatement(PreparedStatement preparedStatement , EventoSistemaType eventoSistema, Integer index, boolean agregarMotivo) throws SQLException{
		preparedStatement.setInt(1, index);
		preparedStatement.setDate(2, new java.sql.Date(eventoSistema.getEnvioId().getFechaEnvio().getTime()));
		preparedStatement.setString(3, eventoSistema.getEnvioId().getAsunto());
		preparedStatement.setString(4, eventoSistema.getEnvioId().getDestinatario());
		preparedStatement.setString(5,eventoSistema.getEnvioId().getContenido());
		preparedStatement.setString(6, eventoSistema.getEnvioId().getEstado());
		if (agregarMotivo) {
			preparedStatement.setInt(7, eventoSistema.getEnvioId().getMotivoId().getMotivoId());
		}
		return preparedStatement;
	}
	
	public static PreparedStatement agregarEventoSistemaStatement(PreparedStatement preparedStatement, EventoSistemaType eventoSistema, Integer index) throws SQLException{
		preparedStatement.setInt(1, index);
		preparedStatement.setInt(2, eventoSistema.getContactoId().getContactoId());
		preparedStatement.setDate(3, new java.sql.Date(eventoSistema.getFechaEvento().getTime()));
		preparedStatement.setInt(4, index);
		return preparedStatement;
	}
	
	public static EventoSistemaType casteoResultSetEventoSistemaType(ResultSet rs, ContactoType contacto, EnvioSistemaType envio) throws SQLException{
		EventoSistemaType evento = new EventoSistemaType();
		evento.setEventoSistemaId(rs.getInt("EVENTO_SISTEMA_ID"));
		evento.setContactoId(contacto);
		evento.setFechaEvento(rs.getDate("FECHA_EVENTO"));
		evento.setEnvioId(envio);
		return evento;
	} 

	public static EnvioSistemaType casteoResultSetEnvioSistemaType(ResultSet rs) throws SQLException{
		EnvioSistemaType envio = new EnvioSistemaType();
		envio.setAsunto(rs.getString("ASUNTO"));
		envio.setContenido(rs.getString("CONTENIDO"));
		envio.setDestinatario(rs.getString("DESTINATARIO"));
		envio.setEstado(rs.getString("ESTADO"));
		envio.setEnvioId(rs.getInt("ENVIO_ID"));
		envio.setFechaEnvio(rs.getDate("FECHA_ENVIO"));
		envio.setMotivoId(new MotivoEstadoType(rs.getInt("MOTIVO_ID")));
		return envio;
	} 	
	
}
