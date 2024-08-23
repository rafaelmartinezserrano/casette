package com.afd.casette.controlador;

import java.io.IOException;
import java.sql.SQLException;

import com.afd.casette.modelo.fachada.Fachada;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AgregarCancionListaServlet
 */
public class AgregarCancionListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strIdCancion = request.getParameter("idCancion");
		int idCancion = Integer.parseInt(strIdCancion);
		String strIdLista = request.getParameter("idLista");
		int idLista = Integer.parseInt(strIdLista);
		Fachada fachada = new Fachada();
		
		try {
			fachada.agregarCancionLista(idCancion, idLista);
			request.getRequestDispatcher("principal.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "Error al Incertar cancion en la lista");
		}
		
	}

}
