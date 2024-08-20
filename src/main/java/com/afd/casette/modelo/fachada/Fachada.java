package com.afd.casette.modelo.fachada;

import java.sql.SQLException;

import com.afd.casette.modelo.Usuario;
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
	
}
