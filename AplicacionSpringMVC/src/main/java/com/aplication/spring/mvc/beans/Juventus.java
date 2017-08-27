package com.aplication.spring.mvc.beans;

import com.aplication.spring.mvc.interfaces.IEquipo;

public class Juventus implements IEquipo {

	public Juventus() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String montrarNombre() {
		return "Juventus FC";
	}

}
