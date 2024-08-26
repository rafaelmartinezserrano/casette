package com.afd.casette.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.afd.casette.modelo.Cancion;
import com.afd.casette.modelo.TipoArchivo;
import com.afd.casette.modelo.Usuario;

public class CancionDAO {

	private DataSource ds;

	private final static String INSERTAR_CANCION = "insert into cancion(titulo,autor,genero,duracion,portada,anho,archivo,privado,tipo,reproducciones,idUsuario)values(?,?,?,?,?,?,?,?,?,?,?)";
	private final static String BUSCAR_CANCIONES_POR_AUTOR = "select * from cancion where autor like ? and (privada = false or idUsuario = ?)";
	private static final String BUSCAR_CANCIONES_POR_TITULO = "select * from cancion where titulo like ? and (privada = false or idUsuario = ?)";

	public CancionDAO() {
		try {
			Context contexto = new InitialContext();
			this.ds = (DataSource) contexto.lookup("java:comp/env/jdbc/CasetteDS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public void insertarCancion(Cancion cancion) throws SQLException {
		Connection conexion = this.ds.getConnection();
		PreparedStatement sentencia = conexion.prepareStatement(INSERTAR_CANCION);
		sentencia.setString(1, cancion.getTitulo());
		sentencia.setString(2, cancion.getAutor());
		sentencia.setString(3, cancion.getGenero());
		sentencia.setTime(4, Time.valueOf(cancion.getDuracion()));
		sentencia.setString(5, cancion.getPortada());
		sentencia.setInt(6, cancion.getAnho());
		sentencia.setString(7, cancion.getArchivo());
		sentencia.setBoolean(8, cancion.isPrivada());
		sentencia.setString(9, cancion.getTipo().name());
		sentencia.setInt(10, cancion.getReproducciones());
		sentencia.setInt(11, cancion.getUsuario().getIdUsuario());
		sentencia.executeUpdate();
		conexion.close();
	}

	public List<Cancion> buscarCancionesPorTitulo(Usuario u, String titulo) throws SQLException {

		Connection conexion = this.ds.getConnection();
		PreparedStatement sentencia = conexion.prepareStatement(BUSCAR_CANCIONES_POR_TITULO);
		sentencia.setString(1, "%" + titulo + "%");
		sentencia.setInt(2, u.getIdUsuario());

		ResultSet resultado = sentencia.executeQuery();
		List<Cancion> canciones = new ArrayList<Cancion>();

		while (resultado.next()) {
			int idcancion = resultado.getInt("idcancion");
			String tituloCancion = resultado.getString("titulo");
			String autor = resultado.getString("autor");
			String genero = resultado.getString("genero");
			LocalTime duracion = resultado.getTime("duracion").toLocalTime();
			String portada = resultado.getString("portada");
			int anho = resultado.getInt("anho");
			String archivo = resultado.getString("archivo");
			boolean privada = resultado.getBoolean("privada");
			TipoArchivo tipo = TipoArchivo.valueOf(resultado.getString("tipo"));
			;
			int reproducciones = resultado.getInt("reproducciones");

			Cancion cancion = new Cancion(idcancion, u, tituloCancion, autor, genero, duracion, portada, anho, archivo,false, tipo, reproducciones);
			canciones.add(cancion);

		}
		return canciones;
	}

	public List<Cancion> buscarCancionesPorAutor(Usuario usuario, String autor) throws SQLException {
		Connection conexion = this.ds.getConnection();
		PreparedStatement sentencia = conexion.prepareStatement(BUSCAR_CANCIONES_POR_AUTOR);
		sentencia.setString(1, "%"+autor+"%");
		sentencia.setInt(2, usuario.getIdUsuario());
		System.out.println(sentencia);
		List<Cancion> canciones = new ArrayList<Cancion>();
		ResultSet resultado = sentencia.executeQuery();
		while (resultado.next()) {
			int idcancion = resultado.getInt("idcancion");
			String titulo = resultado.getString("titulo");
			String genero = resultado.getString("genero");
			LocalTime duracion = resultado.getTime("duracion").toLocalTime();
			String portada = resultado.getString("portada");
			int anho = resultado.getInt("anho");
			String archivo = resultado.getString("archivo");
			boolean privada = resultado.getBoolean("privada");
			TipoArchivo tipo = TipoArchivo.valueOf(resultado.getString("tipo"));
;			int reproducciones = resultado.getInt("reproducciones");
			
			Cancion cancion = new Cancion(idcancion, usuario, titulo, autor, genero, duracion, portada, anho, archivo, privada, tipo, reproducciones);
			canciones.add(cancion);
		}
		
		return canciones;
	}
}
