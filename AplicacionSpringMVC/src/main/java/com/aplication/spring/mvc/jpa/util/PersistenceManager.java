package com.aplication.spring.mvc.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

public static final String PERSISTENCE_MANAGER = "PersistenceManager";
	
	EntityManagerFactory emFactory;

	public PersistenceManager() {
		emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_MANAGER);
	}
	
	public PersistenceManager(String PerisistenceContext) {
		emFactory = Persistence.createEntityManagerFactory(PerisistenceContext);
	}
		
	
	public EntityManager getPersistenceManager(){
		EntityManager entitymanager = emFactory.createEntityManager();
		return entitymanager;
	}

}
