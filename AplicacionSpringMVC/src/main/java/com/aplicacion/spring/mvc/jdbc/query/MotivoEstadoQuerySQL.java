package com.aplicacion.spring.mvc.jdbc.query;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.aplication.spring.mvc.layer.type.MotivoEstadoType;

/**
 * 
 * @author Jose Eduardo
 *
 */
public class MotivoEstadoQuerySQL {
	
	public static interface Consulta{
		
		/**
		 * Descripcion: permite buscar un motivo estado por Id proporcionado por parametro.
		 */
		String BUSCAR_MOTIVO_ESTADO_POR_ID = "SELECT MOTIVO_ID , DESCRIPCION, ESTADO FROM MOTIVO_ESTADO WHERE MOTIVO_ID = ?";
		
		/**
		 * Descripcion: permite buscar todos los motivo estado del repositorio MOTIVO_ESTADO.
		 */
		String BUSCAR_MOTIVOS_ESTADOS_SISTEMA = "SELECT MOTIVO_ID , DESCRIPCION, ESTADO FROM MOTIVO_ESTADO";
		
	}
		
	public static MotivoEstadoType casteoResultSetEnvioSistemaType(ResultSet rs) throws SQLException{
		MotivoEstadoType motivo = new MotivoEstadoType();
		motivo.setMotivoId(rs.getInt("MOTIVO_ID"));
		motivo.setDescripcion(rs.getString("DESCRIPCION"));
		motivo.setEstado(rs.getString("ESTADO"));
		return motivo;
	} 	

}
