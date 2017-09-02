package com.aplication.spring.mvc.layer.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.aplication.interfaces.comunes.BuscableType;
import com.aplication.spring.mvc.entity.Usuario;

@XmlRootElement(name="UsuarioType")
public class UsuarioType implements BuscableType<UsuarioType, Usuario>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7899832547666131951L;
	
	private Integer usuarioId;
	private ContactoType contacto;;
	private String codigoUsuario;
	private String password;
	private Date fechaCreacion;
	private Date fechaUltimoAcceso;
	
	public UsuarioType() {
		// TODO Auto-generated constructor stub
	}
	

	public UsuarioType(Integer usuario_id, ContactoType contacto, String nombre, String password, Date fechaCreacion,
			Date fechaUltimoAcceso) {
		super();
		this.usuarioId = usuario_id;
		this.contacto = contacto;
		this.codigoUsuario = nombre;
		this.password = password;
		this.fechaCreacion = fechaCreacion;
		this.fechaUltimoAcceso = fechaUltimoAcceso;
	}
	
	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuario) {
		this.usuarioId = usuario;
	}

	public ContactoType getContacto() {
		return contacto;
	}

	public void setContacto(ContactoType contacto) {
		this.contacto = contacto;
	}

	public String getNombre() {
		return codigoUsuario;
	}

	public void setNombre(String nombre) {
		this.codigoUsuario = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaUltimoAcceso() {
		return fechaUltimoAcceso;
	}

	public void setFechaUltimoAcceso(Date fechaUltimoAcceso) {
		this.fechaUltimoAcceso = fechaUltimoAcceso;
	}



	@Override
	public String toString() {
		return "UsuarioType [usuario_id=" + usuarioId + ", contacto=" + contacto.getContactoId() + ", nombre=" + codigoUsuario + ", password="
				+ password + ", fechaCreacion=" + fechaCreacion + ", fechaUltimoAcceso=" + fechaUltimoAcceso+"]";
	}

	@Override
	public UsuarioType toType(Usuario entity) {
		  this.usuarioId = entity.getUsuarioId();
		  this.contacto = new ContactoType().toType(entity.getContacto_id());
		  this.codigoUsuario = entity.getCodigoUsuario();
		  this.password = entity.getPassword();
		  this.fechaCreacion = entity.getFechaCreacion();
		  this.fechaUltimoAcceso = entity.getFechaUltimoAcceso();
		  return this;
	}

	@Override
	public Usuario toEntity(UsuarioType type) {
		Usuario entity = new Usuario();
		entity.setUsuarioId(type.getUsuarioId());
		entity.setContacto_id(new ContactoType().toEntity(type.getContacto()));
		entity.setCodigoUsuario(type.getNombre());
		entity.setPassword(type.getPassword());
		entity.setFechaCreacion(type.getFechaCreacion());
		entity.setFechaUltimoAcceso(type.getFechaUltimoAcceso());
		return entity;
	}

	@Override
	public List<UsuarioType> toListType(List<Usuario> entityList) {
		List<UsuarioType> listaType = new ArrayList<>();
		for (Usuario item : entityList) {
			listaType.add(new UsuarioType().toType(item));
		}
		return listaType;
	}

}
