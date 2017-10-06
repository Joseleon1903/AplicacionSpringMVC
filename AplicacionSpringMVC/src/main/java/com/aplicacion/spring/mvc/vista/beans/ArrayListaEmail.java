package com.aplicacion.spring.mvc.vista.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session")
public class ArrayListaEmail {

	private List<ListaEmailEnviadasBean> listaBean;

	public ArrayListaEmail() {
		// TODO Auto-generated constructor stub
	}

	public List<ListaEmailEnviadasBean> getListaBean() {
		return listaBean;
	}

	public void setListaBean(List<ListaEmailEnviadasBean> listaBean) {
		this.listaBean = listaBean;
	}	

	@Override
	public String toString() {
		return "ArrayListaEmail [listaBean=" + listaBean + "]";
	}

}
