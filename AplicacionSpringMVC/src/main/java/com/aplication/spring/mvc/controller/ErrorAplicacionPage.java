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
import com.aplicacion.spring.mvc.vista.beans.ErrorPageBean;
import com.aplicacion.spring.mvc.vista.beans.ManejadorSistemaUtil;

@Controller
@RequestMapping(value = "/views/portal/pagina/Error")
public class ErrorAplicacionPage {

	private static final Logger logger = Logger.getLogger(ErrorAplicacionPage.class);
	
	@Autowired
	@Qualifier("usuarioSession")
	private UsuarioSession sessionUsuario;
	
	@Autowired
	@Qualifier("manejadorSistemaUtil")
	private ManejadorSistemaUtil manejadorSistemaUtil;
	
	@Autowired
	@Qualifier("errorPageBean")
	private ErrorPageBean errorPageBean;

	@RequestMapping(method = RequestMethod.GET)
	public String displayHomePage(HttpServletRequest request,  Model model) {
//		String pagina = manejadorSistemaUtil.validandoSession(sessionUsuario, "/portal/pagina/jsp/Error");
		model.addAttribute("usuarioSession", sessionUsuario);
//		logger.info("cargando pagina: "+ pagina);
//		return pagina;
		model.addAttribute("ErrorPageBean", errorPageBean);
		return "/portal/pagina/jsp/Error";
	}


}
