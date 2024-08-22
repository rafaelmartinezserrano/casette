package com.afd.casette.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.afd.casette.modelo.Cancion;

public class CancionDAO {

	private DataSource ds;
	
	private final static String INSERTAR_CANCION = "insert into cancion(titulo,autor,genero,duracion,portada,anho,archivo,privado,tipo,reproducciones,idUsuario)values(?,?,?,?,?,?,?,?,?,?,?)";
	
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

}
