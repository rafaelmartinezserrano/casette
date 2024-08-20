package com.afd.casette.modelo;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ListaReproduccion {
	private int idLista;
	private String nombre;
	private List<Cancion> canciones;
	
	public ListaReproduccion() {};
	
	public ListaReproduccion(int idLista, String nombre, List<Cancion> canciones) {
		super();
		this.idLista = idLista;
		this.nombre = nombre;
		this.canciones = canciones;
	}
	
	public ListaReproduccion(int idLista, String nombre) {
		super();
		this.idLista = idLista;
		this.nombre = nombre;
		this.canciones = new LinkedList<Cancion>();
	}

	public int getIdLista() {
		return idLista;
	}

	public void setIdLista(int idLista) {
		this.idLista = idLista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idLista);
	}

	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		if (obj != null && obj instanceof ListaReproduccion) {
			ListaReproduccion otro = (ListaReproduccion)obj;
			iguales = Objects.equals(this.idLista, otro.idLista);
		}
		return iguales;
	}

	@Override
	public String toString() {
		return "LISTA REPRODUCCION #" + idLista + "\n \t NOMBRE: " + nombre + "\n \t CANCIONES: [" + canciones + "]";
	}
	
	public void agregarCancion (Cancion cancion) {
		this.canciones.add(cancion);
	}
	
	public void quitarCancion (Cancion cancion) {
		this.canciones.remove(cancion);
	}
	
	
}
