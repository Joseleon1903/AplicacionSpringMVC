package com.aplication.spring.mvc.controller;

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
import com.aplicacion.spring.mvc.vista.beans.LoginBean;
import com.aplicacion.spring.mvc.vista.beans.ManejadorSistemaUtil;
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
	
	@Autowired
	@Qualifier("manejadorSistemaUtil")
	private ManejadorSistemaUtil manejadorSistemaUtil;
  
    @RequestMapping(method = RequestMethod.GET)
    public String displayLogin(HttpServletRequest request,  Model model) {
    	logger.info("Redirigiendo a pagina de inicio....");
    	logger.info("procediendo a validar la session del usuario.");
    	String pagina =manejadorUsuario.validandoSession(sessionUsuario);
    	logger.info("finalizando a validar la session del usuario.");
    	model.addAttribute("LoginBean", loginBean);
        return pagina;
    }
    

    @RequestMapping(value = "formularioLogin", method=RequestMethod.POST)
    public String procesaForm(@RequestParam("name") String codigoUsuario, @RequestParam("password") String password,  Model model) {
    	logger.info("Longin Bean name: "+ codigoUsuario);
    	logger.info("Login Bean pasword: "+ password);
    	loginBean.setCodigoUsuario(codigoUsuario);
    	loginBean.setPassword(password);
    	String pagina = manejadorUsuario.loginUsuario(loginBean, sessionUsuario);
    	model.addAttribute("LoginBean",loginBean);
    	return pagina;
    }
    
    @RequestMapping(value = "/logout", method=RequestMethod.GET)
    public String logoutUsuario(HttpServletRequest request, Model model) {
    	logger.info("entrando en el metodo logoutUsuario");
    	logger.info("Longin Bean name: "+sessionUsuario );
    	try {
			sessionUsuario.destroy();
			loginBean.setCodigoUsuario("");
			loginBean.setCodigoError(null);
			loginBean.setMensajeError("NONE");
			loginBean.setPassword("");
		} catch (Exception e) {
			logger.info("Error eliminando la session de usuario");
			logger.info("ERROR: "+ e.getMessage());
		}
    	logger.info("session de usuario eliminado con exito");

    	String pagina = manejadorSistemaUtil.validandoSession(sessionUsuario, "/");
    	return pagina;
    }

}
