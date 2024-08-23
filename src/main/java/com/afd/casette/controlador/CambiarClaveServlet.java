package com.afd.casette.controlador;

import java.io.IOException;
import java.sql.SQLException;

import com.afd.casette.modelo.Usuario;
import com.afd.casette.modelo.fachada.Fachada;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CambiarClaveServlet
 */
public class CambiarClaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String claveActual = request.getParameter("claveActual");
		String claveNueva = request.getParameter("claveNueva1");
		
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Fachada fachada = new Fachada();
		
		if (usuario != null) {
			String mensaje = "";
			String atributo = "";
			try {
				boolean claveCambiada = fachada.cambiarClave(usuario, claveNueva, claveActual);
				if (claveCambiada) {
					atributo = "mensajeClaveCambiada";
					mensaje = "Contraseña cambiada";
				} else {
					atributo = "mensajeClaveNoValida";
					mensaje = "La contraseña no es válida";
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				atributo = "mensajeErrorConexion";
				mensaje = "Problemas de conexión. Vuelva a intentarlo en unos minutos o contacte con soporte";
			} finally {
				request.setAttribute(atributo, mensaje);
				request.getRequestDispatcher("cambiarClave.jsp").forward(request, response);	// Cambiar el .jsp si se incluye en otro JSP
			}
		} else {
			response.sendRedirect("index.jsp");
		}
	}

}
