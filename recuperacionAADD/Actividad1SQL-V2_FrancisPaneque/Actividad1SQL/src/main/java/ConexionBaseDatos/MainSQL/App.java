package ConexionBaseDatos.MainSQL;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConexionBaseDatos.MainSQL.Utilidades.Conexion;

public class App {
    public static void main( String[] args ){
    	
    	//Tomamos lamconexion con la base de datos
    	Connection conexion = ConexionBaseDatos.MainSQL.Utilidades.Conexion.conexion();
    	
    	//Lista que contiene el nombre
    	List<String> nombres = new ArrayList<>();
    	
    	ResultSet resultados = null;
    	try {
    		Statement instruccion = conexion.createStatement();
    		String query = "SELECT * FROM actor";
    		resultados = instruccion.executeQuery(query);
    		} catch (Exception ex) {
    			ex.printStackTrace();
    		}
    	
    	//Imprimimos en el fichero
    	imprimirFicheroEmpleados(resultados, false);
    }
    
    /**
     * Método para imprimir empleados por pantalla o en un archivo
     * @param listaEmpleados
     * @param imprimirEnPantalla
     */
    public static void imprimirFicheroEmpleados(ResultSet resultados, boolean imprimirEnPantalla) {
        try {
            if (imprimirEnPantalla) {
                // Imprimir empleados por pantalla
            	while (resultados.next()) {
       		 		System.out.println((resultados.getString("first_name")));
            	}
            } else {
                // Imprimir empleados en el archivo "nombres.txt"
            	// El segundo parámetro "true" indica que se agregará al archivo existente
                FileWriter fileWriter = new FileWriter("actores.txt", true); 
                PrintWriter printWriter = new PrintWriter(fileWriter);

                // Escribir cada empleado en el archivo de texto
                while (resultados.next()) {
       		 		printWriter.write((resultados.getString("first_name") + "\n"));
            	}

                // Cerrar el flujo de escritura
                printWriter.close();
                fileWriter.close();
                System.out.println("Los actores han sido impresos en 'actores.txt'");
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        
    }
}

