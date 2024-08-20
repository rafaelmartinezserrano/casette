package com.afd.casette.modelo.fachada;

public class Fachada {

	public Usuario registrarUsuario(Usuario usuario) {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.insertarUsuario(usuario);
	}
	
	public Usuario iniciarSesion(String nombreUsuario, String clave) {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.buscarUsuarioPorNombre(nombre);
		if (usuario != null && usuario.getClave().equals(clave)) {
			return usuario;
		} else {
			return null;
		}
	}
	
}
