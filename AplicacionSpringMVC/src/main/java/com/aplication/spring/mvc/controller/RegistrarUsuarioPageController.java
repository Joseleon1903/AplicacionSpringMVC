package com.aplication.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aplicacion.spring.mvc.vista.beans.ManejadorRegistrarUsuarioBean;
import com.aplicacion.spring.mvc.vista.beans.RegistrarUsuarioBean;

@Controller
@RequestMapping(value = "/views/portal/pagina/RegistrarUsuario")
public class RegistrarUsuarioPageController {
	
	private static final Logger logger = Logger.getLogger(RegistrarUsuarioPageController.class);

	@Autowired
	@Qualifier("registrarUsuarioBean")
	private RegistrarUsuarioBean registrarBean;
	
	@Autowired
	@Qualifier("manejadorRegistrarUsuarioBean")
	private ManejadorRegistrarUsuarioBean manejadorUsuario;
	
	@RequestMapping(method = RequestMethod.GET)
	public String displayRegistrarUsuarioPage(HttpServletRequest request,  Model model) {
		model.addAttribute("UsuarioBean", registrarBean);
		return "portal/pagina/jsp/registrarUsuario";
	}
	
    @RequestMapping(method=RequestMethod.POST)
    public String procesaForm(RegistrarUsuarioBean newUsuario,  Model model) {
    	String pagina = manejadorUsuario.validarNuevoUsuario(newUsuario);
    	model.addAttribute("UsuarioBean", registrarBean);
    	//return pagina;
    	return "portal/pagina/jsp/registrarUsuario";
    }

}
