package com.aplication.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aplicacion.spring.mvc.vista.beans.LoginBean;
import com.aplicacion.spring.mvc.vista.beans.ManejadorUsuarioLoginBean;

@Controller
@RequestMapping(value = "/")
public class LoginController {
	
	@Autowired
	@Qualifier("manejadorUsuarioLoginBean")
	private ManejadorUsuarioLoginBean manejadorUsuario;
	
	@Autowired
	@Qualifier("loginBean")
	private LoginBean loginBean;
  

    @RequestMapping(method = RequestMethod.GET)
    public String displayLoginController(HttpServletRequest request,  Model model) {
    	loginBean.setCodigoUsuario("Mario");
    	model.addAttribute("LoginBean", loginBean);
        return "index";
    }
    

//    @RequestMapping(method = RequestMethod.POST)
//    public String registerNewMember(@Valid @ModelAttribute("newMember") Member newMember, BindingResult result, Model model) {
//        if (!result.hasErrors()) {
//            try {
//                memberDao.register(newMember);
//                return "redirect:/";
//            } catch (UnexpectedRollbackException e) {
//                model.addAttribute("members", memberDao.findAllOrderedByName());
//                model.addAttribute("error", e.getCause().getCause());
//                return "index";
//            }
//        } else {
//            model.addAttribute("members", memberDao.findAllOrderedByName());
//            return "index";
//        }
//    }
}
