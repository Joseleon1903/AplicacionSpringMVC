package com.aplicacion.spring.mvc.ejb.impl;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.jboss.logging.Logger;

import com.aplication.spring.mvc.entity.MotivoEstado;
import com.aplication.spring.mvc.layer.type.MotivoEstadoType;

@Stateful
public class ErrorEjbImpl {

	private static final Logger logger = Logger.getLogger(ErrorEjbImpl.class.getName());
	
	@PersistenceContext
	private EntityManagerFactory entityManagerFactory;

	public ErrorEjbImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public MotivoEstadoType buscarMotivoError(Integer motivoId) {
		logger.info("Entraondo en la capacidad buscarMotivoError..");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		MotivoEstado entity = null;
		logger.info("Parametro motivoId"+motivoId); 
		logger.info("Terminando inicializar motivo");
		try {
			logger.info("iniciando busqueda motivo");
//			entityManager.getTransaction().begin();
			entity = entityManager.find(MotivoEstado.class, motivoId);
//			entityManager.getTransaction().commit();
		} catch (Exception e) {
			logger.info("Error busqueda motivo");
			logger.info("Error: " + e.getMessage());
			throw new PersistenceException(e);
		}
		logger.info("Motivo Encontrado: " + entity);
		return new MotivoEstadoType().toType(entity);
	}	
		

}
