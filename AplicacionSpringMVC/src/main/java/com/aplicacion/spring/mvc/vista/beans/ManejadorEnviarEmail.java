package com.aplicacion.spring.mvc.vista.beans;

import java.util.Date;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.NestedRuntimeException;
import org.springframework.stereotype.Component;

import com.aplicacion.spring.mvc.constante.ParametrosErrorConstantes;
import com.aplicacion.spring.mvc.constante.ParametrosSistemaConstantes;
import com.aplicacion.spring.mvc.repository.dao.EventoSistemaRepositoryDao;
import com.aplicacion.spring.mvc.repository.dao.UsuarioRepositoryDao;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.layer.type.ContactoType;
import com.aplication.spring.mvc.layer.type.EnvioSistemaType;
import com.aplication.spring.mvc.layer.type.EventoSistemaType;
import com.aplication.spring.mvc.layer.type.UsuarioType;
import com.aplication.spring.mvc.util.ValidationUtil;

@Component
public class ManejadorEnviarEmail {
	
	private static final Logger logger = Logger.getLogger(ManejadorEnviarEmail.class);
	
	@Autowired
	@Qualifier("manejadorSistemaUtil")
	private ManejadorSistemaUtil manejadorUtil;
	
	@Autowired
	@Qualifier("EventoSistemaDao")
	private EventoSistemaRepositoryDao EventoSistemaES;
	
	@Autowired
	@Qualifier("UsuarioDao")
	private UsuarioRepositoryDao usuarioES;

	public ManejadorEnviarEmail() {
		// TODO Auto-generated constructor stub
	}
	
	public void enviarEmailFormulario(String asunto, String destinatario,String contenido, Integer usuarioId){
		logger.info("Entrando en el metodo enviarEmailFormulario..");
		UsuarioType user =  null;
		Integer motivo = null;
		try {
			logger.info("Iniciando busqueda usuario.");
			user = usuarioES.buscarUsuarioPorUsuarioId(usuarioId);
		} catch (InternalServiceException e) {
			logger.info("Error: " + e.getDescripcion());
		}
		logger.info("Terminando busqueda del usuario: "+ user);
		logger.info("iniciando envio email");
		try{
		EventoSistemaES.enviarEmail(asunto, destinatario, contenido);
		}catch (NestedRuntimeException e) {
			logger.info("Error enviando email..");
			logger.info("error: "+e.getMessage());
			motivo = ParametrosErrorConstantes.INTERNAL_SERVER_ERROR_COD;
		}
		logger.info("Terminando enviar email");
		try {
			logger.info("Registrando envio email sistema..");
			EventoSistemaType eventoSys = crearNuevoEventoSistema(asunto, destinatario, contenido, user.getContacto(), motivo);
			EventoSistemaES.registrarEnvioEmail(eventoSys);
		} catch (InternalServiceException e) {
			logger.info("Error registrando en base de datos envio email");
			logger.info("Error: " +e.getDescripcion());
		}
		logger.info("Finalizando de registrar envio email sistema..");
		logger.info("Saliendo del metodo enviarEmailFormulario..");
	}
	
	public EventoSistemaType crearNuevoEventoSistema(String asunto, String destinatario,String contenido, ContactoType contacto, Integer motivoId){
		logger.info("Entrando en el metodo crearNuevoEventoSistema");
		EventoSistemaType evento = new EventoSistemaType();
		EnvioSistemaType envio = new EnvioSistemaType();
		logger.info("creando EnvioSistemaType");
		envio.setAsunto(asunto);
		envio.setContenido(contenido);
		envio.setDestinatario(destinatario);
		envio.setFechaEnvio(new Date());
		envio.setEstado("OK");
		if (!ValidationUtil.isObjectNotNull(motivoId)) {
			envio.setEstado("RE");
			envio.setMotivoId(manejadorUtil.buscarMotivoPorId(motivoId));
		}
		logger.info("Finalizando crear EnvioSistemaType: "+envio );
		logger.info("creando EventoSistemaType");
		evento.setEnvioId(envio);
		evento.setFechaEvento(new Date());
		evento.setContactoId(contacto);
		logger.info("Finalizando crear EventoSistemaType: "+evento);				
		return evento;
	}
	

}
