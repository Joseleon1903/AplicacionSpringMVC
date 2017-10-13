package com.aplication.spring.mvc.layer.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.aplicacion.spring.mvc.interfaces.comunes.BuscableType;
import com.aplication.spring.mvc.entity.Usuario;
import com.aplication.spring.mvc.util.ValidationUtil;

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

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
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
		return "UsuarioType [usuario_id=" + usuarioId + ", contacto=" + contacto + ", codigoUsuario=" + codigoUsuario + ", password="
				+ password + ", fechaCreacion=" + fechaCreacion + ", fechaUltimoAcceso=" + fechaUltimoAcceso+"]";
	}

	@Override
	public UsuarioType toType(Usuario entity) {
		this.usuarioId = entity.getUsuarioId();
		this.contacto = new ContactoType().toType(entity.getContactoId());
		this.codigoUsuario = entity.getCodigoUsuario();
		this.password = entity.getPassword();
		this.fechaCreacion = entity.getFechaCreacion();
		this.fechaUltimoAcceso = entity.getFechaUltimoAcceso();
		if (ValidationUtil.isObjectNotNull(this.getContacto().getDetalleContactoId())) {
			this.getContacto().setDetalleContactoId(
					new DetalleContactoType().toType(entity.getContactoId().getDetalleContacto()));
		}
		return this;
	}

	@Override
	public Usuario toEntity(UsuarioType type) {
		Usuario entity = new Usuario();
		if (type.getUsuarioId() != null) {
			entity.setUsuarioId(type.getUsuarioId());
		}
		entity.setContactoId(new ContactoType().toEntity(type.getContacto()));
		entity.setCodigoUsuario(type.getCodigoUsuario());
		entity.setPassword(type.getPassword());
		entity.setFechaCreacion(type.getFechaCreacion());
		entity.setFechaUltimoAcceso(type.getFechaUltimoAcceso());
		if (ValidationUtil.isObjectNotNull(type.getContacto().getDetalleContactoId())) {
			entity.getContactoId().setDetalleContacto(new DetalleContactoType().toEntity(type.getContacto().getDetalleContactoId()));
		}
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
