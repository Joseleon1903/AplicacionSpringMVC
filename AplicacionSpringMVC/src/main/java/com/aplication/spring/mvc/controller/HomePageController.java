package com.aplication.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aplicacion.spring.mvc.vista.beans.BusquedaOferta;

@Controller
@RequestMapping(value = "/Home")
public class HomePageController {

//	@RequestMapping(method = RequestMethod.GET)
//	public String redirectHome() {
//		return "portal/pagina/jsp/Home";
//	}

	@RequestMapping(method = RequestMethod.GET)
	public String preparaForm(HttpServletRequest request,  Model modelo) {
		modelo.addAttribute("bo", new BusquedaOferta("Oferta 1", 5,(short)5));
		return "portal/pagina/jsp/Home";
	}

}
