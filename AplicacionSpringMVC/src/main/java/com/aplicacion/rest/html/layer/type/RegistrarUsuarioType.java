/**
 * 
 */
package com.aplicacion.rest.html.layer.type;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Jose Eduardo
 *
 */
@XmlRootElement(name="RegistrarUsuarioType")
public class RegistrarUsuarioType implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5531198118260501050L;
	
	protected String nombre;
	protected String apellido;
	protected String sexo;
	protected Date fechaNacimiento;
	protected String email;
	protected String username;
	protected String password;
	
	public RegistrarUsuarioType() {}
	
	public RegistrarUsuarioType(String nombre, String apellido, String sexo, Date fechaNacimiento, String email,
			String username, String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "RegistrarUsuarioType [nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo
				+ ", fechaNacimiento=" + fechaNacimiento + ", email=" + email + ", username=" + username + ", password="
				+ password + "]";
	}


}
