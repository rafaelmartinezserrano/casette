package com.afd.casette.controlador;

import java.io.IOException;
import java.sql.SQLException;

import com.afd.casette.modelo.ListaReproduccion;
import com.afd.casette.modelo.Usuario;
import com.afd.casette.modelo.fachada.Fachada;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CargarListaServlet
 */
public class CargarListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int idLista = Integer.parseInt(request.getParameter("idLista"));
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		
		Fachada fachada = new Fachada();
		if(usuario != null) {
			try {
				ListaReproduccion lista = fachada.buscarListaPorId(idLista, usuario);
				request.setAttribute("listaReproduccion", lista);
				request.getRequestDispatcher("editarLista.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
				// request.setAttribute("mensajeErrorConexionLista", "Problemas de conexion");
				// request.getRequestDispatcher("principal.jsp").forward(request, response); // Redireccion a la vista desde donde se dió a editar la lista
				response.sendRedirect("principal.jsp");
			} finally {
			}
		} else {
			response.sendRedirect("index.jsp");
		}
	}
}
