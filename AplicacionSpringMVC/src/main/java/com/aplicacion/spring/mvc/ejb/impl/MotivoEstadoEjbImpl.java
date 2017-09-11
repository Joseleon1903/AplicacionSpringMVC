package com.aplicacion.spring.mvc.ejb.impl;

import java.util.List;

import javax.ejb.Stateful;

import org.jboss.logging.Logger;

import com.aplicacion.spring.mvc.interfaces.IMotivoEstadoES;
import com.aplicacion.spring.mvc.interfaces.impl.MotivoEstadoESImpl;
import com.aplication.spring.mvc.jpa.util.PersistenceManager;
import com.aplication.spring.mvc.layer.type.MotivoEstadoType;

@Stateful
public class MotivoEstadoEjbImpl{
	
	private static final Logger logger = Logger.getLogger(MotivoEstadoEjbImpl.class.getName());
	
	private PersistenceManager persistenceManager;
	
	public MotivoEstadoEjbImpl() {
	}

	public MotivoEstadoType buscarMotivoPorId(Integer id) {
		logger.info("Entrondo en capacidad buscarMotivoPorId..");
		logger.info("Parametro ID : "+ id);
		IMotivoEstadoES dao = new MotivoEstadoESImpl(persistenceManager);
		MotivoEstadoType motivo = dao.buscarMotivoEstadoPorId(id);
		logger.info("Retornando motivo: "+ motivo);
		logger.debug("Saliendo capacidad buscarMotivoPorId");
	   return motivo;
	}

	public List<MotivoEstadoType> buscarTodosLosMotivos() {
		logger.info("Entrondo en capacidad buscarTodosLosMotivos..");
		List<MotivoEstadoType> listaMotivos = null;
		IMotivoEstadoES dao = new MotivoEstadoESImpl(persistenceManager);		
	    listaMotivos = dao.buscarMotivoEstadoSistema();
		logger.info("Retornando motivos: "+ listaMotivos);
		logger.debug("Saliendo capacidad buscarTodosLosMotivos");
		return listaMotivos;
	}

}