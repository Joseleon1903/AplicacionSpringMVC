package com.aplicacion.spring.mvc.vista.beans;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.aplicacion.spring.mvc.repository.dao.EventoSistemaRepositoryDao;

@Component
public class ManejadorEnviarEmail {
	
	private static final Logger logger = Logger.getLogger(ManejadorEnviarEmail.class);
	
	@Autowired
	@Qualifier("manejadorSistemaUtil")
	private ManejadorSistemaUtil manejadorUtil;
	
	@Autowired
	@Qualifier("EventoSistemaDao")
	private EventoSistemaRepositoryDao EventoSistemaES;


	public ManejadorEnviarEmail() {
		// TODO Auto-generated constructor stub
	}
	
	public void enviarEmailFormulario(String asunto, String destinatario,String contenido){
		logger.info("Entrando en el metodo enviarEmailFormulario..");
		EventoSistemaES.enviarEmail(asunto, destinatario, contenido);
		logger.info("Saliendo del metodo enviarEmailFormulario..");
	}
	
	
	

}
