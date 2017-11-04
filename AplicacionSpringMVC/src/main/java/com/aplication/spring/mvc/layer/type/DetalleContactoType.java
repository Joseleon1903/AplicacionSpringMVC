package com.aplication.spring.mvc.layer.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.aplicacion.spring.mvc.interfaces.comunes.BuscableType;
import com.aplication.spring.mvc.entity.DetalleContacto;

public class DetalleContactoType implements BuscableType<DetalleContactoType, DetalleContacto>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1590175824596953691L;
	
	private Integer detalleContactoId;
	private String celular;
	private String telefono;
	private String correoAlterno;
	private String direccion;

	public DetalleContactoType() {
		// TODO Auto-generated constructor stub
	}
	
	public DetalleContactoType(Integer detalleContactoId, String celular, String telefono, String correoAlterno,
			String direccion) {
		super();
		this.detalleContactoId = detalleContactoId;
		this.celular = celular;
		this.telefono = telefono;
		this.correoAlterno = correoAlterno;
		this.direccion = direccion;
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
	

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "DetalleContactoType [detalleContactoId=" + detalleContactoId + ", celular=" + celular + ", telefono="
				+ telefono + ", correoAlterno=" + correoAlterno + ", direccion=" + direccion + "]";
	}

	@Override
	public DetalleContactoType toType(DetalleContacto entity) {
		this.detalleContactoId = entity.getDetalleContactoId();
		this.celular = entity.getCelular();
		this.telefono = entity.getTelefono();
		this.correoAlterno = entity.getEmailAlternativa();
		this.direccion = entity.getDireccion();
		return this;
	}

	@Override
	public DetalleContacto toEntity(DetalleContactoType type) {
		DetalleContacto entity = new DetalleContacto();
		entity.setDetalleContactoId(type.getDetalleContactoId());
		entity.setCelular(type.getCelular());
		entity.setTelefono(type.getTelefono());
		entity.setEmailAlternativa(type.getCorreoAlterno());
		entity.setDireccion(type.getDireccion());
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
