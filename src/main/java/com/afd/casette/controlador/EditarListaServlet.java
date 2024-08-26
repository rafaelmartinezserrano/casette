package com.afd.casette.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import com.afd.casette.modelo.fachada.Fachada;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonString;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditarListaServlet
 */
public class EditarListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		try(JsonReader lector = Json.createReader(request.getReader())) {
			// Convertir la solicitud a un objeto JSON
			JsonObject objetoJSON = lector.readObject();
			// Extraer los datos
			String idLista = objetoJSON.getString("id");
			String nombreLista = objetoJSON.getString("nombre");
			JsonArray arrayCanciones = objetoJSON.getJsonArray("orden");
			// Convertir el JsonArray a una lista de Java
			List<String> listaCanciones = arrayCanciones.getValuesAs(JsonString.class).stream().map(JsonString::getString).collect(Collectors.toList());
			
			Fachada fachada = new Fachada();
			boolean listaActualizada = fachada.editarListaPorId(Integer.parseInt(idLista), nombreLista, listaCanciones);
			
			if(listaActualizada) {
				response.getWriter().write("{\"tipo\":\"Exito\",\"mensaje\":\"Lista guardada con éxito\"}");
			} else {
				response.getWriter().write("{\"tipo\":\"Error\",\"mensaje\":\"Problemas de conexión. Intentelo más tarde o contacte con soporte\"}");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("{\"tipo\":\"Error\",\"mensaje\":\"Problemas de conexión. Intentelo más tarde o contacte con soporte\"}");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("{\"tipo\":\"Error\",\"mensaje\":\"Error al procesar la solicitud\"}");
		}
	}

}
