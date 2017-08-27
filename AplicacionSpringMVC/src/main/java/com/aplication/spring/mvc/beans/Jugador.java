package com.aplication.spring.mvc.beans;

import org.springframework.beans.factory.annotation.Required;

import com.aplication.spring.mvc.interfaces.IEquipo;

public class Jugador {
	
	private int numero;
	private String nombre;
	private IEquipo equipo;

	public Jugador() {
		// TODO Auto-generated constructor stub
	}	

	public Jugador(int numero, String nombre, IEquipo equipo) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.equipo = equipo;
	}



	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
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
	 * @return the equipo
	 */
	public IEquipo getEquipo() {
		return equipo;
	}

	/**
	 * @param equipo the equipo to set
	 */
	@Required
	public void setEquipo(IEquipo equipo) {
		this.equipo = equipo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Jugador [numero=" + numero + ", nombre=" + nombre + ", equipo=" + equipo + "]";
	}

}
