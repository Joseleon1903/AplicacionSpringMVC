package com.aplication.spring.mvc.dao.testSuit;

import com.aplicacion.spring.mvc.ejb.impl.UsuarioEjbImpl;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.layer.type.UsuarioType;

public class MemberDaoTest {

	public static void main(String args[]) {
		System.out.println("com.aplication.spring.mvc.dao.test");
		UsuarioEjbImpl usuarioESDao = new UsuarioEjbImpl();
		UsuarioType usertype = null;
		try {
			usertype = usuarioESDao.buscarUsuarioPorCodigo("ADMIN");
		} catch (InternalServiceException e) {
			e.printStackTrace();
		}
		System.out.println(usertype);
	}

}
