package com.aplication.spring.mvc.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="envio_sistema")
@NamedQueries({
		 @NamedQuery(name="EnvioSistema.BuscarTodos", query="SELECT e FROM EnvioSistema e") ,
		 @NamedQuery(name="EnvioSistema.BuscarPorId", query="SELECT e FROM EnvioSistema e where e.envioId = :envioId")
})
public class EnvioSistema {
	
	private Integer envioId;
	private Date fechaEnvio;
	private String asunto;
	private String destinatario;
	private String contenido;
	private String estado;
	private MotivoEstado motivoId;
	
	public EnvioSistema() {
		
	}

	public EnvioSistema(Integer envioId) {
		this.envioId = envioId;
	}
	
	public EnvioSistema(Integer envioId, Date fechaEnvio, String asunto, String destinatario, String contenido,
			String estado, MotivoEstado motivoId) {
		super();
		this.envioId = envioId;
		this.fechaEnvio = fechaEnvio;
		this.asunto = asunto;
		this.destinatario = destinatario;
		this.contenido = contenido;
		this.estado = estado;
		this.motivoId = motivoId;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ENVIO_ID", nullable= false)
	public Integer getEnvioId() {
		return envioId;
	}

	public void setEnvioId(Integer envioId) {
		this.envioId = envioId;
	}

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="FECHA_ENVIO", nullable= false)
	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	
    @Column(name="ASUNTO", nullable= false)
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

    @Column(name="DESTINATARIO", nullable= false)
	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

    @Column(name="CONTENIDO", nullable= false)
	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

    @Column(name="ESTADO", nullable= false)
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="MOTIVO_ID", nullable= true)
	public MotivoEstado getMotivoId() {
		return motivoId;
	}

	public void setMotivoId(MotivoEstado motivoId) {
		this.motivoId = motivoId;
	}

	@Override
	public String toString() {
		return "EnvioSistema [envioId=" + envioId + ", asunto=" + asunto + ", destinatario=" + destinatario
				+ ", contenido=" + contenido + ", estado=" + estado + ", motivoId=" + motivoId + "]";
	}
	
	public static interface Columnas{
		String ENVIO_ID       = "ENVIO_ID";
		String FECHA_ENVIO    = "FECHA_ENVIO";
		String ASUNTO         = "ASUNTO";
		String DESTINATARIO   = "DESTINATARIO";
		String CONTENIDO      = "CONTENIDO";
		String ESTADO         = "ESTADO";
		String MOTIVO_ID      = "MOTIVO_ID";
	}
	
}
