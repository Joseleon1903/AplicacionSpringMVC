package com.aplicacion.spring.mvc.vista.beans;

public class BusquedaOferta {
	
	private String nombre;
	private int precioMaximo;
	private short tipoOferta;

	public BusquedaOferta() {
		// TODO Auto-generated constructor stub
	}
	
	public BusquedaOferta(String nombre,int precioMaximo, short tipoOferta) {
		super();
		this.precioMaximo = precioMaximo;
		this.tipoOferta = tipoOferta;
		this.nombre= nombre;
	}

	public int getPrecioMaximo() {
		return precioMaximo;
	}

	public void setPrecioMaximo(int precioMaximo) {
		this.precioMaximo = precioMaximo;
	}

	public short getTipoOferta() {
		return tipoOferta;
	}

	public void setTipoOferta(short tipoOferta) {
		this.tipoOferta = tipoOferta;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "BusquedaOferta [precioMaximo=" + precioMaximo + ", tipoOferta=" + tipoOferta + "]";
	}

}
