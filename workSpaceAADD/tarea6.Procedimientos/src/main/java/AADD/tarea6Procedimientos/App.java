package AADD.tarea6Procedimientos;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import AADD.Conexion.Conexion;

public class App {
    public static void main( String[] args ) {
    	try {
            Connection conexion = AADD.Conexion.Conexion.conexion();
            
            // Llama al procedimiento almacenado
            String callProcedure = "{call iva_nota(?)}";
            CallableStatement statement = conexion.prepareCall(callProcedure);
            
            // Establece los parámetros del procedimiento (en este caso, un entero)
            statement.setInt(1, 123); // Cambia 123 por el valor que desees
            
            // Ejecuta el procedimiento almacenado
            statement.execute();
            
            // Cierra la conexión y la declaración
            statement.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
