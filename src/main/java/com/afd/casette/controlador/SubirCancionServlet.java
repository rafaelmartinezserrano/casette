package com.afd.casette.controlador;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;

import com.afd.casette.modelo.Cancion;
import com.afd.casette.modelo.TipoArchivo;
import com.afd.casette.modelo.Usuario;
import com.afd.casette.modelo.fachada.Fachada;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class SubirCancionServlet
 */
public class SubirCancionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String genero = request.getParameter("genero");
		String strDuracion = request.getParameter("duracion");
		LocalTime duracion = LocalTime.parse("00:" + strDuracion);
		String strAnho = request.getParameter("anho");
		int anho = Integer.parseInt(strAnho);
		boolean privada = request.getParameter("privada") != null;
		String strTipoArchivo = request.getParameter("tipoArchivo");
		TipoArchivo tipoArchivo = TipoArchivo.valueOf(strTipoArchivo);
		
		String rutaAplicacion = request.getServletContext().getRealPath("");
		File ruta = new File(rutaAplicacion);
		String rutaCarpeta = ruta.getParent() + File.separator + "ROOT" + File.separator + "FICHEROS";
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		String rutaUsuario = rutaCarpeta + File.separator + usuario.getIdUsuario();
		String rutaPortada= rutaUsuario + File.separator + "PORTADAS" + File.separator;
		Part ficheroPortada = request.getPart("portada");
		String nombrePortada = extraerNombreFichero(ficheroPortada);
		subirFichero(ficheroPortada, rutaPortada + nombrePortada);
		
		String rutaMusica = rutaUsuario + File.separator + "MUSICA" + File.separator;
		Part ficheroMusica = request.getPart("archivo");
		String nombreMusica = extraerNombreFichero(ficheroMusica);
		subirFichero(ficheroMusica, rutaMusica + nombreMusica);
		
		Cancion cancion = new Cancion(0, usuario, titulo, autor, genero, duracion, nombrePortada, anho, nombreMusica, privada, tipoArchivo);
		Fachada fachada = new Fachada();
		try {
			fachada.guardarCancion(cancion);
			request.getRequestDispatcher("principal.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "Error al subir la canción");
			request.getRequestDispatcher("subirCancion.jsp").forward(request, response);
		}
	}
	
	private void subirFichero(Part parte, String ruta) throws IOException {
		File carpeta = new File(ruta);
		if (!carpeta.exists()) {
			carpeta.mkdirs();
		}
		parte.write(ruta);
	}

	private String extraerNombreFichero(Part parte) {
		String contenido = parte.getHeader("content-disposition");
		//System.out.println("SubirCancionServlet -> Cabecera: " + contenido);
		String[] fragmentos = contenido.split(";");
		String nombreFichero = "";
		for (String fragmento : fragmentos) {
			if (fragmento.trim().startsWith("filename")) {
				int posInicial = fragmento.indexOf("=") + 2;
				int posFinal = fragmento.length() - 1;
				nombreFichero = fragmento.substring(posInicial, posFinal);
			}
		}
		return nombreFichero;
	}
}



