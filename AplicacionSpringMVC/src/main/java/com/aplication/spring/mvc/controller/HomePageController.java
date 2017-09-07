package com.aplication.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/views/portal/pagina/Home")
public class HomePageController {

	@RequestMapping(method = RequestMethod.GET)
	public String displayHomePage() {
		return "/portal/pagina/jsp/Home";
	}

}
