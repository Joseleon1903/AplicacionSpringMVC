package com.aplicacion.rest.html.layer.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.aplicacion.rest.html.entity.EventoSistema;
import com.aplicacion.rest.html.interfaces.comunes.BuscableType;

@XmlRootElement(name = "EventoSistemaType")
public class EventoSistemaType implements BuscableType<EventoSistemaType, EventoSistema>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5124523241279229648L;
	
	private Integer eventoSistemaId;
	private ContactoType ContactoId;
	private Date fechaEvento;
	private EnvioSistemaType envioId;

	public EventoSistemaType() {
		super();
	}

	public EventoSistemaType(Integer eventoSistemaId, ContactoType contactoId, Date fechaEvento, EnvioSistemaType envioId) {
		super();
		this.eventoSistemaId = eventoSistemaId;
		ContactoId = contactoId;
		this.fechaEvento = fechaEvento;
		this.envioId = envioId;
	}

	public Integer getEventoSistemaId() {
		return eventoSistemaId;
	}

	public void setEventoSistemaId(Integer eventoSistemaId) {
		this.eventoSistemaId = eventoSistemaId;
	}

	public ContactoType getContactoId() {
		return ContactoId;
	}

	public void setContactoId(ContactoType contactoId) {
		ContactoId = contactoId;
	}

	public Date getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public EnvioSistemaType getEnvioId() {
		return envioId;
	}

	public void setEnvioId(EnvioSistemaType envioId) {
		this.envioId = envioId;
	}

	@Override
	public String toString() {
		return "EventoSistemaType [eventoSistemaId=" + eventoSistemaId + ", ContactoId=" + ContactoId + ", fechaEvento="
				+ fechaEvento + ", envioId=" + envioId + "]";
	}

	@Override
	public EventoSistemaType toType(EventoSistema entity) {
		this.setEventoSistemaId(entity.getEventoSistemaId());
		this.setContactoId(new ContactoType().toType(entity.getContactoId()));
		this.setFechaEvento(entity.getFechaEvento());
		this.setEnvioId(new EnvioSistemaType().toType(entity.getEnvioId()));
		return this;
	}

	@Override
	public EventoSistema toEntity(EventoSistemaType type) {
		EventoSistema evento = new EventoSistema();
		evento.setEventoSistemaId(type.getEventoSistemaId());
		evento.setContactoId(new ContactoType().toEntity(type.getContactoId()));
		evento.setFechaEvento(type.getFechaEvento());
		evento.setEnvioId(new EnvioSistemaType().toEntity(type.getEnvioId()));
		return evento;
	}

	@Override
	public List<EventoSistemaType> toListType(List<EventoSistema> entityList) {
		List<EventoSistemaType> listType = new ArrayList<>();
		for (EventoSistema eventoSistema : entityList) {
			listType.add(new EventoSistemaType().toType(eventoSistema));
		}
		return listType;
	}

}
