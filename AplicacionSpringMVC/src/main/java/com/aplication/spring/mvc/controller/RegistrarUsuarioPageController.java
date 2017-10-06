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
import com.aplicacion.spring.mvc.vista.beans.ManejadorRegistrarUsuarioBean;
import com.aplicacion.spring.mvc.vista.beans.ManejadorSistemaUtil;
import com.aplicacion.spring.mvc.vista.beans.RegistrarUsuarioBean;

@Controller
@RequestMapping(value = "/views/portal/pagina/RegistrarUsuario")
public class RegistrarUsuarioPageController {
	
	private static final Logger logger = Logger.getLogger(RegistrarUsuarioPageController.class);

	@Autowired
	@Qualifier("registrarUsuarioBean")
	private RegistrarUsuarioBean registrarBean;
	
	@Autowired
	@Qualifier("usuarioSession")
	private UsuarioSession sessionUsuario;
	
	@Autowired
	@Qualifier("manejadorRegistrarUsuarioBean")
	private ManejadorRegistrarUsuarioBean manejadorUsuario;
	
	@RequestMapping(method = RequestMethod.GET)
	public String displayRegistrarUsuarioPage(HttpServletRequest request,  Model model) {
		logger.info("Autenticado : "+ sessionUsuario.isAutenticado());
		logger.info("nombre : "+ sessionUsuario.getNombre());
		logger.info("error : "+sessionUsuario.isError());
		logger.info("mensajeError : "+ sessionUsuario.getMensajeError());
		model.addAttribute("UsuarioBean", registrarBean);
		model.addAttribute("SessionUsuario", sessionUsuario);
		return "portal/pagina/jsp/registrarUsuario";
	}
	
    @RequestMapping(method=RequestMethod.POST)
    public String procesaForm(RegistrarUsuarioBean newUsuario,  Model model) {
		logger.info("Autenticado : "+ sessionUsuario.isAutenticado());
		logger.info("nombre : "+ sessionUsuario.getNombre());
		logger.info("error : "+sessionUsuario.isError());
		logger.info("mensajeError : "+ sessionUsuario.getMensajeError());
    	boolean usuarioValido = manejadorUsuario.validarNuevoUsuario(newUsuario,sessionUsuario);
 		if (usuarioValido) {
			String paginaNext = manejadorUsuario.registrarNuevoUsuario(newUsuario,sessionUsuario);
			return paginaNext;
		}
 	   	model.addAttribute("UsuarioBean", registrarBean);
 		model.addAttribute("SessionUsuario", sessionUsuario);
    	//return pagina;
    	return "portal/pagina/jsp/registrarUsuario";
    }

}
