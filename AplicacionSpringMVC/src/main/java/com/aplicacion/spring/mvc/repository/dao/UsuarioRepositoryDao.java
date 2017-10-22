package com.aplicacion.spring.mvc.repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.sql.DataSource;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aplicacion.spring.mvc.interfaces.IUsuarioES;
import com.aplicacion.spring.mvc.interfaces.impl.UsuarioESImpl;
import com.aplicacion.spring.mvc.jdbc.query.UsuarioQuerySQL;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.jpa.util.DatabaseUtil;
import com.aplication.spring.mvc.layer.type.UsuarioType;
import com.aplication.spring.mvc.util.ValidationUtil;

@Repository("UsuarioDao")
public class UsuarioRepositoryDao {

	private static final Logger logger = Logger.getLogger(UsuarioRepositoryDao.class.getName());
	
	@PersistenceContext(unitName="PersistenceManager", type = PersistenceContextType.EXTENDED) 
	private EntityManager entityManagerF;
	
	@Autowired
	private DataSource dataSource;
	
	@Resource
	private JpaTransactionManager JtaTransaction;
	
	public UsuarioRepositoryDao() {
	
	}

	/**
	 * Descripcion: Capacidad que permite buscar un usuario por el codigo de usuario.
	 * 
	 * @param String: codigoUsuario
	 * @return UsuarioType
	 * @throws InternalServiceException
	 */
	@Transactional(propagation= Propagation.REQUIRED)
	public UsuarioType buscarUsuarioPorCodigo(String codigoUsuario) throws InternalServiceException{
		logger.info("Entrando en la capacidad buscarUsuarioPorCodigo");
		IUsuarioES dao = new UsuarioESImpl(entityManagerF);
		UsuarioType user = null;
		try {
			user = dao.buscarUsuarioPorCodigo(codigoUsuario);
		} catch (InternalServiceException e) {
			logger.info("ERROR realizando la consulta..");
			logger.info(e.getMessage());
			throw new InternalServiceException();
		}
		logger.info("Saliendo del metodo buscarUsuarioPorCodigo");
		logger.info("Returning: "+user );
		return user;
	}
	
	/**
	 * Descripcion: Capacidad que permite registar un nuevo usuario en el repositorio de USUARIO y CONTACTO del sistema.
	 *              Devuelve TRUE si el usuario fue registrado exitosamente, FALSE de lo contrario.
	 * 
	 * @param UsuarioType
	 * @return boolean
	 * @throws InternalServiceException
	 */
	@Transactional(propagation= Propagation.REQUIRES_NEW)
	public boolean registrarNuevoUsuarioSistema(UsuarioType user) throws InternalServiceException{
		logger.info("Entrando en la capacidad registrarNuevoUsuarioSistema");
		boolean registrado = true;
		boolean detalle = false;
		logger.info("Inicinado ejecucion funcion: "+ DatabaseUtil.OPTENER_VALOR_INDEX_TABLA_SQL);
		logger.info("Creando conexion desde el datasource.");
		Connection connexion = null;
		Integer indexOut = 0;
		PreparedStatement stmt = null;
		try {
		   logger.info("Opteneiendo conexion data Source");
           connexion = dataSource.getConnection();
           logger.info("Terminando optener conexion.");
           Integer indexId = DatabaseUtil.buscarValorIndexTabla(UsuarioQuerySQL.Tablas.USUARIO_TBL, connexion);
           logger.info("Registrando detalle usuario si tiene");
			if (!ValidationUtil.isObjectNotNull(user.getContacto().getDetalleContactoId())) {
				stmt = connexion.prepareStatement(UsuarioQuerySQL.Insert.INSERT_DETALLE_CONTACTO);
				stmt = UsuarioQuerySQL.agregarDetalleContactoStatement(stmt, user.getContacto().getDetalleContactoId(),indexId);
				stmt.executeUpdate();
				detalle = true;
			}          
	        logger.info("Finalizando registrar detalle usuario si tiene");
	        logger.info("Registrando contacto");
			stmt = connexion.prepareStatement(UsuarioQuerySQL.Insert.INSERT_CONTACTO);
			if (detalle) {
				stmt = connexion.prepareStatement(UsuarioQuerySQL.Insert.INSERT_CONTACTO_CON_DETALLE);	
			}
			stmt = UsuarioQuerySQL.agregarContactoStatement(stmt, user.getContacto(),indexId);
			stmt.executeUpdate();
	        logger.info("Finalizando registrar contacto");
	        logger.info("Registrar usuario");
           stmt= connexion.prepareStatement(UsuarioQuerySQL.Insert.INSERT_USUARIO);
           stmt = UsuarioQuerySQL.agregarUsuarioStatement(stmt, user, indexId);
           stmt.executeUpdate();
	       logger.info("Finalizando registrar usuario");
         
		} catch (SQLException e) {
			logger.info("Error Actualizando Contacto "+e.getMessage());
			throw new InternalServiceException();
		}finally{
			if (connexion != null) {
				try {
					connexion.close();
				} catch (SQLException e) {}
			}
		}
		logger.info("Terminando registrar Usuario");
		return registrado;
	}
	
	/**
	 * Descripcion: Capacidad que permite buscar un Usuario en el repositorio de USUARIO 
	 *              con el id usuario proporcionado por parametro.
	 * 
	 * @param usuarioId
	 * @return UsuarioType
	 * @throws InternalServiceException
	 */
	@Transactional(propagation= Propagation.REQUIRED)
	public UsuarioType buscarUsuarioPorUsuarioId(Integer usuarioId) throws InternalServiceException{
		logger.info("Entrando en la capacidad buscarUsuarioPorUsuarioId");
		IUsuarioES dao = new UsuarioESImpl(entityManagerF);
		UsuarioType user = null;
		try {
			user = dao.buscarUsuarioPorId(usuarioId);
		} catch (InternalServiceException e) {
			logger.info("ERROR realizando la consulta..");
			logger.info(e.getMessage());
			throw new InternalServiceException();
		}
		logger.info("Saliendo del metodo buscarUsuarioPorUsuarioId");
		logger.info("Returning: "+user );
		return user;
	}
	
	/**
	 * Descripcion: Capacidad que permite actualizar el registro de usuario 
	 *              proporcionado por parametro en el repositorio de USUARIO, CONTACTO y DETALLE_CONTACTO.
	 *              Retorna {TRUE} si el registro se actualizo con exito {FALSE} de lo contrario.
	 * 
	 * @param user
	 * @return boolean
	 * @throws InternalServiceException
	 */
	@Transactional(propagation= Propagation.REQUIRES_NEW)
	public boolean actualizarUsuarioSistema(UsuarioType user) throws InternalServiceException{
		logger.info("Entrando en la capacidad actualizarUsuarioSistema");
		String sql = "UPDATE contacto SET NOMBRE = ? , APELLIDO = ? , SEXO = ? ,"
				+ " FECHA_NACIMIENTO= ?, EMAIL = ? WHERE CONTACTO_ID = ?";
		logger.info("QUERY: "+ sql);
		logger.info("Creando conexion desde el datasource.");
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getContacto().getNombre());
			ps.setString(2, user.getContacto().getApellido());
			ps.setString(3, user.getContacto().getSexo());
			ps.setDate(4,new java.sql.Date(user.getContacto().getFechaNacimiento().getTime()));
			ps.setString(5, user.getContacto().getEmail());
			ps.setInt(6, user.getContacto().getContactoId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			logger.info("Error Actualizando Contacto "+e.getMessage());
			throw new InternalServiceException();
		}finally{
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		logger.info("Returning: "+true );
		return true;
	}
	
	/**
	 * Descripcion: capacidad que permite buscar un usuario en el repositorio de USUARIO por el nombre proporcionado por parametro.
	 * 
	 * @param codigoUsuario
	 * @return UsuarioType
	 * @throws InternalServiceException
	 */
	@Transactional(propagation= Propagation.REQUIRED)
	public UsuarioType buscarUsuarioPorNombre(String codigoUsuario) throws InternalServiceException{
		logger.info("Entrando en la capacidad buscarUsuarioPorCodigo");
		IUsuarioES dao = new UsuarioESImpl(entityManagerF);
		UsuarioType user = null;
		try {
			user = dao.buscarUsuarioNombre(codigoUsuario);
		} catch (InternalServiceException e) {
			logger.info("ERROR realizando la consulta..");
			logger.info(e.getMessage());
			throw new InternalServiceException();
		}
		logger.info("Saliendo del metodo buscarUsuarioPorCodigo");
		logger.info("Returning: "+user );
		return user;
	}

}
