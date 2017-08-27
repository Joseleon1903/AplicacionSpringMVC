package com.aplicacion.rest.html.test;

import java.util.Date;

import com.aplicacion.rest.html.ejb.impl.ContactoEjbImpl;
import com.aplicacion.rest.html.ejb.impl.EventoSistemaEjbImpl;
import com.aplicacion.rest.html.exception.DuplicateObjectException;
import com.aplicacion.rest.html.exception.InternalServiceException;
import com.aplicacion.rest.html.exception.InvalidDataException;
import com.aplicacion.rest.html.layer.type.ContactoType;
import com.aplicacion.rest.html.layer.type.EnvioSistemaType;
import com.aplicacion.rest.html.layer.type.EventoSistemaType;
import com.aplicacion.rest.html.layer.type.MotivoEstadoType;

public class AplicationTest {
	
	public static void main(String args[]) {
		
		EventoSistemaEjbImpl eventoEjb = new EventoSistemaEjbImpl();

		ContactoEjbImpl ContactoEjb = new ContactoEjbImpl();
		
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
		MotivoEstadoType motivo = new MotivoEstadoType();
		motivo.setDescripcion("Prueba");
		motivo.setEstado("AC");
		try {
			contacto = ContactoEjb.buscarContactoPorId(1);
		} catch (InternalServiceException e) {
			e.printStackTrace();
		}
		eventoType.setContactoId(contacto);
		//eventoType.getEnvioId().setMotivoId(motivo);
		try {
			System.out.println("Input eventoType: "+ eventoType);
			registrado = eventoEjb.registrarEmailEnviada(eventoType);
		} catch (InternalServiceException | DuplicateObjectException | InvalidDataException e) {
			e.printStackTrace();
		}
		System.out.println("Respuesta: "+registrado );

	}
	

}
