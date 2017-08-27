package com.aplicacion.rest.html.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("componente")
public class Celular {
	
	@Value("15")
	private int id;
	@Value("809")
	private int prefijo;
	@Value("526-59-63")
	private String numero;


	public Celular() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPrefijo() {
		return prefijo;
	}


	public void setPrefijo(int prefijo) {
		this.prefijo = prefijo;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	@Override
	public String toString() {
		return "Celular [id=" + id + ", prefijo=" + prefijo + ", numero=" + numero + "]";
	}


}
