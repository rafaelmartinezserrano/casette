package com.afd.casette.controlador;

import java.io.IOException;
import java.sql.SQLException;

import com.afd.casette.modelo.Usuario;
import com.afd.casette.modelo.fachada.Fachada;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class IniciarSesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombreUsuario = request.getParameter("userName");
		String clave = request.getParameter("password");
		String recordarUsuario = request.getParameter("recordarUsuario");
		System.out.println("IniciarSesion -> recordarUsuario: " + recordarUsuario);
		Fachada fachada = new Fachada();
		System.out.println("IniciarSesion -> NombreUsuario: " + nombreUsuario + " clave: " + clave);
		try {
			Usuario usuario = fachada.iniciarSesion(nombreUsuario, clave);

			if (usuario != null) {
				if (recordarUsuario != null) {
					Cookie galleta = new Cookie("recordarUsuario", Integer.toString(usuario.getIdUsuario()));
					galleta.setMaxAge(10 * 24 * 60 * 60);
					response.addCookie(galleta);

				}
				request.getSession().setAttribute("usuario", usuario);
				request.getRequestDispatcher("principal.jsp").forward(request, response);
			} else {
				request.setAttribute("errorLogin", "El nombre de usuario o la clave son incorrectos");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
