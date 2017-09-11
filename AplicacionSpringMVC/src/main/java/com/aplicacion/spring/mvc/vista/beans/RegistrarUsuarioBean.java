package com.aplicacion.spring.mvc.vista.beans;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class RegistrarUsuarioBean {

	private String nombre;
	private String apellido;
	private String sexo;
	private Date fechaNacimineto;
	private String email;
	private String username;
	private String password;
	private String ConfirmarPassword;
	private String emailAlternativa;
	private String direccion;
	private String telefono;
	private String celular;

	public RegistrarUsuarioBean(){}

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

	public Date getFechaNacimineto() {
		return fechaNacimineto;
	}

	public void setFechaNacimineto(Date fechaNacimineto) {
		this.fechaNacimineto = fechaNacimineto;
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

	public String getConfirmarPassword() {
		return ConfirmarPassword;
	}

	public void setConfirmarPassword(String confirmarPassword) {
		ConfirmarPassword = confirmarPassword;
	}

	public String getEmailAlternativa() {
		return emailAlternativa;
	}

	public void setEmailAlternativa(String emailAlternativa) {
		this.emailAlternativa = emailAlternativa;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public String toString() {
		return "RegistrarUsuarioBean [nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo
				+ ", fechaNacimineto=" + fechaNacimineto + ", email=" + email + ", username=" + username + ", password="
				+ password + ", ConfirmarPassword=" + ConfirmarPassword + ", emailAlternativa=" + emailAlternativa
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", celular=" + celular + "]";
	}


}
