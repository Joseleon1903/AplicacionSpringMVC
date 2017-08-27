package com.aplicacion.rest.html.layer.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.aplicacion.rest.html.entity.DetalleContacto;
import com.aplicacion.rest.html.interfaces.comunes.BuscableType;

@XmlRootElement(name="DetalleContactoType")
public class DetalleContactoType implements BuscableType<DetalleContactoType, DetalleContacto>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1590175824596953691L;
	
	private Integer detalleContactoId;
	private String celular;
	private String telefono;
	private String correoAlterno;

	public DetalleContactoType() {
		// TODO Auto-generated constructor stub
	}
	
	public DetalleContactoType(Integer detalleContactoId, String celular, String telefono, String correoAlterno) {
		super();
		this.detalleContactoId = detalleContactoId;
		this.celular = celular;
		this.telefono = telefono;
		this.correoAlterno = correoAlterno;
	}

	public Integer getDetalleContactoId() {
		return detalleContactoId;
	}

	public void setDetalleContactoId(Integer detalleContactoId) {
		this.detalleContactoId = detalleContactoId;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoAlterno() {
		return correoAlterno;
	}

	public void setCorreoAlterno(String correoAlterno) {
		this.correoAlterno = correoAlterno;
	}

	@Override
	public String toString() {
		return "DetalleContactoType [detalleContactoId=" + detalleContactoId + ", celular=" + celular + ", telefono="
				+ telefono + ", correoAlterno=" + correoAlterno + "]";
	}

	@Override
	public DetalleContactoType toType(DetalleContacto entity) {
		this.detalleContactoId = entity.getDetalleContactoId();
		this.celular = entity.getCelular();
		this.telefono = entity.getTelefono();
		this.correoAlterno = entity.getEmailAlternativa();
		return this;
	}

	@Override
	public DetalleContacto toEntity(DetalleContactoType type) {
		DetalleContacto entity = new DetalleContacto();
		entity.setDetalleContactoId(type.getDetalleContactoId());
		entity.setCelular(type.getCelular());
		entity.setTelefono(type.getTelefono());
		return entity;
	}

	@Override
	public List<DetalleContactoType> toListType(List<DetalleContacto> entityList) {
		List<DetalleContactoType> listaType = new ArrayList<>();
		for (DetalleContacto detalle : entityList) {
			listaType.add(new DetalleContactoType().toType(detalle));
		}
		return listaType;
	}

}
