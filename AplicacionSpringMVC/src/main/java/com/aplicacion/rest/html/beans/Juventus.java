package com.aplicacion.rest.html.beans;

import com.aplicacion.rest.html.beans.interfaces.IEquipo;

public class Juventus implements IEquipo {

	public Juventus() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String montrarNombre() {
		return "Juventus FC";
	}

}
