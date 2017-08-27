package com.aplication.spring.mvc.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.aplication.spring.mvc.interfaces.IEquipo;

public class Player {
	
	private int numero;
	private String nombre;
	
	@Autowired
	@Qualifier("barcelonaQualifier")
	private IEquipo equipo;

	public Player() {
		// TODO Auto-generated constructor stub
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
	public void setEquipo(IEquipo equipo) {
		this.equipo = equipo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [numero=" + numero + ", nombre=" + nombre + ", equipo=" + equipo + "]";
	}
	

}
