package com.aplication.spring.mvc.ejb.impl;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.PersistenceException;

import com.aplication.spring.mvc.dao.MotivoEstadoDao;
import com.aplication.spring.mvc.dao.impl.MotivoEstadoDaoImpl;
import com.aplication.spring.mvc.ejb.interfaces.IMotivoEstado;
import com.aplication.spring.mvc.entity.MotivoEstado;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.jpa.util.PersistenceManager;
import com.aplication.spring.mvc.layer.type.MotivoEstadoType;
import com.aplication.spring.mvc.util.BuscarMotivoEstadoUtil;

@Stateful
public class MotivoEstadoEjbImpl implements IMotivoEstado {
	
	private PersistenceManager persistenceManager;
	
	public MotivoEstadoEjbImpl() {
	}

	@Override
	public MotivoEstadoType buscarMotivoPorId(Integer id) throws InternalServiceException {
		MotivoEstadoDao dao = new MotivoEstadoDaoImpl(persistenceManager);
		MotivoEstado motivo = dao.buscarMotivoEstadoPorId(id);				
	   return new MotivoEstadoType().toType(motivo);
	}

	@Override
	public List<MotivoEstadoType> buscarTodosLosMotivos() throws InternalServiceException {
		List<MotivoEstado> listaMotivos = null;
		MotivoEstadoDao dao = new MotivoEstadoDaoImpl(persistenceManager);
		try {
			listaMotivos = dao.buscarTodosLosMotivos();
		} catch (PersistenceException e) {
			MotivoEstadoType motivo = BuscarMotivoEstadoUtil.buscarMotivoPorId(500);
			throw new InternalServiceException(motivo.getMotivoId(), motivo.getDescripcion());
		}
		List<MotivoEstadoType> listaType = new MotivoEstadoType().toListType(listaMotivos);
		return listaType;
	}

}
