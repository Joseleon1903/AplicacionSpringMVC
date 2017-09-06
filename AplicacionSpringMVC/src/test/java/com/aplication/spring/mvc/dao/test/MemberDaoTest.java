package com.aplication.spring.mvc.dao.test;

import java.util.Date;

import com.aplicacion.spring.mvc.interfaces.IUsuarioES;
import com.aplicacion.spring.mvc.interfaces.impl.UsuarioESImpl;
import com.aplication.spring.mvc.entity.Usuario;
import com.aplication.spring.mvc.jpa.util.PersistenceManager;
import com.aplication.spring.mvc.layer.type.UsuarioType;

public class MemberDaoTest {
	
	private static PersistenceManager persistence;
	
	public static void main(String args[]){
		System.out.println("com.aplication.spring.mvc.dao.test");
		IUsuarioES usuarioESDao = new UsuarioESImpl(persistence);
		UsuarioType usertype = usuarioESDao.buscarUsuarioPorCodigo("ADMIN");
		System.out.println(usertype);
		System.out.println("--------------**************----------------------");
//		Usuario usuarioUlti =new UsuarioType().toEntity(usertype);
//		usuarioUlti.setFechaUltimoAcceso(new Date());
//		boolean actualizado = usuarioESDao.ActualizarAccesoUsuario(usuarioUlti);
//		System.out.println("Actualizado: "+actualizado);
	}
	
	
}
