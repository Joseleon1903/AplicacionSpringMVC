package com.aplication.spring.mvc.spring;

import java.util.Date;

import com.aplicacion.spring.mvc.ejb.impl.UsuarioEjbImpl;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.layer.type.ContactoType;
import com.aplication.spring.mvc.layer.type.DetalleContactoType;
import com.aplication.spring.mvc.layer.type.UsuarioType;

public class TestJPA {

	public TestJPA() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("---------com.aplication.spring.mvc.spring-------------");
		UsuarioType userType = new UsuarioType();
		userType.setCodigoUsuario("prueba");
		userType.setPassword("prueba1");
		userType.setFechaCreacion(new Date());
		userType.setFechaUltimoAcceso(new Date());
		//seteando datos contacto
		ContactoType contactoType=  new ContactoType();
		contactoType.setNombre("prueba");
		contactoType.setApellido("prueba test");
		contactoType.setSexo("M");
		contactoType.setFechaNacimineto(new Date());
		contactoType.setEmail("prueba@gmail.com");
		contactoType.setEstado("AC");
		//seteando datos detalle contacto
		DetalleContactoType detalleType = new DetalleContactoType();
		detalleType.setCorreoAlterno("prueba2@outlook.com");
		detalleType.setTelefono("8096249897");
		detalleType.setCelular("8096249777");
		//completando datos usuario
		contactoType.setDetalleContactoId(detalleType);
		userType.setContacto(contactoType);
		System.out.println("Usuario a registrar "+ userType);
		System.out.println("Iniciando registracion usuario");
		boolean registrado = false;
		UsuarioEjbImpl usuarioES = new UsuarioEjbImpl();
		try {
			registrado = usuarioES.registrarNuevoUsuarioSistema(userType);
		} catch (InternalServiceException e) {
			e.printStackTrace();
		}
		System.out.println("Usuario: "+ userType);
		System.out.println("Registrado: "+ registrado);
	}

}
