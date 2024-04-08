package AADD.main;

public class App {
	private static final String RUTA_FICHERO = "Ficheros/productosNuevos.csv";
    public static void main( String[] args ) {
    	AADD.utils.manager.Utilidades.crearTablaProductosNoVenta();
    	AADD.utils.manager.Utilidades.cargarProductos(RUTA_FICHERO);
    	// Llamar al método para crear el fichero de productos en formato texto
    	AADD.utils.manager.Utilidades.productosToFichero("Beverages", true);
    	AADD.utils.manager.Utilidades.productosToFichero("Beverages", false);
    }
}
