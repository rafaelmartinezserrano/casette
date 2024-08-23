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
 * Servlet implementation class DarDeBajaServlet
 */
public class DarDeBajaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clave = request.getParameter("claveActual");
		
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		
		Fachada fachada = new Fachada();
		
		try {
		boolean deBaja = fachada.baja(usuario, clave);
		if( deBaja == true){
			response.sendRedirect("index.jsp");
		}

			
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("ErrorClacve", "No se pudo dar de baja tu cuenta");
			request.getRequestDispatcher("darDebaja.jsp").forward(request, response);
			
		}
		
	}

}
