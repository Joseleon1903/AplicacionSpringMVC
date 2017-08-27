package com.aplication.spring.mvc.spring;

import java.util.List;

import com.aplication.spring.mvc.dao.UsuarioDao;
import com.aplication.spring.mvc.dao.impl.UsuarioDaoImpl;
import com.aplication.spring.mvc.ejb.impl.ContactoEjbImpl;
import com.aplication.spring.mvc.ejb.impl.MotivoEstadoEjbImpl;
import com.aplication.spring.mvc.ejb.impl.UsuarioEjbImpl;
import com.aplication.spring.mvc.entity.Usuario;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.exception.NotFoundObjectError;
import com.aplication.spring.mvc.exception.ServiceFault;
import com.aplication.spring.mvc.jpa.util.PersistenceManager;
import com.aplication.spring.mvc.layer.type.ContactoType;
import com.aplication.spring.mvc.layer.type.GenericResponseType;
import com.aplication.spring.mvc.layer.type.MotivoEstadoType;
import com.aplication.spring.mvc.layer.type.UsuarioType;

public class AppJpa {
	
	static PersistenceManager persistenceManager;

	public static void main(String[] args) {
		System.out.println("com.aplicacion.ejemplo.spring");
		
		//provandoUtilizoDeJPA();
		
		//provandoBuscarListaEntityPorNameQueryConRetorno();
		
		//provandoUsuarioEjbBuscarPorCodigo();
		
		//provandoContactoEjbActualizarContacto();
		
//		provandoJPAMotivoEstado();
//		
//		provandoUsuarioEjbBuscarPorId();
		
		provandoJPABuscarTodosMotivoEstado();

	}
	
	
	/**
	 * Provando el utilizo de JPA
	 * 
	 */
	public static void provandoUtilizoDeJPA(){
		System.out.println("---------- BEGIN provandoUtilizoDeJPA--");
		UsuarioDao dao = new UsuarioDaoImpl(persistenceManager);
		List<Usuario> listado = dao.buscarTodosLosUsuarios();
		for (Usuario usuario : listado) {
			System.out.println(usuario);
		}
		System.out.println("---------- END provandoUtilizoDeJPA------");
	}
	
	public static void provandoBuscarEntityPorNameQueryConRetorno(){
		System.out.println("---------- BEGIN buscarEntityPorNameQueryConRetorno--");
		UsuarioDao dao = new UsuarioDaoImpl(persistenceManager);
		Usuario user = dao.buscarUsuarioPorId(1);
		System.out.println("Result: "+ user);
		System.out.println("---------- END provandoUtilizoDeJPA------");
	}
	
	public static void provandoBuscarListaEntityPorNameQueryConRetorno(){
		System.out.println("---------- BEGIN provandoBuscarListaEntityPorNameQueryConRetorno--");
		UsuarioDao dao = new UsuarioDaoImpl(persistenceManager);
		List<Usuario> user = dao.buscarTodosLosUsuarios();
		user.forEach(item->System.out.println(item));
		System.out.println("Result: "+ user);
		System.out.println("---------- END provandoBuscarListaEntityPorNameQueryConRetorno------");
	}
	
	public static void provandoUsuarioEjbBuscarPorCodigo(){
		System.out.println("---------- BEGIN provandoUsuarioEjbBuscarPorCodigo--");
		UsuarioEjbImpl usuarioEjb = new UsuarioEjbImpl();
		UsuarioType user  = null;
		try {
			 user = usuarioEjb.buscarUsuarioPorCodigo("ADMIN3");
		} catch (InternalServiceException | NotFoundObjectError e) {
			System.out.println("Error tratando de buscar el usuario..");
			e.printStackTrace();
		}
		 
		System.out.println("Result: "+user);
		System.out.println("---------- END provandoUsuarioEjbBuscarPorCodigo------");
	}
	
	public static void provandoContactoEjbActualizarContacto(){
		System.out.println("---------- BEGIN provandoContactoEjbActualizarContacto--");
		boolean result = false;
		ContactoEjbImpl contctoEjb = new ContactoEjbImpl();
		ContactoType contacto = new ContactoType();
		contacto.setContactoId(1);
		contacto.setNombre("Julio");
		contacto.setApellido("Verme");
		contacto.setSexo("M");
		contacto.setEdad(20);
		try {
			result =contctoEjb.actualizarContacto(contacto);
		} catch (InternalServiceException e) {
			System.out.println("Error actualizando contacto");
			e.printStackTrace();
		}
		
		System.out.println("Actualizar : "+contacto);
		System.out.println("Exito : "+result);

		System.out.println("---------- END provandoContactoEjbActualizarContacto------");
	}
	

	public static void provandoJPAMotivoEstado() {
		System.out.println("com.aplicacion.rest.html.test");
		System.out.println("iniciando aplicacion ejemplo");
		GenericResponseType respGenerica = new GenericResponseType();
		System.out.println("respuesta generica: " + respGenerica);
		MotivoEstadoType motivo = new MotivoEstadoType();
		MotivoEstadoEjbImpl motivoEstadoEjb = new MotivoEstadoEjbImpl();
		try {
			motivo = motivoEstadoEjb.buscarMotivoPorId(500);
		} catch (InternalServiceException e) {
			ServiceFault error1 = new InternalServiceException(InternalServiceException.CODIGO, InternalServiceException.DESCRIPCION);
			System.out.println(error1);
			respGenerica.setError(error1);
		}
		respGenerica.setRespuesta(motivo);
		System.out.println("Motivo Estado Respuesta: " + respGenerica);
	}
	
	public static void provandoUsuarioEjbBuscarPorId(){
		System.out.println("---------- BEGIN provandoUsuarioEjbBuscarPorId--");
		UsuarioEjbImpl usuarioEjb = new UsuarioEjbImpl();
		UsuarioType user  = null;
		try {
			 user = usuarioEjb.buscarusuarioPorId(1);
		} catch (InternalServiceException e) {
			System.out.println("Error tratando de buscar el usuario..");
			e.printStackTrace();
		}
		 
		System.out.println("Result: "+user);
		System.out.println("---------- END provandoUsuarioEjbBuscarPorId------");
	}
	
	public static void provandoJPABuscarTodosMotivoEstado() {
		System.out.println("com.aplicacion.rest.html.test");
		System.out.println("iniciando aplicacion ejemplo");
		GenericResponseType respGenerica = new GenericResponseType();
		System.out.println("respuesta generica: " + respGenerica);
		List<MotivoEstadoType> motivos = null;
		MotivoEstadoEjbImpl motivoEstadoEjb = new MotivoEstadoEjbImpl();
		try {
			motivos = motivoEstadoEjb.buscarTodosLosMotivos();
		} catch (InternalServiceException e) {
			ServiceFault error1 = new InternalServiceException(InternalServiceException.CODIGO, InternalServiceException.DESCRIPCION);
			System.out.println(error1);
			respGenerica.setError(error1);
		}
		respGenerica.setRespuesta(motivos);
		System.out.println("Motivo Estado Respuesta: " + respGenerica);
	}
	
}
