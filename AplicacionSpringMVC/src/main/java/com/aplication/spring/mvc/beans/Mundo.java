package com.aplication.spring.mvc.beans;

import org.springframework.beans.factory.annotation.Value;

public class Mundo {
	
	@Value("Hola Value")
	private String saludo;

	public Mundo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the saludo
	 */
	public String getSaludo() {
		return saludo;
	}

	/**
	 * @param saludo the saludo to set
	 */
	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}

}
