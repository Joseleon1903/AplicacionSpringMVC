package com.aplication.spring.mvc.dao.testSuit;

import java.util.Date;

import com.aplication.spring.mvc.layer.type.ContactoType;
import com.aplication.spring.mvc.layer.type.DetalleContactoType;
import com.aplication.spring.mvc.layer.type.UsuarioType;

public class TestJPA {

	public TestJPA() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("---------com.aplication.spring.mvc.spring-------------");
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
		contactoType.setFechaNacimiento(new Date());
		contactoType.setEmail("prueba@gmail.com");
		//seteando datos detalle contacto
		DetalleContactoType detalleType = new DetalleContactoType();
		detalleType.setCorreoAlterno("prueba2@gmail.com");
		detalleType.setTelefono("809-524-6321");
		detalleType.setCelular("896-321-5544");
		//completando datos usuario
		contactoType.setDetalleContactoId(detalleType);
		userType.setContacto(contactoType);
		System.out.println("Usuario: "+ userType);
		System.out.println("Contacto: "+ userType.getContacto());
		System.out.println("Detalles contacto: "+ userType.getContacto().getDetalleContactoId());

	}

}
