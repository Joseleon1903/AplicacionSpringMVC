package com.aplicacion.spring.mvc.repository.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aplicacion.spring.mvc.interfaces.IMotivoEstadoES;
import com.aplicacion.spring.mvc.interfaces.impl.MotivoEstadoESImpl;
import com.aplication.spring.mvc.layer.type.MotivoEstadoType;

@Repository("MotivoEstadoDao")
@Transactional
public class MotivoEstadoRepositoryDao {

	private static final Logger logger = Logger.getLogger(MotivoEstadoRepositoryDao.class.getName());
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public MotivoEstadoRepositoryDao() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Descripcion: Capacidad que permite buscar un motivo en el repositorio de MOTIVO_ESTADO por el id del motivo.
	 * 
	 * @param Integer: id
	 * @return MotivoEstadoType
	 */
	public MotivoEstadoType buscarMotivoPorId(Integer id) {
		logger.info("Entrondo en capacidad buscarMotivoPorId..");
		logger.info("Parametro ID : "+ id);
		IMotivoEstadoES dao = new MotivoEstadoESImpl(entityManager);
		MotivoEstadoType motivo = dao.buscarMotivoEstadoPorId(id);
		logger.info("Retornando motivo: "+ motivo);
		logger.debug("Saliendo capacidad buscarMotivoPorId");
	   return motivo;
	}

	/**
	 * Descripcion: Capacidad que permite buscar todos los registros guardados en el repositorio de MOTIVO_ESTADO.
	 * 
	 * @return List<MotivoEstadoType>
	 */
	public List<MotivoEstadoType> buscarTodosLosMotivos() {
		logger.info("Entrondo en capacidad buscarTodosLosMotivos..");
		List<MotivoEstadoType> listaMotivos = null;
		IMotivoEstadoES dao = new MotivoEstadoESImpl(entityManager);		
	    listaMotivos = dao.buscarMotivoEstadoSistema();
		logger.info("Retornando motivos: "+ listaMotivos);
		logger.debug("Saliendo capacidad buscarTodosLosMotivos");
		return listaMotivos;
	}


}
