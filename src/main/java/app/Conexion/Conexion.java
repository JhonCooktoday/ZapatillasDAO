package app.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
	private static String URL = "jdbc:mysql://127.0.0.1:3306/bd_zapatillas";
	private static String USUARIO = "root";
	private static String CLAVE = "123456";
	
	public static Connection getConexion() {
		Connection conexion = null;
		
		try {
			// Cargar el driver para MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Definir el objeto de conexion
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return conexion;
	}


}//fin de la clase