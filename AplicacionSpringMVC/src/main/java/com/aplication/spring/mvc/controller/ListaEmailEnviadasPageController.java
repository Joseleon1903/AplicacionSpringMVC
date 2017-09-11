package com.aplication.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/views/portal/pagina/ListaEmailEnviadas")
public class ListaEmailEnviadasPageController {

	@RequestMapping(method = RequestMethod.GET)
	public String displayListaEmailEnviadasPage() {
		return "portal/pagina/jsp/listaEmailEnviadas";
	}

}