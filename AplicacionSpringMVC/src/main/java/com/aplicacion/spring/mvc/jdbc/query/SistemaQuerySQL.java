package com.aplicacion.spring.mvc.jdbc.query;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.aplication.spring.mvc.layer.type.ContactoType;
import com.aplication.spring.mvc.layer.type.EnvioSistemaType;
import com.aplication.spring.mvc.layer.type.EventoSistemaType;
import com.aplication.spring.mvc.layer.type.MotivoEstadoType;

public class SistemaQuerySQL {
	
	
	public static interface Consulta{
		
		/**
		 * Descripcion: consulta que permite buscar la lista email por el contacto Id. 
		 * 
		 */
		String BUSCAR_lISTA_EMAIL_POR_CONTACTO = "   SELECT even.ENVIO_ID,even.CONTACTO_ID,even.EVENTO_SISTEMA_ID,even.FECHA_EVENTO,"
				+ "                  con.CONTACTO_ID,con.NOMBRE, con.APELLIDO, con.EMAIL, con.ESTADO,"
				+ "                  con.SEXO, con.FECHA_NACIMIENTO, con.DETALLE_CONTACTO_ID, con.ESTADO,"
				+ "                  env.FECHA_ENVIO, env.ASUNTO, env.DESTINATARIO, env.CONTENIDO, env.ESTADO, env.MOTIVO_ID"
				+ "                  FROM EVENTO_SISTEMA even JOIN ENVIO_SISTEMA env ON even.ENVIO_ID = env.ENVIO_ID"
				+ "                  JOIN CONTACTO con ON even.CONTACTO_ID = con.CONTACTO_ID WHERE con.CONTACTO_ID = ?";		
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
