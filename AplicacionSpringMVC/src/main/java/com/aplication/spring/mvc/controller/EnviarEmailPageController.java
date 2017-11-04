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
import com.aplicacion.spring.mvc.vista.beans.EnviarEmailBean;
import com.aplicacion.spring.mvc.vista.beans.ManejadorSistemaUtil;

@Controller
@RequestMapping(value = "/views/portal/pagina/EnviarEmail")
public class EnviarEmailPageController {
	
	private static final Logger logger = Logger.getLogger(EnviarEmailPageController.class);
	
	@Autowired
	@Qualifier("manejadorSistemaUtil")
	private ManejadorSistemaUtil manejadorSistemaUtil;
	
	@Autowired
	@Qualifier("usuarioSession")
	private UsuarioSession sessionUsuario;
	
	@Autowired
	@Qualifier("enviarEmailBean")
	private EnviarEmailBean enviarMailBean;

	@RequestMapping(method = RequestMethod.GET)
	public String displayEnviarEmailPage(HttpServletRequest request,  Model model) {
		String pagina = manejadorSistemaUtil.validandoSession(sessionUsuario, "portal/pagina/jsp/enviarEmail");
		model.addAttribute("usuarioSession", sessionUsuario);
		logger.info("cargando pagina: "+ pagina);
		return pagina;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String procesarFormEnviaEmail(HttpServletRequest request,  Model model) {
		String pagina = manejadorSistemaUtil.validandoSession(sessionUsuario, "portal/pagina/jsp/enviarEmail");
//		model.addAttribute("usuarioSession", sessionUsuario);
//		logger.info("cargando pagina: "+ pagina);
		return pagina;
	}


}
