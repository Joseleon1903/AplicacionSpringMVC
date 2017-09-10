package com.aplicacion.spring.mvc.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aplicacion.spring.mvc.ejb.impl.MotivoEstadoEjbImpl;
import com.aplication.spring.mvc.layer.type.MotivoEstadoType;

@Controller
@RequestMapping(value="/MotivoEstadoES")
public class MotivoEstadoES {
	

	@RequestMapping(value ="/buscarListaMotivosEstadoSistema",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MotivoEstadoType> buscarListaUsuariosSistema() {
		List<MotivoEstadoType> listMotivos = new ArrayList<>();
		MotivoEstadoEjbImpl MotivoEstadoEJB = new MotivoEstadoEjbImpl();
		listMotivos = MotivoEstadoEJB.buscarTodosLosMotivos();
		return listMotivos;
	}

}
