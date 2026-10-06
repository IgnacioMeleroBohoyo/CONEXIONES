package dam;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.*;
import dam.Planetas;

public class PlanetasDAO {
private Connection con = null;
	
	public Connection getCon() {
		return con;
	}

	private void setCon(Connection con) {
		this.con = con;
	}
	public void conectar() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println("Error con el driver: " + e.getMessage());
		}
		
		try{
			String urlConexion = "jdbc:sqlite:pruebas.db";
			Connection c = DriverManager.getConnection(urlConexion);
			this.setCon(c);
			System.out.println("Conectado correctamente a la base de datos de SqLite");
		
		} catch (SQLException e) {
			System.err.println("Error con la conexión a la base de datos " + e.getMessage());
		}
	}	
	public void cerrarConexion() {
		try {
			System.out.println("Saliendo de la Base de Datos...");
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			System.err.println("Error al cerrar conexión: " + e.getMessage());
		}
	}
	
	public void crearTabla() {
		String sql = "CREATE TABLE IF NOT EXISTS planetas ("
				 + "id INTEGER PRIMARY KEY,"
				 + "name TEXT NOT NULL,"
				 + "type TEXT NOT NULL,"
				 + "size REAL NOT NULL,"
				 + "has_rings INTEGER NOT NULL DEFAULT 0," // Booleano: 1 = Sí, 0 = No
				 + "discovered_date TEXT" // Fecha: formato YYYY-MM-DD
				 + ");";
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		}catch(Exception e) {
			System.out.println("Error" + e.getMessage());
		}
	}
}