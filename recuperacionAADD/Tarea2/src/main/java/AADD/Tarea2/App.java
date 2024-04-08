package AADD.Tarea2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import AADD.conexion.Conexion;

public class App {
	
    public static void main( String[] args ) throws SQLException {
        //Inicia la conexion
    	Connection connection = Conexion.conexion();
    			
    		//Crea el statement
    		Statement statement = connection.createStatement();
    		
    		//Declara las tablas
    		String creaEmpleado = "CREATE TABLE empleado(ID char(5) PRIMARY KEY, DNI char(9) UNIQUE, Nombre varchar(25), FechaNac date, Telefono varchar(12), Salario decimal, CodLocalidad char(5), FOREIGN KEY(CodLocalidad) REFERENCES localidad(CodLocalidad))";
    		String creaLocalidad = "CREATE TABLE localidad(CodLocalidad char(5) PRIMARY KEY, Nombre varchar(25), CodProvincia char(5), FOREIGN KEY (CodProvincia) REFERENCES provincia(CodProvincia))";
    		String creaProvincia = "CREATE TABLE provincia(CodProvincia char(5) PRIMARY KEY, Nombre varchar(25), CodRegion char(5), FOREIGN KEY (CodRegion) REFERENCES region(CodRegion))";
   			String creaRegion = "CREATE TABLE region(CodRegion char(5) PRIMARY KEY, nombre varchar(25))";
    		
   			//Ejecuta la creacion
    		statement.execute(creaRegion);
    		statement.execute(creaProvincia);
    		statement.execute(creaLocalidad);
    		statement.execute(creaEmpleado);
    			
    		//Cerramos las conexiones
    		statement.close();
    		connection.close();
    }
}
