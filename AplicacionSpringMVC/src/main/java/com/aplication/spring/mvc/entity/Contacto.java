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
@Table(name="contacto")
@NamedQueries({
		 @NamedQuery(name="Contacto.BuscarTodos", query="SELECT c FROM Contacto c") ,
		 @NamedQuery(name="Contacto.BuscarPorId", query="SELECT c FROM Contacto c where c.contactoId = :contactoId")
})
public class Contacto {
	
	private Integer contactoId;
	private String nombre;
	private String apellido;
	private String sexo;
	private Date fechaNacimineto;
	private String email;
	private DetalleContacto detalleContactoId;
	private String estado;
	
	public Contacto() {
		//contructor por defecto..
	}
	
	public Contacto(Integer contactoId) {
		this.contactoId =contactoId;
	}
	
	public Contacto(Integer contactoId, String nombre, String apellido, String sexo, Date fechaNacimineto, String email,
			DetalleContacto detalleContacto, String estado) {
		super();
		this.contactoId = contactoId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.fechaNacimineto = fechaNacimineto;
		this.email = email;
		this.detalleContactoId = detalleContacto;
		this.estado = estado;
	}

	@Id
    @Column(name="CONTACTO_ID", nullable= false)
	public Integer getContactoId() {
		return contactoId;
	}

	public void setContactoId(Integer contactoId) {
		this.contactoId = contactoId;
	}

    @Column(name="NOMBRE", nullable= false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    @Column(name="APELLIDO", nullable= false)
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

    @Column(name="SEXO", nullable= false)
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="FECHA_NACIMIENTO", nullable= false)
	public Date getFechaNacimineto() {
		return fechaNacimineto;
	}

	public void setFechaNacimineto(Date fechaNacimineto) {
		this.fechaNacimineto = fechaNacimineto;
	}

    @Column(name="EMAIL", nullable= false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    @ManyToOne
	@JoinColumn(name="DETALLE_CONTACTO_ID")
	public DetalleContacto getDetalleContacto() {
		return detalleContactoId;
	}

	public void setDetalleContacto(DetalleContacto detalleContacto) {
		this.detalleContactoId = detalleContacto;
	}

    @Column(name="ESTADO", nullable= false)
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Contacto [contactoId=" + contactoId + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo
				+ ", email=" + email + ", detalleContacto=" + detalleContactoId + ", estado=" + estado + "]";
	}
	
	public static interface Columnas{
		
		String CONTACTO_ID           = "CONTACTO_ID";
		String NOMBRE                = "NOMBRE";
		String APELLIDO              = "APELLIDO";
		String SEXO                  = "SEXO";
		String FECHA_NACIMIENTO      = "FECHA_NACIMIENTO";
		String EMAIL                 = "EMAIL";
		String DETALLE_CONTACTO_ID   = "DETALLE_CONTACTO_ID";
		String ESTADO                = "ESTADO";
	}
	
}
