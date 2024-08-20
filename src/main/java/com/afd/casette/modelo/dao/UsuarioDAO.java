package com.afd.casette.modelo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.afd.casette.modelo.Usuario;

public class UsuarioDAO {
	
	private DataSource ds;
	
	private final static String INSERTAR_USUARIO = "INSERT INTO usuario (nombreUsuario,clave,email,fechaNacimiento) VALUES (?,?,?,?)";
	
	private final static String BUSCAR_USUARIO_POR_NOMBRE = "SELECT * FROM usuario WHERE nombreUsuario = ?";
	
	public UsuarioDAO() {
		try {
			Context contexto = new InitialContext();
			this.ds = (DataSource) contexto.lookup("java:comp/env/jdbc/CasetteDS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public Usuario insertarUsuario(Usuario usuario) throws SQLException{
		Connection conexion = this.ds.getConnection();
		PreparedStatement sentencia = conexion.prepareStatement(INSERTAR_USUARIO, Statement.RETURN_GENERATED_KEYS);
		sentencia.setString(1, usuario.getNombreUsuario());
		sentencia.setString(2, usuario.getClave());
		sentencia.setString(3, usuario.getEmail());
		sentencia.setDate(4, Date.valueOf(usuario.getFechaNacimiento()));
		sentencia.executeUpdate();
		
		Usuario nuevoUsuario = null;
		
		ResultSet keys = sentencia.getGeneratedKeys();
		if (keys.next()) {
			nuevoUsuario = usuario;
			int key = keys.getInt(1);
			nuevoUsuario.setIdUsuario(key);
		}

		conexion.close();
		return nuevoUsuario;
	}
	
	public Usuario buscarUsuarioPorNombre(String nombreUsuario) throws SQLException {
		Connection conexion = this.ds.getConnection();
		PreparedStatement sentencia = conexion.prepareStatement(BUSCAR_USUARIO_POR_NOMBRE);
		sentencia.setString(1, nombreUsuario);
		ResultSet resultado = sentencia.executeQuery();
		
		Usuario usuario = null;
		
		if(resultado.next()) {
			int idUsuario = resultado.getInt("idUsuario");
			String clave = resultado.getString("clave");
			String email = resultado.getString("email");
			LocalDate fechaNacimiento = resultado.getDate("fechaNacimiento").toLocalDate();
			boolean deBaja = resultado.getBoolean("deBaja");
			
			usuario = new Usuario(idUsuario, nombreUsuario, clave, email, fechaNacimiento, deBaja);
		}
		
		conexion.close();
		return usuario;
	}
}
