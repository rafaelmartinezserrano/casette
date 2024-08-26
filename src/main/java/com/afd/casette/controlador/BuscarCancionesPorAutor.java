package com.afd.casette.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.afd.casette.modelo.Cancion;
import com.afd.casette.modelo.Usuario;
import com.afd.casette.modelo.fachada.Fachada;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BuscarCancionesPorAutor
 */
public class BuscarCancionesPorAutor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("usuario") != null) {
			String busqueda = request.getParameter("buscarPorAutor");
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			// Paso los datos a la fachada para que esta haga el trabajo y me devuelva un
			// resultado

			Fachada fachada = new Fachada();
			try {
				System.out.println(busqueda);
				List<Cancion> listaCanciones = fachada.buscarCancionesPorAutor(busqueda, usuario);
				System.out.println(listaCanciones);
				// Guardo el resultado en la request (solo lo necesito para esta petición)
				request.setAttribute("listaCanciones", listaCanciones);
				// Salto a la JSP
				request.getRequestDispatcher("buscarCancionesPorAutor.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("error", "Problemas de conexión. Contacte con soporte.");
				request.getRequestDispatcher("principal.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect("index.jsp");
		}

	}

}
