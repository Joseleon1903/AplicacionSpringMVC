package com.aplication.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aplicacion.spring.mvc.session.beans.UsuarioSession;
import com.aplicacion.spring.mvc.vista.beans.ActualizarUsuarioBean;
import com.aplicacion.spring.mvc.vista.beans.ManejadorActualizarUsuarioBean;
import com.aplicacion.spring.mvc.vista.beans.ManejadorSistemaUtil;

@Controller
@RequestMapping(value = "/views/portal/pagina/ActualizarContacto")
public class ActualizarContactoPageController {
	
	private static final Logger logger = Logger.getLogger(ActualizarContactoPageController.class);

	@Autowired
	@Qualifier("manejadorSistemaUtil")
	private ManejadorSistemaUtil manejadorSistemaUtil;
	
	@Autowired
	@Qualifier("usuarioSession")
	private UsuarioSession sessionUsuario;
	
	@Autowired
	@Qualifier("actualizarUsuarioBean")
	private ActualizarUsuarioBean actualizarUsuarioBean;
	
	@Autowired
	@Qualifier("manejadorActualizarUsuarioBean")
	private ManejadorActualizarUsuarioBean  manejadorActualizarUsuario;

	@RequestMapping(method = RequestMethod.GET)
	public String displayActualizarContactoPage(HttpServletRequest request,  Model model) {
		logger.info("UsuarioSession: " + sessionUsuario);
		String pagina = manejadorSistemaUtil.validandoSession(sessionUsuario, "portal/pagina/jsp/actualizarContacto");
		actualizarUsuarioBean = manejadorActualizarUsuario.buscarUsuarioLoginSistema(sessionUsuario.getUsuarioId());
		model.addAttribute("usuarioSession", sessionUsuario);
		model.addAttribute("ActualizarUsuarioBean", actualizarUsuarioBean);
		logger.info("cargando pagina: "+ pagina);
		return pagina;
	}
	
	

}
