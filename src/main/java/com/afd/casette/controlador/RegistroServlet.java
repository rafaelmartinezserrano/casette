package com.afd.casette.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.crypto.spec.DHPublicKeySpec;

import com.afd.casette.modelo.Usuario;
import com.afd.casette.modelo.fachada.Fachada;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class RegistroServlet
 */
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombreUsuario = request.getParameter("nombreUsuario");
		String clave = request.getParameter("clave");
		String email = request.getParameter("email");
		String strfechaNacimiento = request.getParameter("fechaNacimiento");
		LocalDate fechaNacimiento = LocalDate.parse(strfechaNacimiento);

		Usuario usuario = new Usuario(0, nombreUsuario, clave, email, fechaNacimiento);
		System.out.println(usuario);

		Fachada fachada = new Fachada();
		try {
			usuario = fachada.registrarUsuario(usuario);
			request.getSession().setAttribute("usuario", usuario);
			request.getRequestDispatcher("principal.jsp").forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
			request.setAttribute("error", "Error al registrar");
			request.getRequestDispatcher("Registro.jsp");
			
		}
	}
	
}
