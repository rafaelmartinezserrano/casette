package com.afd.casette.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

import com.afd.casette.modelo.TipoArchivo;
import com.afd.casette.modelo.Usuario;

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
		String rutaCarpeta = rutaAplicacion + "FICHEROS";
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		String rutaUsuario = rutaCarpeta + File.separator + usuario.getIdUsuario();
		String rutaPortada= rutaUsuario + File.separator + "PORTADAS" + File.separator;
		File carpetaPortada = new File(rutaPortada);
		if (!carpetaPortada.exists()) {
			carpetaPortada.mkdirs();
		}
		String rutaMusica = rutaUsuario + File.separator + "MUSICA" + File.separator;
		File carpetaMusica = new File(rutaMusica);
		if (!carpetaMusica.exists()) {
			carpetaMusica.mkdirs();
		}
		
		Part ficheroPortada = request.getPart("portada");
		String nombrePortada = extraerNombreFichero(ficheroPortada);
		System.out.println("SubirCancionServlet -> FicheroPortada: " + nombrePortada);
		
		ficheroPortada.write(rutaPortada + nombrePortada);
		
		Part ficheroMusica = request.getPart("archivo");
		String nombreMusica = extraerNombreFichero(ficheroMusica);
		System.out.println("SubirCancionServlet -> FicheroMusica: " + nombreMusica);
		
		ficheroMusica.write(rutaMusica + nombreMusica);
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



