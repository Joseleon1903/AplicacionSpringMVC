package com.aplicacion.spring.mvc.vista.beans;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aplication.spring.mvc.entity.MotivoEstado;

@Repository
@Transactional
public class ManejadorError {

	@PersistenceContext 
	private EntityManager entityManager;

	public MotivoEstado buscarMotivoPodId(Integer id) {
		MotivoEstado entity = null;
		try {
			// entityManager.getTransaction().begin();
			entity = entityManager.find(MotivoEstado.class, id);
			// entityManager.getTransaction().commit();
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
		return entity;
	}

}
