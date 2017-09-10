package com.aplication.spring.mvc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="usuario")
@NamedQueries({
		 @NamedQuery(name="Usuario.BuscarTodos", query="SELECT u FROM Usuario u") ,
		 @NamedQuery(name="Usuario.BuscarPorId", query="SELECT u FROM Usuario u WHERE u.usuarioId = :usuarioId"),
		 @NamedQuery(name= "Usuario.BuscarPorCodigoUsuario", query= "SELECT u FROM Usuario u WHERE u.codigoUsuario = :codigoUsuario"),
		 @NamedQuery(name= "Usuario.ActualizarfechaUltimoAcceso", query= "UPDATE Usuario u SET u.fechaUltimoAcceso = u.fechaUltimoAcceso")
})
public class Usuario {
	
	private Integer usuarioId;
	private String codigoUsuario;
	private String password;
	private Date fechaCreacion;
	private Date fechaUltimoAcceso;
	private Contacto contacto_id;;
	
	public Usuario() {}
		
	public Usuario(Integer usuarioId, String codigoUsuario, String password, Date fechaCreacion, Date fechaUltimoAcceso,
			Contacto contacto_id) {
		super();
		this.usuarioId = usuarioId;
		this.codigoUsuario = codigoUsuario;
		this.password = password;
		this.fechaCreacion = fechaCreacion;
		this.fechaUltimoAcceso = fechaUltimoAcceso;
		this.contacto_id = contacto_id;
	}

	@Id
    @Column(name="USUARIO_ID", nullable= false)
	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuario_id) {
		this.usuarioId = usuario_id;
	}

	@ManyToOne
	@JoinColumn(name="CONTACTO_ID")
	public Contacto getContacto_id() {
		return contacto_id;
	}



	public void setContacto_id(Contacto contacto_id) {
		this.contacto_id = contacto_id;
	}


    @Column(name="CODIGO_USUARIO", nullable= false)
	public String getCodigoUsuario() {
		return codigoUsuario;
	}



	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}


    @Column(name="PASSWORD", nullable= false)
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="FECHA_CREACION", nullable= false)
	public Date getFechaCreacion() {
		return fechaCreacion;
	}



	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="FECHA_ULTIMO_ACCESO", nullable= true)
	public Date getFechaUltimoAcceso() {
		return fechaUltimoAcceso;
	}



	public void setFechaUltimoAcceso(Date fechaUltimoAcceso) {
		this.fechaUltimoAcceso = fechaUltimoAcceso;
	}

	@Override
	public String toString() {
		return "IUsuario [usuario_id=" + usuarioId + ", contacto_id=" + contacto_id + ", codigoUsuario=" + codigoUsuario
				+ ", password=" + password + ", fechaCreacion=" + fechaCreacion + ", fechaUltimoAcceso="
				+ fechaUltimoAcceso + "]";
	}

	/**
	 * Query de la entidad
	 * 
	 * @author Jose Eduardo
	 *
	 */
	public static interface NameQuery{
		String BUSCA_POR_ID = "Usuario.BuscarPorId";
		String BUSCAR_TODOS = "Usuario.BuscarTodos";
		String BUSCAR_POR_CODIGO_USUARIO = "Usuario.BuscarPorCodigoUsuario";
		String ACTUALIZAR_FECHA_ULTIMO_ACCESO = "Usuario.ActualizarfechaUltimoAcceso";
	}
	
	/**
	 * 
	 * Descripcion: Columnas del entity 
	 *
	 */
    public static interface Columnas{
		String USUARIO_ID            = "USUARIO_ID";
		String CODIGO_USUARIO        = "CODIGO_USUARIO";
		String PASSWORD              = "PASSWORD";
		String FECHA_CREACION        = "FECHA_CREACION";
		String FECHA_ULTIMO_ACCESO   = "FECHA_ULTIMO_ACCESO";
		String CONTACTO_ID           = "CONTACTO_ID";
	}
	
}
