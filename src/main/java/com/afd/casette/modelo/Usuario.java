package com.afd.casette.modelo;

import java.time.LocalDate;
import java.util.Objects;


public class Usuario {
	private int idUsuario;
	private String nombreUsuario;
	private String clave;
	private String email;
	private LocalDate fechaNacimiento;
	private boolean deBaja;
	
	public Usuario() {};
	
	public Usuario(int idUsuario, String nombreUsuario, String clave, String email, LocalDate fechaNacimiento, boolean deBaja) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.deBaja = deBaja;
	}
	
	public Usuario(int idUsuario, String nombreUsuario, String clave, String email, LocalDate fechaNacimiento) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.deBaja = false;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public boolean isDeBaja() {
		return deBaja;
	}

	public void setDeBaja(boolean deBaja) {
		this.deBaja = deBaja;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		if (obj != null && obj instanceof Usuario) {
			Usuario otro = (Usuario)obj;
			iguales = Objects.equals(this.idUsuario, otro.idUsuario);
		}
		return iguales;
	}

	@Override
	public String toString() {
		return "****USUARIO: #" + idUsuario + "***\n \t NOMBRE USUARIO: " + nombreUsuario + "\n \t CLAVE: " + clave + "\n \t EMAIL: "
				+ email + "\n \t FECHA NACIMIENTO:" + fechaNacimiento + "\n \t DE BAJA: " + deBaja;
	}
	
	
	
}
