package com.aplication.spring.mvc.layer.type;

import java.io.Serializable;
import java.util.ArrayList;
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
	private Integer edad;
	private String email;

	public ContactoType() {
		// TODO Auto-generated constructor stub
	}
	
	public ContactoType(Integer contactoId, DetalleContactoType detalleContactoId, String nombre, String apellido,
			String sexo, Integer edad, String email) {
		super();
		this.contactoId = contactoId;
		this.detalleContactoId = detalleContactoId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.edad = edad;
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

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
	public String toString() {
		return "ContactoType [contactoId=" + contactoId + ", detalleContactoId=" + detalleContactoId + ", nombre="
				+ nombre + ", apellido=" + apellido + ", sexo=" + sexo + ", edad=" + edad + ", email=" + email + "]";
	}

	@Override
	public ContactoType toType(Contacto entity) {
		this.contactoId = entity.getContactoId();
		this.nombre =entity.getNombre();
		this.apellido = entity.getApellido();
		this.sexo = entity.getSexo();
		this.email= entity.getEmail();
		return this;
	}

	@Override
	public Contacto toEntity(ContactoType type) {
		Contacto entity = new Contacto();
		entity.setContactoId(type.getContactoId());
		entity.setNombre(type.getNombre());
		entity.setApellido(type.getApellido());
		entity.setSexo(type.getSexo());
		entity.setEmail(type.getEmail());
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
