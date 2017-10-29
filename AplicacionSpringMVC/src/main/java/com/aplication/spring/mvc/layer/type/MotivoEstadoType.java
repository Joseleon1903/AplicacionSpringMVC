package com.aplication.spring.mvc.layer.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.aplicacion.spring.mvc.interfaces.comunes.BuscableType;
import com.aplication.spring.mvc.entity.MotivoEstado;

@XmlRootElement(name="MotivoEstadoType")
public class MotivoEstadoType implements BuscableType<MotivoEstadoType, MotivoEstado>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3196583514269003544L;
	
	private Integer motivoId;
	private String descripcion;
	private String estado;
	
	public MotivoEstadoType(){}
	
	public MotivoEstadoType(Integer motivoId){
		this.motivoId = motivoId;
	}

	public MotivoEstadoType(Integer motivoId, String descripcion, String estado) {
		super();
		this.motivoId = motivoId;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public Integer getMotivoId() {
		return motivoId;
	}

	public void setMotivoId(Integer motivoId) {
		this.motivoId = motivoId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "MotivoEstadoType [motivoId=" + motivoId + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}

	@Override
	public MotivoEstadoType toType(MotivoEstado entity) {
		this.motivoId = entity.getMotivoId();
		this.descripcion = entity.getDescripcion();
		this.estado = entity.getEstado();
		return this;
	}

	@Override
	public MotivoEstado toEntity(MotivoEstadoType type) {
		MotivoEstado motivo = new MotivoEstado();
		motivo.setMotivoId(type.getMotivoId());
		motivo.setDescripcion(type.getDescripcion());
		motivo.setEstado(type.getEstado());
		return motivo;
	}

	@Override
	public List<MotivoEstadoType> toListType(List<MotivoEstado> entityList) {
		List<MotivoEstadoType> listaMotivo = new ArrayList<MotivoEstadoType>();
		for (MotivoEstado motivoEstado : entityList) {
			listaMotivo.add(new MotivoEstadoType().toType(motivoEstado));
		}
		return listaMotivo;
	}
	
	

}
