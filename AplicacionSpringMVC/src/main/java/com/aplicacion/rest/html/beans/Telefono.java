package com.aplicacion.rest.html.beans;

public class Telefono {
	
	private int id;
	private int prefijo;
	private String numero;


	public Telefono() {
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
		return "Telefono [id=" + id + ", prefijo=" + prefijo + ", numero=" + numero + "]";
	}
	
}
