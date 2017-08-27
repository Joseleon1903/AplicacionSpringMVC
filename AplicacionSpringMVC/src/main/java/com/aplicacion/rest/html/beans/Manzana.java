package com.aplicacion.rest.html.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Manzana implements InitializingBean, DisposableBean{
	
	private int codigo;
	private String nombre;
	private String tipo;

	public Manzana() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Manzana [codigo=" + codigo + ", nombre=" + nombre + ", tipo=" + tipo + "]";
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Entrando en el metodo afterPropertiesSet.. ");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Entrando en el metodo PreDestroy.. ");
		
	}

	
}
