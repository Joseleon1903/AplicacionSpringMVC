package com.aplication.spring.mvc.beans;

import java.util.List;

public class Pasajero {
	
	private int id;
	private String nombre;
	private Pais pais;
	private List<Ciudad> ciudades;

	public Pasajero() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the pais
	 */
	public Pais getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
	}

	/**
	 * @return the ciudades
	 */
	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	/**
	 * @param ciudades the ciudades to set
	 */
	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pasajero [id=" + id + ", nombre=" + nombre + ", pais=" + pais + ", ciudades=" + ciudades + "]";
	}
	
}
