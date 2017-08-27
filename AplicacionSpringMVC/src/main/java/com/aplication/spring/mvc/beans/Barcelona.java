package com.aplication.spring.mvc.beans;

import com.aplication.spring.mvc.interfaces.IEquipo;

public class Barcelona implements IEquipo{

	@Override
	public String montrarNombre() {
		return "Barcelona FC";
	}

}
