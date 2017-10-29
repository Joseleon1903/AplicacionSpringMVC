package com.aplicacion.spring.mvc.vista.beans;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.aplicacion.spring.mvc.repository.dao.EventoSistemaRepositoryDao;
import com.aplicacion.spring.mvc.repository.dao.UsuarioRepositoryDao;
import com.aplicacion.spring.mvc.session.beans.UsuarioSession;
import com.aplication.spring.mvc.layer.type.EventoSistemaType;

@Component
public class ManejadorListaEmailSistemaBean {
	
	private static final Logger logger = Logger.getLogger(ManejadorListaEmailSistemaBean.class);

	@Autowired
	@Qualifier("EventoSistemaDao")
	private EventoSistemaRepositoryDao EventoSistemaES;
	
	@Autowired
	@Qualifier("UsuarioDao")
	private UsuarioRepositoryDao usuarioES;

	@Autowired
	@Qualifier("manejadorSistemaUtil")
	private ManejadorSistemaUtil manejadorUtil;


	public ManejadorListaEmailSistemaBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<ListaEmailEnviadasBean> buscarListaEmailDefault(UsuarioSession session, UsuarioSession sessionUser){
		logger.info("Entrando en el metodo buscarListaEmailDefault..");
		List<ListaEmailEnviadasBean> lista = new ArrayList<>();	
		logger.info("Iniciando busqueda...");
		List<EventoSistemaType> listaType = EventoSistemaES.buscarListaEmailSistema(sessionUser.getContactoId());
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
	
	public List<ListaEmailEnviadasBean> filtrarEmailPorDatosGenerales(String usuarioEnvio, String asunto,
			String destinatario, String estado) {
		logger.info("Entrando en el metodo filtrarEmailPorDatosGenerales..");
		List<ListaEmailEnviadasBean> lista = new ArrayList<>();
		logger.info("Iniciando busqueda...");
		List<EventoSistemaType> listaType = EventoSistemaES.buscarListaEmailPorDatosGenerales(usuarioEnvio, asunto,destinatario, estado);
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
		logger.info("Lista de salida: " + lista);
		return lista;
	}

}
