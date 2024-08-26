package com.afd.casette.modelo;

import java.time.LocalTime;
import java.util.Objects;


public class Cancion {
	private int idCancion;
	private Usuario usuario;
	private String titulo;
	private String autor;
	private String genero;
	private LocalTime duracion;
	private String portada;
	private int anho;
	private String archivo;
	private boolean privada;
	private TipoArchivo tipo;
	private int reproducciones;
	
	public Cancion() {}

	public Cancion(int idCancion, Usuario usuario, String titulo, String autor, String genero, LocalTime duracion,
			String portada, int anho, String archivo, boolean privada, TipoArchivo tipo, int reproducciones) {
		this.idCancion = idCancion;
		this.usuario = usuario;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.duracion = duracion;
		this.portada = portada;
		this.anho = anho;
		this.archivo = archivo;
		this.privada = privada;
		this.tipo = tipo;
		this.reproducciones = reproducciones;
	};
	
	public Cancion(int idCancion, Usuario usuario, String titulo, String autor, String genero, LocalTime duracion,
			String portada, int anho, String archivo, boolean privada, TipoArchivo tipo) {
		this.idCancion = idCancion;
		this.usuario = usuario;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.duracion = duracion;
		this.portada = portada;
		this.anho = anho;
		this.archivo = archivo;
		this.privada = privada;
		this.tipo = tipo;
	}

	public int getIdCancion() {
		return idCancion;
	}

	public void setIdCancion(int idCancion) {
		this.idCancion = idCancion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalTime getDuracion() {
		return duracion;
	}

	public void setDuracion(LocalTime duracion) {
		this.duracion = duracion;
	}

	public String getPortada() {
		return portada;
	}

	public void setPortada(String portada) {
		this.portada = portada;
	}

	public int getAnho() {
		return anho;
	}

	public void setAnho(int anho) {
		this.anho = anho;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public boolean isPrivada() {
		return privada;
	}

	public void setPrivada(boolean privada) {
		this.privada = privada;
	}

	public TipoArchivo getTipo() {
		return tipo;
	}

	public void setTipo(TipoArchivo tipo) {
		this.tipo = tipo;
	}

	public int getReproducciones() {
		return reproducciones;
	}

	public void setReproducciones(int reproducciones) {
		this.reproducciones = reproducciones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCancion);
	}

	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		if (obj != null && obj instanceof Cancion) {
			Cancion otro = (Cancion)obj;
			iguales = Objects.equals(this.idCancion, otro.idCancion);
		}
		return iguales;
	}

	@Override
	public String toString() {
		return "***CANCION ID#" + idCancion + "*** \n \t DEL USUARIO: (" + usuario + ") \n \t TITULO: " + titulo + "\n \t AUTOR: " + autor + "\n \t DURACION: " + duracion
				+ "\n \t GENERO: " + genero  + "\n \t ANHO: " + anho + "\n \t RUTA PORTADA: " + portada
				+ "\n \t RUTA ARCHIVO: " + archivo + "\n \t PRIVADA: " + privada + "\n \t TIPO: " + tipo + "\n \t REPRODUCCIONES: "
				+ reproducciones;
	};
	
	
	
}
