package com.aplication.spring.mvc.beans;

public class Ciudadano {
	
	private int identificador;
	private String nombre;
	private String matricula;

	public Ciudadano() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unused")
	private void init(){
		System.out.println("Entrando en el metodo Init.. ");
		
	}
	
	@SuppressWarnings("unused")
	private void destroy(){
		System.out.println("Entrando en el metodo Destroy.. ");
		
	}
	

	/**
	 * @return the ciudadano
	 */
	public int getIdentificador() {
		return identificador;
	}

	/**
	 * @param ciudadano the ciudadano to set
	 */
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
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
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ciudadano [identificador=" + identificador + ", nombre=" + nombre + ", matricula=" + matricula + "]";
	}

}
