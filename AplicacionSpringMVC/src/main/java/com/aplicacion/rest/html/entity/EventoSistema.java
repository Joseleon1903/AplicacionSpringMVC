package com.aplicacion.rest.html.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="evento_sistema")
@NamedQueries({
		 @NamedQuery(name="EventoSistema.BuscarTodos", query="SELECT e FROM EventoSistema e") ,
		 @NamedQuery(name="EventoSistema.BuscarPorId", query="SELECT e FROM EventoSistema e where e.eventoSistemaId = :eventoSistemaId")
})
public class EventoSistema {

	  private Integer eventoSistemaId;
	  private Contacto ContactoId;
	  private Date fechaEvento;
	  private EnvioSistema envioId;
	  
	public EventoSistema() {
	}

	public EventoSistema(Integer eventoSistemaId, Contacto contactoId, Date fechaEvento, EnvioSistema envioId) {
		super();
		this.eventoSistemaId = eventoSistemaId;
		ContactoId = contactoId;
		this.fechaEvento = fechaEvento;
		this.envioId = envioId;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "EVENTO_SISTEMA_ID", nullable = false)
	public Integer getEventoSistemaId() {
		return eventoSistemaId;
	}

	public void setEventoSistemaId(Integer eventoSistemaId) {
		this.eventoSistemaId = eventoSistemaId;
	}
	
	@ManyToOne
	@JoinColumn(name="CONTACTO_ID")
	public Contacto getContactoId() {
		return ContactoId;
	}

	public void setContactoId(Contacto contactoId) {
		ContactoId = contactoId;
	}
	
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_EVENTO", nullable = false)
	public Date getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="ENVIO_ID")
	public EnvioSistema getEnvioId() {
		return envioId;
	}

	public void setEnvioId(EnvioSistema envioId) {
		this.envioId = envioId;
	}

	@Override
	public String toString() {
		return "EventoSistema [eventoSistemaId=" + eventoSistemaId + ", ContactoId=" + ContactoId + ", envioId="
				+ envioId + "]";
	}

	public static interface Columnas {
		String EVENTO_SISTEMA_ID = "EVENTO_SISTEMA_ID";
		String CONTACTO_ID = "CONTACTO_ID";
		String FECHA_EVENTO = "FECHA_EVENTO";
		String ENVIO_ID = "ENVIO_ID";
	}

}
