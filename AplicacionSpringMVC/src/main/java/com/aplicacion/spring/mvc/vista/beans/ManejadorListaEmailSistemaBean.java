package com.aplicacion.spring.mvc.vista.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.aplicacion.spring.mvc.constante.ParametrosErrorConstantes;
import com.aplicacion.spring.mvc.ejb.impl.EventoSistemaEjbImpl;
import com.aplicacion.spring.mvc.ejb.impl.UsuarioEjbImpl;
import com.aplicacion.spring.mvc.session.beans.UsuarioSession;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.layer.type.EventoSistemaType;
import com.aplication.spring.mvc.layer.type.MotivoEstadoType;
import com.aplication.spring.mvc.layer.type.UsuarioType;

@Component
public class ManejadorListaEmailSistemaBean {
	
	private static final Logger logger = Logger.getLogger(ManejadorListaEmailSistemaBean.class);
	
	@EJB(mappedName = "java:global/AplicacionSpringMVC/EventoSistemaEjbImpl!com.aplicacion.spring.mvc.ejb.impl.EventoSistemaEjbImpl")
	private EventoSistemaEjbImpl EventoSistemaES;
	
	@EJB(mappedName = "java:global/AplicacionSpringMVC/UsuarioEjbImpl!com.aplicacion.spring.mvc.ejb.impl.UsuarioEjbImpl")
	private UsuarioEjbImpl usuarioES;

	@Autowired
	@Qualifier("manejadorSistemaUtil")
	private ManejadorSistemaUtil manejadorUtil;

	public ManejadorListaEmailSistemaBean() {}
	
	public List<ListaEmailEnviadasBean> buscarListaEmailDefault(UsuarioSession session){
		logger.info("Entrando en el metodo buscarListaEmailDefault..");
		List<ListaEmailEnviadasBean> lista = new ArrayList<>();
		UsuarioType user = null;
		logger.info("Incinado busqueda usuario ");
		try {
			user = usuarioES.buscarUsuarioPorUsuarioId(session.getUsuarioId());
		} catch (InternalServiceException e) {
			MotivoEstadoType motivo = null;
			motivo = manejadorUtil.buscarMotivoPorId(ParametrosErrorConstantes.INTERNAL_SERVER_ERROR_COD);
			session.setError(true);
			session.setMensajeError(motivo.getDescripcion());
		}
		logger.info("Finalizando busqueda usuario ");
		logger.info("Iniciando busqueda...");
		List<EventoSistemaType> listaType = EventoSistemaES.buscarListaEmailSistema();
		logger.info("Iniciando casteo a lista de salida..");
		ListaEmailEnviadasBean bean = null;
		for (EventoSistemaType eventoType : listaType) {
			bean = new ListaEmailEnviadasBean();
			bean.setEnvioId(eventoType.getEnvioId().getEnvioId());
			bean.setAsunto(eventoType.getEnvioId().getAsunto());
			bean.setDestinatario(eventoType.getEnvioId().getDestinatario());
			bean.setFechaEnvio(eventoType.getEnvioId().getFechaEnvio());
			bean.setEstado(eventoType.getEnvioId().getEstado());
			bean.setUsuarioEnvio(eventoType.getContactoId().getNombre());
			lista.add(bean);
		}
		logger.info("Terminando de setear valores lista..");
		logger.info("Lista de salida: "+ lista);
		return lista;
	}
	
	public List<ListaEmailEnviadasBean> buscarListaEmailPorDatosGenerales(String usuarioEnvio, String asunto,String destinatario,String estado, UsuarioSession session){
		logger.info("Entrando en el metodo buscarListaEmailPorDatosGenerales..");
		List<ListaEmailEnviadasBean> lista = new ArrayList<>();
		logger.info("Iniciando busqueda...");
		List<EventoSistemaType> listaType = EventoSistemaES.buscarListaEmailPorDatosGenerales(usuarioEnvio, asunto, destinatario, estado);
		logger.info("Lista de salida: "+listaType);
		logger.info("Iniciando casteo a lista de salida..");
		ListaEmailEnviadasBean bean = null;
		for (EventoSistemaType eventoType : listaType) {
			bean = new ListaEmailEnviadasBean();
			bean.setEnvioId(eventoType.getEnvioId().getEnvioId());
			bean.setAsunto(eventoType.getEnvioId().getAsunto());
			bean.setDestinatario(eventoType.getEnvioId().getDestinatario());
			bean.setFechaEnvio(eventoType.getEnvioId().getFechaEnvio());
			bean.setEstado(eventoType.getEnvioId().getEstado());
			bean.setUsuarioEnvio(eventoType.getContactoId().getNombre());
			lista.add(bean);
		}
		logger.info("Terminando de setear valores lista..");
		logger.info("Lista de salida: "+ lista);
		return lista;
	}

}
