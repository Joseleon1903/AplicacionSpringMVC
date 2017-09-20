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

@Controller
@RequestMapping(value = "/views/portal/pagina/Home")
public class HomePageController {
	
	private static final Logger logger = Logger.getLogger(HomePageController.class);

	@Autowired
	@Qualifier("usuarioSession")
	private UsuarioSession sessionUsuario;

	@RequestMapping(method = RequestMethod.GET)
	public String displayHomePage(HttpServletRequest request,  Model model) {
		model.addAttribute("usuarioSession", sessionUsuario);
		return "/portal/pagina/jsp/Home";
	}

}
