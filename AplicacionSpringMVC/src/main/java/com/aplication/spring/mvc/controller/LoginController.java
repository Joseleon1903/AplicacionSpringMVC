package com.aplication.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;

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
    public String displayLoginController(HttpServletRequest request,  Model model) {
    	String pagina =manejadorUsuario.validandoSession(sessionUsuario);
    	model.addAttribute("LoginBean", loginBean);
        return pagina;
    }
    

    @RequestMapping(method=RequestMethod.POST)
    public String procesaForm(HttpServletRequest request,  Model model) {
    	String pagina = "portal/pagina/jsp/Home";
    	pagina = manejadorUsuario.loginUsuario(loginBean.getCodigoUsuario(), loginBean.getPassword(), sessionUsuario);
    	return pagina;
    }
}
