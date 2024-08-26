package com.afd.casette.modelo.fachada;

import java.sql.SQLException;
import java.util.List;

import com.afd.casette.modelo.Cancion;
import com.afd.casette.modelo.ListaReproduccion;
import com.afd.casette.modelo.Usuario;
import com.afd.casette.modelo.dao.CancionDAO;
import com.afd.casette.modelo.dao.CancionListaDAO;
import com.afd.casette.modelo.dao.UsuarioDAO;

public class Fachada {

	public Usuario registrarUsuario(Usuario usuario) throws SQLException {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.insertarUsuario(usuario);
	}

	public Usuario iniciarSesion(String nombreUsuario, String clave) throws SQLException {
		UsuarioDAO dao = new UsuarioDAO();

		System.out.println("Fachada -> NombreUsuario: " + nombreUsuario + " clave: " + clave);
		Usuario usuario = dao.buscarUsuarioPorNombre(nombreUsuario);
		System.out.println("Fachada -> Usuario: " + usuario);
		if (usuario != null && usuario.getClave().equals(clave)) {
			return usuario;
		} else {
			return null;
		}
	}

	public void guardarCancion(Cancion cancion) throws SQLException {
		CancionDAO dao = new CancionDAO();
		dao.insertarCancion(cancion);

	}

	public boolean cambiarClave(Usuario usuario, String claveNueva, String claveActual) throws SQLException {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuarioBuscado = dao.buscarUsuarioPorNombre(usuario.getNombreUsuario());
		boolean claveCambiada = false;
		if (usuarioBuscado != null) {
			if (usuarioBuscado.getClave().equals(claveActual)) {
				claveCambiada = dao.modificarClave(usuario, claveNueva);
			}
		}
		return claveCambiada;
	}

	public void agregarCancionLista(int idCancion, int idLista) throws SQLException {
		CancionListaDAO dao = new CancionListaDAO();
		int pos = dao.sumarPocision(idLista);

		if (pos != 0) {
			pos++;
			dao.agregarCancionLista(pos, idCancion, idLista);
		}

	}

	public ListaReproduccion buscarListaPorId(int idLista, Usuario usuario) throws SQLException {
		CancionListaDAO dao = new CancionListaDAO();
		return dao.buscarListaPorId(idLista, usuario);
	}

	public boolean baja(Usuario usuario, String clave) throws SQLException {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario buscarUsuario = dao.buscarUsuarioPorNombre(usuario.getNombreUsuario());
		boolean dadoDeBaja = false;
		if (buscarUsuario != null) {
			if (buscarUsuario.getClave().equals(clave)) {
				dadoDeBaja = dao.modificarBaja(usuario.getIdUsuario());

			}
		}
		return dadoDeBaja;
	}

	public List<Cancion> buscarCancionesPorTitulo(Usuario u, String titulo) throws SQLException {
		CancionDAO dao = new CancionDAO();
		return dao.buscarCancionesPorTitulo(u, titulo);

	}

	public List<Cancion> buscarCancionesPorAutor(String busqueda, Usuario usuario) throws SQLException {
		CancionDAO dao = new CancionDAO();
		return dao.buscarCancionesPorAutor(usuario, busqueda);
	}

	public void crearLista(String lista, Usuario usuario) throws SQLException {
		CancionListaDAO dao = new CancionListaDAO();
		dao.crearlista(lista, usuario.getIdUsuario());
	}

	public boolean editarListaPorId(int idLista, String nombreLista, List<String> listaCanciones) throws SQLException {
		CancionListaDAO dao = new CancionListaDAO();
		return dao.actualizarListaPorId(idLista, nombreLista, listaCanciones);
	}

}
