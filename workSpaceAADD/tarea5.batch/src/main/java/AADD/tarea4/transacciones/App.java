package AADD.tarea4.transacciones;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import AADD.Conexion.Conexion;

public class App {
    public static void main( String[] args ) {
         
         try {
        	 Connection conexion = AADD.Conexion.Conexion.conexion();
             
             // Sentencias SQL para INSERT y UPDATE
             String[] sentencias = {
                 "INSERT INTO envios (empresa, telefono) VALUES (?, ?)",
                 "UPDATE clientes SET pais = ? WHERE ciudad = ?"
             };
             
             // Crear un PreparedStatement para cada tipo de sentencia
             PreparedStatement insertStatement = conexion.prepareStatement(sentencias[0]);
             PreparedStatement updateStatement = conexion.prepareStatement(sentencias[1]);
             
             // Datos para las sentencias
             String[] datosInsert = {"Vodafone", "654631212"};
             String[] datosUpdate = {"España", "Cordoba"};
             
             // Ejecutar en lotes de 5 sentencias
             for (int i = 0; i < 20; i++) {
                 if (i % 5 == 0) {
                     conexion.setAutoCommit(false); // Deshabilitar la confirmación automática
                 }
                 
                 if (i < 10) {
                     insertStatement.setString(1, datosInsert[0]);
                     insertStatement.setString(2, datosInsert[1]);
                     insertStatement.addBatch();
                 } else {
                     updateStatement.setString(1, datosUpdate[0]);
                     updateStatement.setString(2, datosUpdate[1]);
                     updateStatement.addBatch();
                 }
                 
                 if (i % 5 == 4) {
                     insertStatement.executeBatch(); // Ejecutar lote de inserciones
                     updateStatement.executeBatch(); // Ejecutar lote de actualizaciones
                     conexion.commit(); // Confirmar el lote
                     conexion.setAutoCommit(true); // Habilitar la confirmación automática nuevamente
                 }
             }
             
             // Cerrar los PreparedStatement y la conexión
             insertStatement.close();
             updateStatement.close();
             conexion.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }
}
