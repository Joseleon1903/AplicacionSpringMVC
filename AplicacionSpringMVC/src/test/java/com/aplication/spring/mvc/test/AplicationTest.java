package com.aplication.spring.mvc.test;

import java.util.Date;

import com.aplication.spring.mvc.ejb.impl.ContactoEjbImpl;
import com.aplication.spring.mvc.ejb.impl.EventoSistemaEjbImpl;
import com.aplication.spring.mvc.exception.DuplicateObjectException;
import com.aplication.spring.mvc.exception.InternalServiceException;
import com.aplication.spring.mvc.exception.InvalidDataException;
import com.aplication.spring.mvc.layer.type.ContactoType;
import com.aplication.spring.mvc.layer.type.EnvioSistemaType;
import com.aplication.spring.mvc.layer.type.EventoSistemaType;
import com.aplication.spring.mvc.layer.type.MotivoEstadoType;

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
