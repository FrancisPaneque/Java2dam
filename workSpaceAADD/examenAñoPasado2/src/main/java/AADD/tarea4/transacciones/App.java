package AADD.tarea4.transacciones;

public class App {
    public static void main(String[] args) {
        // Crear una instancia de Utilidades
        Utilidades utilidades = new Utilidades();
        
        // Llamar al método para almacenar productos en un fichero
        utilidades.almacenarProductosEnFichero(1, "Ficheros/productos.txt");
        
        // Llamar al método para pasar la información del fichero a las tablas de la base de datos
        utilidades.fichero_a_tablas("Ficheros/productos.txt");
        
        System.out.println("Operaciones completadas con éxito.");
    }
}