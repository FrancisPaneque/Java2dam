package AADD.utils.manager;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import AADD.models.*;
import java.io.*;

public class Utilidades {
	
	/**
	 * Metodo que crea la tabla ProductosNoVenta en la base de datos northwind como la tabla products
	 */
	public static void crearTablaProductosNoVenta() {
        Connection connection = null;
        PreparedStatement createTableStatement = null;

        try {
            // Establecer conexión a la base de datos
            connection = AADD.utils.conexion.Conexion.conexion();

            // Crear la tabla ProductosNoVenta con la misma estructura que Products
            String createTableQuery = "CREATE TABLE IF NOT EXISTS ProductosNoVenta AS SELECT * FROM Products WHERE Discontinued = 1";
            createTableStatement = connection.prepareStatement(createTableQuery);
            createTableStatement.executeUpdate();

            System.out.println("La tabla ProductosNoVenta ha sido creada con éxito y ha sido poblada con los productos discontinuados de la tabla products.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cierra conexiones
            try {
                if (createTableStatement != null) createTableStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
	/**
	 * Metodo encargado de insertar en la tabla products los datos del fichero pasado por parametros
	 * @param archivoCSV que contiene datos para la tabla products
	 */
	public static void cargarProductos(String archivoCSV) {
	    Connection connection = null;
	
	    try {
	        // Establecer conexión a la base de datos
	        connection = AADD.utils.conexion.Conexion.conexion();
	        connection.setAutoCommit(false); // Iniciar la transacción
	
	        // Leer el archivo CSV y cargar productos en la transacción
	        cargarProductosEnTransaccion(connection, archivoCSV);
	
	        // Confirmar la transacción
	        connection.commit();
	        System.out.println("Inserción de datos completada con éxito.");
	
	    } catch (SQLException e) {
	        e.printStackTrace();
	        try {
	            // Revertir la transacción en caso de error
	            if (connection != null) {
	                connection.rollback();
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    } finally {
	        // Cerrar conexiones y liberar recursos
	        try {
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	/**
	 * Metodo que lee fichero para guarda los datos del fichero en la lista de productos
	 * @param connection conexion a la base de datos
	 * @param archivoCSV archivo que se lee
	 * @throws SQLException 
	 */
	private static void cargarProductosEnTransaccion(Connection connection, String archivoCSV) throws SQLException {
        List<Products> productsList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(archivoCSV))) {
        	// Leer la primera línea y descartarla (encabezados)
            bufferedReader.readLine();
        	
        	String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Separar la línea en campos usando la coma como delimitador
                String[] values = line.split(",");

                // Crear objeto Products y agregarlo a la lista
                Products product = new Products();
                //Elimina las comillas dobles
                product.setProductName(values[0].replaceAll("\"", "").trim());
                product.setSupplierId(Integer.parseInt(values[1].trim()));
                product.setCategoryId(Integer.parseInt(values[2].trim()));
                product.setQuantityPerUnit(values[3].replaceAll("\"", "").trim());
                product.setUnitPrice(new BigDecimal(values[4].trim()));
                product.setUnitsInStock(Short.parseShort(values[5].trim()));
                product.setUnitsOnOrder(Short.parseShort(values[6].trim()));
                product.setReorderLevel(Short.parseShort(values[7].trim()));
                product.setDiscontinued(Integer.parseInt(values[8].trim()) == 1);

                productsList.add(product);
            }

            // Insertar los productos en lotes
            insertarProductosEnLotes(connection, productsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * Metodo que realiza el insert en la tabla products
	 * @param connection conexion a la base de datos
	 * @param productsList lista que contiene los objetos de tipo proucts
	 * @throws SQLException
	 */
	private static void insertarProductosEnLotes(Connection connection, List<Products> productsList) throws SQLException {
	    
		String insert = "INSERT INTO Products (ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
	        int batchCount = 0;
	
	        for (Products product : productsList) {
	            // Agregar valores al PreparedStatement
	            preparedStatement.setString(1, product.getProductName());
	            preparedStatement.setInt(2, product.getSupplierId());
	            preparedStatement.setInt(3, product.getCategoryId());
	            preparedStatement.setString(4, product.getQuantityPerUnit());
	            preparedStatement.setBigDecimal(5, product.getUnitPrice());
	            preparedStatement.setShort(6, product.getUnitsInStock());
	            preparedStatement.setShort(7, product.getUnitsOnOrder());
	            preparedStatement.setShort(8, product.getReorderLevel());
	            preparedStatement.setInt(9, product.isDiscontinued() ? 1 : 0);
	
	            // Agregar la sentencia al batch
	            preparedStatement.addBatch();
	            batchCount++;
	
	            // Ejecutar el batch cada 10 sentencias
	            if (batchCount % 10 == 0) {
	                preparedStatement.executeBatch();
	                preparedStatement.clearBatch();
	            }
	        }
	
	        // Ejecutar el último batch
	        preparedStatement.executeBatch();
	    }
	}
	
	/**
	 * Metodo que pasa a fichero dos o csv los productos
	 * @param nombreCategoria
	 * @param esTexto
	 */
	public static void productosToFichero(String nombreCategoria, boolean esTexto) {
        Connection connection = null;

        try {
            // Establecer conexión a la base de datos
            connection = AADD.utils.conexion.Conexion.conexion();

            // Obtener los productos de la categoría indicada y que no están discontinuados
            String query = "SELECT * FROM Products WHERE CategoryID = (SELECT CategoryID FROM Categories WHERE CategoryName = ?) AND Discontinued = 0";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, nombreCategoria);
                ResultSet resultSet = preparedStatement.executeQuery();

                // Determinar el nombre del fichero según la categoría y el formato
                String nombreFichero;
                if (esTexto) {
                    nombreFichero = "productos_cat_" + nombreCategoria.toLowerCase() + ".csv";
                } else {
                    nombreFichero = "productos_cat_" + nombreCategoria.toLowerCase() + ".dat";
                }

                // Crear el BufferedWriter o DataOutputStream según sea necesario
                try {
                    if (esTexto) {
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreFichero))) {
                            escribirFicheroTexto(resultSet, writer);
                        }
                    } else {
                    	List<Products> productos = obtenerProductosDesdeResultSet(resultSet);
                    	escribirFicheroBinario(productos, nombreFichero);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar conexiones y liberar recursos
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
	/**
	 * Escribe el resulset a fichero txt
	 * @param resultSet
	 * @param writer
	 * @throws SQLException
	 * @throws IOException
	 */
    private static void escribirFicheroTexto(ResultSet resultSet, BufferedWriter writer) throws SQLException, IOException {
        // Escribir encabezados al archivo CSV
        writer.write("ProductID;ProductName;SupplierID;CategoryID;QuantityPerUnit;UnitPrice;UnitsInStock;UnitsOnOrder;ReorderLevel;Discontinued");
        writer.newLine();

        // Escribir datos al archivo CSV
        while (resultSet.next()) {
            writer.write(resultSet.getInt("ProductID") + ";"
                    + resultSet.getString("ProductName") + ";"
                    + resultSet.getInt("SupplierID") + ";"
                    + resultSet.getInt("CategoryID") + ";"
                    + resultSet.getString("QuantityPerUnit") + ";"
                    + resultSet.getBigDecimal("UnitPrice") + ";"
                    + resultSet.getShort("UnitsInStock") + ";"
                    + resultSet.getShort("UnitsOnOrder") + ";"
                    + resultSet.getShort("ReorderLevel") + ";"
                    + resultSet.getInt("Discontinued"));
            writer.newLine();
        }
    }
    
    /**
     * Escribe le resulset a dos
     * @param resultSet
     * @param dos
     * @throws SQLException
     * @throws IOException
     */
    private static void escribirFicheroBinario(List<Products> productos, String nombreFichero) throws SQLException, IOException {
    	try {
            // Crear un flujo de salida de objetos ObjectOutputStream
        	// El segundo parámetro "true" indica que se agregará al archivo existente
            FileOutputStream fileOut = new FileOutputStream(nombreFichero, true); 
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            // Escribir cada empleado de la lista en el archivo
            for (Products producto : productos) {
                out.writeObject(producto);
            }

            // Cerrar el flujo de salida
            out.close();
            fileOut.close();
            System.out.println("Los empleados han sido guardados en 'empleados.dat'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Metodo que pasa los datos del resulset a lista
     * @param resultSet contiene los datos de la query 
     * @return listaProducts
     * @throws SQLException
     */
    private static List<Products> obtenerProductosDesdeResultSet(ResultSet resultSet) throws SQLException {
        List<Products> productsList = new ArrayList<>();

        while (resultSet.next()) {
            Products product = new Products();
            product.setProductId(resultSet.getInt("ProductID"));
            product.setProductName(resultSet.getString("ProductName"));
            product.setSupplierId(resultSet.getInt("SupplierID"));
            product.setCategoryId(resultSet.getInt("CategoryID"));
            product.setQuantityPerUnit(resultSet.getString("QuantityPerUnit"));
            product.setUnitPrice(resultSet.getBigDecimal("UnitPrice"));
            product.setUnitsInStock(resultSet.getShort("UnitsInStock"));
            product.setUnitsOnOrder(resultSet.getShort("UnitsOnOrder"));
            product.setReorderLevel(resultSet.getShort("ReorderLevel"));
            product.setDiscontinued(resultSet.getInt("Discontinued") == 1);

            productsList.add(product);
        }

        return productsList;
    }
    
}
