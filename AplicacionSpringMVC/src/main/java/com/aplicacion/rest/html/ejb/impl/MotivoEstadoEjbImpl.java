package com.aplicacion.rest.html.ejb.impl;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.PersistenceException;

import com.aplicacion.rest.html.dao.MotivoEstadoDao;
import com.aplicacion.rest.html.dao.impl.MotivoEstadoDaoImpl;
import com.aplicacion.rest.html.ejb.interfaces.IMotivoEstado;
import com.aplicacion.rest.html.entity.MotivoEstado;
import com.aplicacion.rest.html.exception.InternalServiceException;
import com.aplicacion.rest.html.jpa.util.PersistenceManager;
import com.aplicacion.rest.html.layer.type.MotivoEstadoType;
import com.aplicacion.rest.html.util.BuscarMotivoEstadoUtil;

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
