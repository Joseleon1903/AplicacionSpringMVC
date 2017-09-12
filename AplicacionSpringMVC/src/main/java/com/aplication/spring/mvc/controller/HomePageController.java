package com.aplication.spring.mvc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aplicacion.spring.mvc.ejb.impl.MotivoEstadoEjbImpl;
import com.aplicacion.spring.mvc.session.beans.UsuarioSession;
import com.aplicacion.spring.mvc.vista.beans.MotivoEstadoBean;
import com.aplication.spring.mvc.layer.type.MotivoEstadoType;

@Controller
@RequestMapping(value = "/views/portal/pagina/Home")
public class HomePageController {

	@Resource(mappedName = "java:global/AplicacionSpringMVC/MotivoEstadoEjbImpl!com.aplicacion.spring.mvc.ejb.impl.MotivoEstadoEjbImpl")
	private MotivoEstadoEjbImpl motivoEstadoEJB;

	@Autowired
	@Qualifier("usuarioSession")
	private UsuarioSession sessionUsuario;

	@RequestMapping(method = RequestMethod.GET)
	public String displayHomePage(HttpServletRequest request,  Model model) {
		MotivoEstadoBean motivoBean = new MotivoEstadoBean();
		MotivoEstadoType type = motivoEstadoEJB.buscarMotivoPorId(501);
		motivoBean.setMotivoId(type.getMotivoId());
		motivoBean.setDescripcion(type.getDescripcion());
		motivoBean.setEstado("AC");
		model.addAttribute("motivoEstado",motivoBean);
		model.addAttribute("usuarioSession", sessionUsuario);
		return "/portal/pagina/jsp/Home";
	}

}
