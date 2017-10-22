package com.aplication.spring.mvc.jpa.util;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Calendar;

import com.aplicacion.spring.mvc.jdbc.query.UsuarioQuerySQL;

public class DatabaseUtil {
	
	
	public static String OPTENER_VALOR_INDEX_TABLA_SQL = "select optenerValorIndexTabla(?)";
	
	public static int resolveType(Object param) {
		
		int sqlType = Types.VARCHAR;
		
		if (param == null) {
			sqlType = Types.NULL;
		} else {
			Class paramClass = param.getClass();
			if (param instanceof String) {
				sqlType = Types.VARCHAR;
			} else if (paramClass.equals(double.class) || param instanceof Double) {
				sqlType = Types.DOUBLE;
			} else if (param instanceof BigDecimal) {
				sqlType = Types.NUMERIC;
			} else if (param instanceof Calendar || param instanceof java.sql.Date) {
				sqlType = Types.DATE;
			} else if (paramClass.equals(int.class) || param instanceof Integer) {
				sqlType = Types.INTEGER;
			} else if (paramClass.equals(long.class) || param instanceof Long) {
				sqlType = Types.BIGINT;
			} else if (paramClass.equals(float.class) || param instanceof Float) {
				sqlType = Types.REAL;
			}
		}
		return sqlType;
	}
	
	/**
	 * 
	 * @param String tablaName
	 * @param Connection connection
	 * @return Integer Index Id
	 * @throws SQLException
	 */
	public static Integer buscarValorIndexTabla(String tablaName, Connection conn) throws SQLException {
		Integer index = 0;
		ResultSet rs = null;
		PreparedStatement stmt = conn.prepareStatement(tablaName);
		stmt.setString(1, UsuarioQuerySQL.Tablas.USUARIO_TBL);
		stmt.executeQuery();
		rs = stmt.getResultSet();
		while (rs.next()) {
			index = rs.getInt(1);
		}
		return index;
	}	
	
	
}
