package com.aplication.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aplicacion.spring.mvc.constante.ParametrosSistemaConstantes;
import com.aplicacion.spring.mvc.session.beans.UsuarioSession;

@Controller
@RequestMapping(value = "/views/portal/pagina/logout")
public class LogOutPageController {
	
	private static final Logger logger = Logger.getLogger(LogOutPageController.class);

	@Autowired
	@Qualifier("usuarioSession")
	private UsuarioSession sessionUsuario;
	
	@RequestMapping(method = RequestMethod.GET)
	public String displayLogOutPageController(HttpServletRequest request,  Model model) {
		logger.info("Entrando en el metodo para desloguear el usuario");
		logger.info("UsuarioID: "+sessionUsuario.getUsuarioId());
		logger.info("Nombre: "+ sessionUsuario.getNombre());
		logger.info("Autenticado: "+ sessionUsuario.isAutenticado());
		logger.info("Iniciando a destruir el usuario");
		try {
			sessionUsuario.destroy();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Finalizando destrucion del usuario");
		logger.info("Redireccionando pagina de login");
		return ParametrosSistemaConstantes.REDIRECT_STR + "/";
	
	}



}
