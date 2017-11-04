package com.aplicacion.spring.mvc.repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aplicacion.spring.mvc.jdbc.query.MotivoEstadoQuerySQL;
import com.aplication.spring.mvc.layer.type.MotivoEstadoType;

@Repository("MotivoEstadoDao")
@Transactional
public class MotivoEstadoRepositoryDao {

	private static final Logger logger = Logger.getLogger(MotivoEstadoRepositoryDao.class.getName());
	
	@Autowired
	private DataSource dataSource;
	
	public MotivoEstadoRepositoryDao() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Descripcion: Capacidad que permite buscar un motivo en el repositorio de MOTIVO_ESTADO por el id del motivo.
	 * 
	 * @param Integer: id
	 * @return MotivoEstadoType
	 */
	@Transactional(propagation= Propagation.REQUIRED)
	public MotivoEstadoType buscarMotivoPorId(Integer id) {
		logger.info("Entrondo en capacidad buscarMotivoPorId..");
		logger.info("Parametro ID : "+ id);
		logger.info("Inicinado ejecucion select: "+ MotivoEstadoQuerySQL.Consulta.BUSCAR_MOTIVO_ESTADO_POR_ID);
		logger.info("Creando conexion desde el datasource.");
		Connection connexion = null;
		PreparedStatement stmt = null;
		MotivoEstadoType motivo = new MotivoEstadoType();
		try {
			logger.info("Opteneiendo conexion data Source");
			connexion = dataSource.getConnection();
			logger.info("Finalizando Optener conexion datasource.");
			stmt = connexion.prepareStatement(MotivoEstadoQuerySQL.Consulta.BUSCAR_MOTIVO_ESTADO_POR_ID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			logger.info("Terminando efectuar consulta.");
			logger.info("Inicio casteo resultSet usuario : "+ motivo);
			while(rs.next()){
				motivo = MotivoEstadoQuerySQL.casteoResultSetEnvioSistemaType(rs);
			}
			logger.info("Finalizando casteo resultSet usuario : "+ motivo);
		} catch (SQLException e) {
			logger.info("Error realizando la consulta..");
			logger.info("Error: "+ e.getMessage());
		}
		logger.info("Terminando realizar Consulta.");	
		return motivo;
	}

	/**
	 * Descripcion: Capacidad que permite buscar todos los registros guardados en el repositorio de MOTIVO_ESTADO.
	 * 
	 * @return List<MotivoEstadoType>
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public List<MotivoEstadoType> buscarTodosLosMotivos() {
		logger.info("Entrondo en capacidad buscarTodosLosMotivos..");
		logger.info("Inicinado ejecucion select: " + MotivoEstadoQuerySQL.Consulta.BUSCAR_MOTIVOS_ESTADOS_SISTEMA);
		logger.info("Creando conexion desde el datasource.");
		Connection connexion = null;
		PreparedStatement stmt = null;
		List<MotivoEstadoType> motivoLista = new ArrayList<>();
		MotivoEstadoType motivo = null;
		try {
			logger.info("Opteneiendo conexion data Source");
			connexion = dataSource.getConnection();
			logger.info("Finalizando Optener conexion datasource.");
			stmt = connexion.prepareStatement(MotivoEstadoQuerySQL.Consulta.BUSCAR_MOTIVOS_ESTADOS_SISTEMA);
			ResultSet rs = stmt.executeQuery();
			logger.info("Terminando efectuar consulta.");
			logger.info("Inicio casteo resultSet usuario : " + motivo);
			while (rs.next()) {
				motivo = MotivoEstadoQuerySQL.casteoResultSetEnvioSistemaType(rs);
				motivoLista.add(motivo);
			}
			logger.info("Finalizando casteo resultSet usuario : " + motivo);
		} catch (SQLException e) {
			logger.info("Error realizando la consulta..");
			logger.info("Error: " + e.getMessage());
		}
		logger.info("Terminando realizar Consulta.");
		return motivoLista;
	}

}
