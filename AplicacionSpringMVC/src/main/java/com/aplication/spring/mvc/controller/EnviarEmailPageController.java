package com.aplication.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/views/portal/pagina/EnviarEmail")
public class EnviarEmailPageController {

	@RequestMapping(method = RequestMethod.GET)
	public String displayEnviarEmailPage() {
		return "portal/pagina/jsp/enviarEmail";
	}

}
