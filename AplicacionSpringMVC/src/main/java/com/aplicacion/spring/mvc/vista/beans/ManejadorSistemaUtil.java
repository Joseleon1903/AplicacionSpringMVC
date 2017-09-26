package com.aplicacion.spring.mvc.vista.beans;

import javax.annotation.Resource;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.aplicacion.spring.mvc.ejb.impl.MotivoEstadoEjbImpl;
import com.aplication.spring.mvc.layer.type.MotivoEstadoType;

@Component
public class ManejadorSistemaUtil {
	
	private static final Logger logger = Logger.getLogger(ManejadorSistemaUtil.class);
		
	@Resource(mappedName = "java:global/AplicacionSpringMVC/MotivoEstadoEjbImpl!com.aplicacion.spring.mvc.ejb.impl.MotivoEstadoEjbImpl")
	private MotivoEstadoEjbImpl motivoEstadoEJB;

	public ManejadorSistemaUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public MotivoEstadoType buscarMotivoPorId(Integer motivoId){
		logger.info("Utilizando ManejadorSistemaUtil");
		logger.info("Entrando en metodo buscarMotivoPorId");
		logger.info("MotivoId : "+motivoId);
		MotivoEstadoType type = motivoEstadoEJB.buscarMotivoPorId(motivoId);
		logger.info("motivoType : "+type);
		logger.info("Saliendo ManejadorSistemaUtil");
		return type;
	} 

}
