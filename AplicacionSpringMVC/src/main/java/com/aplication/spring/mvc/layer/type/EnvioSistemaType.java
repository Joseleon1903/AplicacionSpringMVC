package com.aplication.spring.mvc.layer.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.aplicacion.spring.mvc.interfaces.comunes.BuscableType;
import com.aplication.spring.mvc.entity.EnvioSistema;

@XmlRootElement(name="EnvioSistemaType")
public class EnvioSistemaType implements BuscableType<EnvioSistemaType, EnvioSistema>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 528289630387229570L;
	
	private Integer envioId;
	private Date fechaEnvio;
	private String asunto;
	private String destinatario;
	private String contenido;
	private String estado;
	private MotivoEstadoType motivoId;
	
	public EnvioSistemaType() {
		super();
	}

	public EnvioSistemaType(Integer envioId, Date fechaEnvio, String asunto, String destinatario, String contenido,
			String estado, MotivoEstadoType motivoId) {
		super();
		this.envioId = envioId;
		this.fechaEnvio = fechaEnvio;
		this.asunto = asunto;
		this.destinatario = destinatario;
		this.contenido = contenido;
		this.estado = estado;
		this.motivoId = motivoId;
	}

	public Integer getEnvioId() {
		return envioId;
	}

	public void setEnvioId(Integer envioId) {
		this.envioId = envioId;
	}

	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public MotivoEstadoType getMotivoId() {
		return motivoId;
	}

	public void setMotivoId(MotivoEstadoType motivoId) {
		this.motivoId = motivoId;
	}

	@Override
	public String toString() {
		return "EnvioSistemaType [envioId=" + envioId + ", fechaEnvio=" + fechaEnvio + ", asunto=" + asunto
				+ ", destinatario=" + destinatario + ", contenido=" + contenido + ", estado=" + estado + ", motivoId="
				+ motivoId + "]";
	}

	@Override
	public EnvioSistemaType toType(EnvioSistema entity) {
		this.setEnvioId(entity.getEnvioId());
		this.setFechaEnvio(entity.getFechaEnvio());
		this.setAsunto(entity.getAsunto());
		this.setDestinatario(entity.getDestinatario());
		this.setContenido(entity.getContenido());
		this.setEstado(entity.getEstado());
		if (entity.getMotivoId() != null) {
			this.setMotivoId(new MotivoEstadoType().toType(entity.getMotivoId()));
		}
	    return this;
	}

	@Override
	public EnvioSistema toEntity(EnvioSistemaType type) {
		EnvioSistema envio = new EnvioSistema();
		envio.setEnvioId(type.getEnvioId());
		envio.setFechaEnvio(type.getFechaEnvio());
		envio.setAsunto(type.getAsunto());
		envio.setDestinatario(type.getDestinatario());
		envio.setContenido(type.getContenido());
		envio.setEstado(type.getEstado());
		if (type.getMotivoId() != null) {
			envio.setMotivoId(new MotivoEstadoType().toEntity(type.getMotivoId()));
		}
		return envio;
	}

	@Override
	public List<EnvioSistemaType> toListType(List<EnvioSistema> entityList) {
		List<EnvioSistemaType> listType = new ArrayList<>();	
		for (EnvioSistema envioSistema : entityList) {
			listType.add(new EnvioSistemaType().toType(envioSistema));
		}
		return listType;
	}
	

}
