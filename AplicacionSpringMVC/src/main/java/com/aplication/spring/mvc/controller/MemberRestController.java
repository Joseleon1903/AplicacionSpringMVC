/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aplication.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aplication.spring.mvc.ejb.impl.MotivoEstadoEjbImpl;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.layer.type.MotivoEstadoType;

@Controller
@RequestMapping("/motivoEstado")
public class MemberRestController {

	private MotivoEstadoEjbImpl motivoEstadoEjb = new MotivoEstadoEjbImpl();

//    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody List<MotivoEstadoType> listAllMembers() {
//       return null;
//    }
//
    @RequestMapping(value = "/buscarMotivoEstadoPorId/{motivoId}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody MotivoEstadoType buscarMotivoEstadoPorId(@PathVariable("motivoId") Integer id) {
    	try {
			return motivoEstadoEjb.buscarMotivoPorId(id);
		} catch (InternalServiceException e) {
			e.printStackTrace();
		}
		return new MotivoEstadoType(InternalServiceException.CODIGO, InternalServiceException.DESCRIPCION, "AC");
    }
}
