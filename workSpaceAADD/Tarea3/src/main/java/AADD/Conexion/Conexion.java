package AADD.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String BBDD = "sakila";
    private static final String PARAMETROS = "?serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CLAVE = "*Francis12072004";
    
    /**
     * metodo que genera la conexion con la base de datos mysql
     * 
     * @return
     */
    public static Connection conexion() {
    	Connection connection = null;
    	
    	try {
    		connection = DriverManager.getConnection(URL+BBDD+PARAMETROS, USUARIO, CLAVE);
    		System.out.println("Connection OK");
    	} catch (SQLException e) {
    		System.out.println("Error en la conexion");
    		e.printStackTrace();
    	}
    	
    	return connection;
    }
}
