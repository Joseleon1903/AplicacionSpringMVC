package com.aplication.spring.mvc.layer.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.aplication.interfaces.comunes.BuscableType;
import com.aplication.spring.mvc.entity.Contacto;

@XmlRootElement(name="ContactoType")
public class ContactoType implements BuscableType<ContactoType, Contacto>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6296581508442957731L;
	
	private Integer contactoId;
	private DetalleContactoType detalleContactoId;
	private String nombre;
	private String apellido;
	private String sexo;
	private Date fechaNacimineto;
	private String email;
	private String estado;

	public ContactoType() {
		// TODO Auto-generated constructor stub
	}
	
	public ContactoType(Integer contactoId, DetalleContactoType detalleContactoId, String nombre, String apellido,
			String sexo, Date fechaNacimineto, String email) {
		super();
		this.contactoId = contactoId;
		this.detalleContactoId = detalleContactoId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.fechaNacimineto = fechaNacimineto;
		this.email = email;
	}


	public Integer getContactoId() {
		return contactoId;
	}

	public void setContactoId(Integer contactoId) {
		this.contactoId = contactoId;
	}

	public DetalleContactoType getDetalleContactoId() {
		return detalleContactoId;
	}

	public void setDetalleContactoId(DetalleContactoType detalleContactoId) {
		this.detalleContactoId = detalleContactoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getFechaNacimineto() {
		return fechaNacimineto;
	}

	public void setFechaNacimineto(Date fechaNacimineto) {
		this.fechaNacimineto = fechaNacimineto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "ContactoType [contactoId=" + contactoId + ", detalleContactoId=" + detalleContactoId + ", nombre="
				+ nombre + ", apellido=" + apellido + ", sexo=" + sexo + ", fechaNacimineto=" + fechaNacimineto + ", email=" + email + "]";
	}

	@Override
	public ContactoType toType(Contacto entity) {
		this.contactoId = entity.getContactoId();
		this.nombre =entity.getNombre();
		this.apellido = entity.getApellido();
		this.sexo = entity.getSexo();
		this.fechaNacimineto = entity.getFechaNacimiento();
		this.email= entity.getEmail();
		if (this.detalleContactoId != null) {
			this.detalleContactoId= new DetalleContactoType().toType(entity.getDetalleContacto());
		}
		this.estado = entity.getEstado();
		return this;
	}

	@Override
	public Contacto toEntity(ContactoType type) {
		Contacto entity = new Contacto();
		if (type.getContactoId() != null) {
			entity.setContactoId(type.getContactoId());
		}
		entity.setNombre(type.getNombre());
		entity.setApellido(type.getApellido());
		entity.setSexo(type.getSexo());
		entity.setFechaNacimiento(type.getFechaNacimineto());
		entity.setEmail(type.getEmail());
		if (type.getDetalleContactoId() != null) {
			entity.setDetalleContacto(new DetalleContactoType().toEntity(type.getDetalleContactoId()));
		}
		entity.setEstado(type.getEstado());
		return entity;
	}

	@Override
	public List<ContactoType> toListType(List<Contacto> entityList) {
		List<ContactoType> listaType = new ArrayList<>();
		for (Contacto item : entityList) {
			listaType.add(new ContactoType().toType(item));
		}
		return listaType;
	}

}
