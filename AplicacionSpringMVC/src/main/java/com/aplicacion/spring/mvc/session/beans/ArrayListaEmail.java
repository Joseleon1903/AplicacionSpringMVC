package com.aplicacion.spring.mvc.session.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aplicacion.spring.mvc.vista.beans.ListaEmailEnviadasBean;

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
	
	@PostConstruct
	private void init(){
		listaBean = null;
	}
	
	@PreDestroy
	public void destroy() throws Exception {
		listaBean = null;
	}

}
