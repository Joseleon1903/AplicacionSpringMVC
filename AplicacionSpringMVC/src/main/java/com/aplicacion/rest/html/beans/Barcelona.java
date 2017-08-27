package com.aplicacion.rest.html.beans;

import com.aplicacion.rest.html.beans.interfaces.IEquipo;

public class Barcelona implements IEquipo{

	@Override
	public String montrarNombre() {
		return "Barcelona FC";
	}

}
