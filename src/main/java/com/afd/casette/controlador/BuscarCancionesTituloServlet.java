package com.afd.casette.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.afd.casette.modelo.Cancion;
import com.afd.casette.modelo.Usuario;
import com.afd.casette.modelo.fachada.Fachada;

/**
 * Servlet implementation class BuscarCancionesTituloServlet
 */
public class BuscarCancionesTituloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cancion = request.getParameter("tituCancion");
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		Fachada fachada = new Fachada();
		try {
			List<Cancion> canciones = fachada.buscarCancionesPorTitulo(usuario, cancion);
			request.setAttribute("listaCanciones", canciones);
			request.getRequestDispatcher("buscarCancionesTitulo.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("error", "Ha ocurrido un error");
		}
		
		
	}

}
