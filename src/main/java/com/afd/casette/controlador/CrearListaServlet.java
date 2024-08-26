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
 * Servlet implementation class CrearlistaServlet
 */
public class CrearListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombreLista = request.getParameter("nombreLista");
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Fachada fachada = new Fachada();
		try {
			fachada.crearLista(nombreLista, usuario);
			request.getRequestDispatcher("principal.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "Error al crear la lista de reproducción");
			request.getRequestDispatcher("crearLista.jsp").forward(request, response);
		}

	}
}