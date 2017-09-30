package com.aplication.spring.mvc.dao.testSuit;

import java.util.Date;

import com.aplicacion.spring.mvc.ejb.impl.UsuarioEjbImpl;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.layer.type.ContactoType;
import com.aplication.spring.mvc.layer.type.DetalleContactoType;
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
		System.out.println("--------------**************----------------------");
		UsuarioType userType = new UsuarioType();
		userType.setCodigoUsuario("Prueba");
		userType.setPassword("Prueba1");
		userType.setFechaCreacion(new Date());
		userType.setFechaUltimoAcceso(new Date());
		//seteando datos contacto
		ContactoType contactoType=  new ContactoType();
		contactoType.setNombre("Prueba Usuario");
		contactoType.setApellido("Test");
		contactoType.setFechaNacimineto(new Date());
		contactoType.setEmail("prueba@gmail.com");
		//seteando datos detalle contacto
		DetalleContactoType detalleType = new DetalleContactoType();
		detalleType.setCorreoAlterno("prueba2@gmail.com");
		detalleType.setTelefono("809-524-6321");
		detalleType.setCelular("896-321-5544");
		//completando datos usuario
		contactoType.setDetalleContactoId(detalleType);
		userType.setContacto(contactoType);
		System.out.println("Usuario: "+ usertype);
		System.out.println("Contacto: "+ usertype.getContacto());
		System.out.println("Detalles contacto: "+ userType.getContacto().getDetalleContactoId());
	}

}
