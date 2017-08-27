package com.aplication.spring.mvc.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

import com.aplication.spring.mvc.ejb.impl.ContactoEjbImpl;
import com.aplication.spring.mvc.ejb.impl.EventoSistemaEjbImpl;
import com.aplication.spring.mvc.ejb.impl.MotivoEstadoEjbImpl;
import com.aplication.spring.mvc.ejb.impl.UsuarioEjbImpl;
import com.aplication.spring.mvc.exception.DuplicateObjectException;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.exception.InvalidDataException;
import com.aplication.spring.mvc.exception.NotFoundObjectError;
import com.aplication.spring.mvc.layer.type.ContactoType;
import com.aplication.spring.mvc.layer.type.EnvioSistemaType;
import com.aplication.spring.mvc.layer.type.EventoSistemaType;
import com.aplication.spring.mvc.layer.type.MotivoEstadoType;
import com.aplication.spring.mvc.layer.type.UsuarioType;

public class AplicacionJpaTest {

	UsuarioEjbImpl UsuarioEJB = new UsuarioEjbImpl();

	MotivoEstadoEjbImpl motivoEJB = new MotivoEstadoEjbImpl();

	EventoSistemaEjbImpl eventoEjb = new EventoSistemaEjbImpl();

	ContactoEjbImpl ContactoEjb = new ContactoEjbImpl();

	// test buscarUsuarioPorCodigo
	@Test
	public void buscarUsuarioPorCodigoTest() {

		UsuarioType usuarioType = null;
		try {
			usuarioType = UsuarioEJB.buscarUsuarioPorCodigo("ADMIN");
		} catch (InternalServiceException | NotFoundObjectError e) {
			fail(InternalServiceException.DESCRIPCION);
		}
		assertNotNull(usuarioType.getNombre());
	}

	// test buscarMotivoEstado
	@Test
	public void buscarMotivoEstadoTest() {

		MotivoEstadoType motivo = null;
		try {
			motivo = motivoEJB.buscarMotivoPorId(500);
		} catch (InternalServiceException e) {
			fail(InternalServiceException.DESCRIPCION);
		}
		assertNotNull(motivo.getMotivoId());
	}

	@Test
	public void registrarEventoSistemaTest() {

		EventoSistemaType eventoType = new EventoSistemaType();
		EnvioSistemaType envioType = new EnvioSistemaType();
		Boolean registrado = null;
		eventoType.setFechaEvento(new Date());
		envioType.setAsunto("Prueba");
		envioType.setDestinatario("mario@gmail.com");
		envioType.setEstado("AC");
		envioType.setContenido("Prueba encio email");
		envioType.setFechaEnvio(new Date());
		eventoType.setEnvioId(envioType);
		ContactoType contacto = null;
		try {
			contacto = ContactoEjb.buscarContactoPorId(1);
		} catch (InternalServiceException e) {
			e.printStackTrace();
		}
		eventoType.setContactoId(contacto);
		try {
			registrado = eventoEjb.registrarEmailEnviada(eventoType);
		} catch (InternalServiceException | DuplicateObjectException | InvalidDataException e) {
			e.printStackTrace();
		}
		assertNotNull(registrado);
	}

	// test buscarContactoPorIdTest
	@Test
	public void buscarContactoPorIdTest() {

		ContactoType contacto = null;
		try {
			contacto = ContactoEjb.buscarContactoPorId(1);
		} catch (InternalServiceException e) {
			fail(InternalServiceException.DESCRIPCION);
		}
		assertNotNull(contacto.getContactoId());
	}

}
