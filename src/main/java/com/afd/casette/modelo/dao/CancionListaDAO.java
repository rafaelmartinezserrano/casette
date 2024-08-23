package com.afd.casette.modelo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.afd.casette.modelo.Cancion;
import com.afd.casette.modelo.ListaReproduccion;
import com.afd.casette.modelo.TipoArchivo;
import com.afd.casette.modelo.Usuario;



public class CancionListaDAO {
	
	private DataSource ds;
	
	private final static String INSERTAR_CANCION_LISTA ="INSERT INTO cancionLista(pos,idCancion,idLista) VALUES (?,?,?)";
	private final static String OBTENER_ULTIMA_POSICION_LISTA ="SELECT MAX(pos) AS pos FROM cancionLista WHERE idLista = ?";
	private final static String BUSCAR_LISTA_POR_ID = "SELECT * FROM listaReproduccion WHERE idLista = ? AND idUsuario = ?";
	private final static String BUSCAR_CANCIONES_POR_LISTA = "SELECT * FROM cancionLista CL JOIN cancion C ON CL.idCancion = C.idCancion WHERE idLista = ? ORDER BY pos";
	
	public CancionListaDAO() {
		try {
			Context contexto = new InitialContext();
			this.ds = (DataSource) contexto.lookup("java:comp/env/jdbc/CasetteDS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public int sumarPocision(int idLista) throws SQLException {
		Connection conexion = this.ds.getConnection();
		PreparedStatement sentencia = conexion.prepareStatement(OBTENER_ULTIMA_POSICION_LISTA);
		sentencia.setInt(1, idLista);
		ResultSet resultado = sentencia.executeQuery();
		int pos = 0;
		if (resultado.next()) {
			pos = resultado.getInt("pos");
		}
		conexion.close();
		return pos;
	}

	public void agregarCancionLista(int pos, int idCancion, int idLista) throws SQLException {
		Connection conexion = this.ds.getConnection();
		PreparedStatement sentencia = conexion.prepareStatement(INSERTAR_CANCION_LISTA);
		sentencia.setInt(1, pos);
		sentencia.setInt(2, idCancion);
		sentencia.setInt(3, idLista);
		sentencia.executeUpdate();
		conexion.close();
		}

	public ListaReproduccion buscarListaPorId(int idLista, Usuario usuario) throws SQLException {
		Connection conexion = this.ds.getConnection();
		PreparedStatement sentenciaLR = conexion.prepareStatement(BUSCAR_LISTA_POR_ID);
		sentenciaLR.setInt(1, idLista);
		sentenciaLR.setInt(2, usuario.getIdUsuario());
		ResultSet resultadoLR = sentenciaLR.executeQuery();
		
		ListaReproduccion lista = null;
		if(resultadoLR.next()) {
			String nombre = resultadoLR.getString("nombre");
			lista = new ListaReproduccion(idLista, nombre);
			
			PreparedStatement sentenciaCL = conexion.prepareStatement(BUSCAR_CANCIONES_POR_LISTA);
			sentenciaCL.setInt(1, idLista);
			ResultSet resultadoCL = sentenciaCL.executeQuery();

			while(resultadoCL.next()) {
				int idCancion = resultadoCL.getInt("C.idCancion");
				String titulo = resultadoCL.getString("titulo");
				String autor = resultadoCL.getString("autor");
				String genero = resultadoCL.getString("genero");
				LocalTime duracion = resultadoCL.getTime("duracion").toLocalTime();
				String portada = resultadoCL.getString("portada");
				int anho = resultadoCL.getInt("anho");
				String archivo = resultadoCL.getString("archivo");
				boolean privada = resultadoCL.getBoolean("privada");
				TipoArchivo tipo = TipoArchivo.valueOf(resultadoCL.getString("tipo"));
				int reproducciones = resultadoCL.getInt("reproducciones");
				
				Cancion cancion = new Cancion(idCancion, usuario, titulo, autor, genero, duracion, portada, anho, archivo, privada, tipo, reproducciones);
				lista.agregarCancion(cancion);
			}
		}
		
		return lista;
	}

}
