package com.afd.casette.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.afd.casette.modelo.ListaReproduccion;
import com.afd.casette.modelo.Usuario;
import com.afd.casette.modelo.fachada.Fachada;

/**
 * Servlet implementation class VerListasUsuarioServlet
 */
public class VerListasUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Fachada fachada = new Fachada();
		try {
			List<ListaReproduccion> listas = fachada.buscarListasPorUsuario(usuario);
			request.setAttribute("listas", listas);
			request.getRequestDispatcher("verListas.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
