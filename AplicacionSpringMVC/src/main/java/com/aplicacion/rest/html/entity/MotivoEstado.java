package com.aplicacion.rest.html.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="motivo_estado")
@NamedQueries({
		 @NamedQuery(name="MotivoEstado.BuscarTodos", query="SELECT m FROM MotivoEstado m") ,
		 @NamedQuery(name="MotivoEstado.BuscarPorId", query="SELECT m FROM MotivoEstado m where m.motivoId = :motivoId")
})
public class MotivoEstado {
	
	private Integer motivoId;
	private String descripcion;
	private String estado;
	
	public MotivoEstado(){}
	
	public MotivoEstado(Integer motivoId, String descripcion, String estado) {
		super();
		this.motivoId = motivoId;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	
	public MotivoEstado(Integer motivoId) {
		super();
		this.motivoId = motivoId;
	}

	@Id
    @Column(name="MOTIVO_ID", nullable= false)
	public Integer getMotivoId() {
		return motivoId;
	}

	public void setMotivoId(Integer motivoId) {
		this.motivoId = motivoId;
	}

    @Column(name="DESCRIPCION", nullable= false)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
		return "MotivoEstado [motivoId=" + motivoId + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
	/**
	 * 
	 * Descripcion: Columnas del entity 
	 *
	 */
	public static interface Columnas{
		
		String MOTIVO_ID     = "MOTIVO_ID";
		String DESCRIPCION   = "DESCRIPCION";
		String ESTADO        = "ESTADO";
	}
	
	public static interface Query{
		
		String BUSCAR_MOTIVO_POR_ID     = "MotivoEstado.BuscarPorId";
		String BUSCAR_TODOS_LOS_MOTIVOS = "MotivoEstado.BuscarTodos";
	}
	


}
