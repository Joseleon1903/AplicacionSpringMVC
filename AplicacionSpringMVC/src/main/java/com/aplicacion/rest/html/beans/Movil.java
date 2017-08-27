package com.aplicacion.rest.html.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Movil {
	
	private int id;
	private int prefijo;
	private String numero;

	public Movil() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	private void init(){
		System.out.println("Entrando en el metodo PostConstruct.. ");
		
	}
	
	@PreDestroy
	private void destroy(){
		System.out.println("Entrando en el metodo PreDestroy.. ");
		
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
	 * @return the prefijo
	 */
	public int getPrefijo() {
		return prefijo;
	}

	/**
	 * @param prefijo the prefijo to set
	 */
	public void setPrefijo(int prefijo) {
		this.prefijo = prefijo;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Movil [id=" + id + ", prefijo=" + prefijo + ", numero=" + numero + "]";
	}
	
}
