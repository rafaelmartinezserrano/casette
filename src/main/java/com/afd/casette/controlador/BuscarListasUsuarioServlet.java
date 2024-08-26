package com.afd.casette.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;

import com.afd.casette.modelo.ListaReproduccion;
import com.afd.casette.modelo.Usuario;
import com.afd.casette.modelo.fachada.Fachada;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BuscarListasUsuarioServlet
 */
public class BuscarListasUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Fachada fachada = new Fachada();
		try {
			List<ListaReproduccion> listas = fachada.buscarListasPorUsuario(usuario);
			ObjectMapper mapeador = new ObjectMapper();
			String json = mapeador.writeValueAsString(listas);
			System.out.println("BuscarListasUsuarioServlet -> Listas: " + json);
			PrintWriter salida = response.getWriter();
			response.setContentType("application/json");
			salida.write(json);
			salida.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
