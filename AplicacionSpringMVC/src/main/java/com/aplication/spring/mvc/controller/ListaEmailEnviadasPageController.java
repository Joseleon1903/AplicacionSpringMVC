package com.aplication.spring.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aplicacion.spring.mvc.session.beans.UsuarioSession;
import com.aplicacion.spring.mvc.vista.beans.ListaEmailEnviadasBean;
import com.aplicacion.spring.mvc.vista.beans.ManejadorListaEmailSistemaBean;
import com.aplicacion.spring.mvc.vista.beans.ManejadorSistemaUtil;

@Controller
@RequestMapping(value = "/views/portal/pagina/ListaEmailEnviadas")
public class ListaEmailEnviadasPageController {
	
	private static final Logger logger = Logger.getLogger(ListaEmailEnviadasPageController.class);
	
	@Autowired
	@Qualifier("manejadorSistemaUtil")
	private ManejadorSistemaUtil manejadorSistemaUtil;
	
	@Autowired
	@Qualifier("usuarioSession")
	private UsuarioSession sessionUsuario;
	
	@Autowired
	@Qualifier("manejadorListaEmailSistemaBean")
	private ManejadorListaEmailSistemaBean manejadorListaEmailBean;
	
	@Autowired
	@Qualifier("listaEmailEnviadasBean")
	private ListaEmailEnviadasBean listaEmailBean;

	@RequestMapping(method = RequestMethod.GET)
	public String displayListaEmailEnviadasPage(HttpServletRequest request,  Model model) {
		String pagina = manejadorSistemaUtil.validandoSession(sessionUsuario, "portal/pagina/jsp/listaEmailEnviadas");
		if (sessionUsuario.isAutenticado()) {
			List<ListaEmailEnviadasBean> listOutput = manejadorListaEmailBean.buscarListaEmailDefault(sessionUsuario);
			model.addAttribute("ListaEmailEnviadasBean", listOutput);
		}
		model.addAttribute("UsuarioSession", sessionUsuario);
		logger.info("cargando pagina: "+ pagina);
		return pagina;
	}
	
	@RequestMapping(value="/BuscarListaEmail", method = RequestMethod.POST)
	public String filtrarListaEmailEnviadasLista(@RequestParam("UsuarioEnvio") String usuarioEnvio,
			@RequestParam("Asunto") String asunto, @RequestParam("Destinatario") String destinatario,
			@RequestParam("Estado") String estado, Model model) {
		logger.info("Entrando en el formulario filtrarListaEmailEnviadasLista");
		logger.info("UsuarioEnvio: "+usuarioEnvio);
		logger.info("Asunto: "+asunto);
		logger.info("Destinatario: "+destinatario);
		logger.info("Estado: "+estado);
		return "portal/pagina/jsp/listaEmailEnviadas";
	}


}
