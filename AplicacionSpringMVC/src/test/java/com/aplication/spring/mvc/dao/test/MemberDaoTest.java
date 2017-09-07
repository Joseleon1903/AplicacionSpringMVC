package com.aplication.spring.mvc.dao.test;

import com.aplicacion.rest.html.ejb.impl.UsuarioEjbImpl;
import com.aplication.spring.mvc.layer.type.UsuarioType;

public class MemberDaoTest {
	
	
	public static void main(String args[]){
		System.out.println("com.aplication.spring.mvc.dao.test");
		UsuarioEjbImpl usuarioESDao = new UsuarioEjbImpl();
		UsuarioType usertype = usuarioESDao.buscarUsuarioPorCodigo("ADMIN");
		System.out.println(usertype);
		System.out.println("--------------**************----------------------");
//		Usuario usuarioUlti =new UsuarioType().toEntity(usertype);
//		usuarioUlti.setFechaUltimoAcceso(new Date());
//		boolean actualizado = usuarioESDao.ActualizarAccesoUsuario(usuarioUlti);
//		System.out.println("Actualizado: "+actualizado);
	}
	
	
}
