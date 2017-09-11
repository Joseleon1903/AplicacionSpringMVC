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
import com.aplicacion.spring.mvc.vista.beans.LoginBean;
import com.aplicacion.spring.mvc.vista.beans.ManejadorUsuarioBean;

@Controller
@RequestMapping(value = "/")
public class LoginController {
	 
	private static final Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	@Qualifier("manejadorUsuarioBean")
	private ManejadorUsuarioBean manejadorUsuario;
	
	@Autowired
	@Qualifier("loginBean")
	private LoginBean loginBean;
	
	@Autowired
	@Qualifier("usuarioSession")
	private UsuarioSession sessionUsuario;
  
    @RequestMapping(method = RequestMethod.GET)
    public String displayLogin(HttpServletRequest request,  Model model) {
    	logger.info("Redirigiendo a pagina de inicio....");
    	logger.info("procediendo a validar la session del usuario.");
    	String pagina =manejadorUsuario.validandoSession(sessionUsuario);
    	logger.info("finalizando a validar la session del usuario.");
    	model.addAttribute("LoginBean", loginBean);
        return pagina;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String procesaForm(HttpServletRequest request,  Model model) {
    	logger.info("Longin Bean name: "+ loginBean.getCodigoUsuario());
    	logger.info("Login Bean pasword: "+ loginBean.getPassword());
    	String pagina = manejadorUsuario.loginUsuario("ADMIN", "ADMIN124", sessionUsuario);
    	return pagina;
    }
    
}
