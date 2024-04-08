package AADD.main;

import java.io.IOException;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException, IOException {
        // Crear una instancia de Utilidades
        Utilidades utilidades = new Utilidades();
        
        // Llamar al método para almacenar productos en un fichero
        utilidades.almacenarProductosEnFichero(1, "Ficheros/informacion");
        
        // Llamar al método para pasar la información del fichero binarios a las tablas de la base de datos
        utilidades.ficheros_binarios_a_tablas("Ficheros/informacion_cat.dat", "Ficheros/informacion_prod.dat", "Ficheros/informacion_prov.dat");
        
        
        System.out.println("Operaciones completadas con éxito.");
    }
}