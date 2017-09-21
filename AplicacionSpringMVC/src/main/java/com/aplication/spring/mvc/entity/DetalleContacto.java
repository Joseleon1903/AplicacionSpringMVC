package com.aplication.spring.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="detalle_contacto")
@NamedQueries({
		 @NamedQuery(name="DetalleContacto.BuscarTodos", query="SELECT d FROM DetalleContacto d") ,
		 @NamedQuery(name="DetalleContacto.BuscarPorId", query="SELECT d FROM DetalleContacto d where d.detalleContactoId = :detalleContactoId")
})
public class DetalleContacto {
	
	private Integer detalleContactoId;
	private String direccion;
	private String celular;
	private String telefono;
	private String emailAlternativa;

	public DetalleContacto() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="DETALLE_CONTACTO_ID", nullable= false)
	public Integer getDetalleContactoId() {
		return detalleContactoId;
	}

	public void setDetalleContactoId(Integer detalleContactoId) {
		this.detalleContactoId = detalleContactoId;
	}

    @Column(name="CELULAR", nullable= false)
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

    @Column(name="TELEFONO", nullable= false)
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

    @Column(name="EMAIL_ALTERNATIVA", nullable= false)
	public String getEmailAlternativa() {
		return emailAlternativa;
	}

	public void setEmailAlternativa(String correoAlterno) {
		this.emailAlternativa = correoAlterno;
	}
	
    @Column(name="DIRECCION", nullable= false)
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "DetalleContacto [detalleContactoId=" + detalleContactoId + ", celular=" + celular + ", telefono="
				+ telefono + ", correoAlterno=" + emailAlternativa + "]";
	}
	

}
