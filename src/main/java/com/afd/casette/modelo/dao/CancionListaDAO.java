package com.afd.casette.modelo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class CancionListaDAO {
	
	private DataSource ds;
	
	private final static String INSERTAR_CANCION_LISTA ="insert into CancionLista(pos,idCancion,idLista) values(?,?,?)";
	private final static String CONTAR_POCISIONES ="select max(pos) as pos from cancionLista where idLista = ?";
	
	public CancionListaDAO() {
		try {
			Context contexto = new InitialContext();
			this.ds = (DataSource) contexto.lookup("java:comp/env/jdbc/CasetteDS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
		public int sumarPocision(int idLista) throws SQLException {
			Connection coneccion = this.ds.getConnection();
			PreparedStatement sentencia = coneccion.prepareStatement(CONTAR_POCISIONES);
			sentencia.setInt(1, idLista);
			ResultSet resultado = sentencia.executeQuery();
			int pos = 0;
			if(resultado.next()) {
				pos = resultado.getInt("pos");
			}
			
			return pos;
		}
	
		public void agregarCancionLista(int pos ,int idCancion, int idLista) throws SQLException{
		Connection coneccion = this.ds.getConnection();
		PreparedStatement sentencia = coneccion.prepareStatement(INSERTAR_CANCION_LISTA);
		sentencia.setInt(1, pos);
		sentencia.setInt(2, idCancion);
		sentencia.setInt(3, idLista);
		sentencia.executeUpdate();
		}
		
		

}
