/**
 * Clase Utilidades que proporciona métodos para almacenar y recuperar información relacionada con productos, proveedores y categorías.
 */
package AADD.tarea4.transacciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import AADD.Conexion.*;
import categoria.Categorias;
import productos.Productos;
import proveedor.Proveedores;

public class Utilidades {
    // Declaración de variables
    int idCategoria;
    String nombreFichero;
    Categorias categoria = null;
    ArrayList<Productos> listaProductos = null;
    ArrayList<Proveedores> listaProveedores = null;

    /**
     * Almacena los productos en un archivo dado el ID de categoría y el nombre del archivo.
     * @param idCategoria El ID de la categoría.
     * @param nombreFichero El nombre del archivo.
     */
    public void almacenarProductosEnFichero(int idCategoria, String nombreFichero) {
        this.idCategoria = idCategoria;
        this.nombreFichero = nombreFichero;

        // Almacena los productos en estructuras de Java
        almacenarProductosEnEstructurasJava();
        // Almacena la información en un archivo
        almacenaInfoEnFichero();
    }

    /**
     * Almacena la información de los productos en estructuras de Java.
     */
    private void almacenarProductosEnEstructurasJava() {
        // Conexión a la base de datos
        Conexion conexion = new Conexion();
        Connection cn = null;
        Statement stm = null;
        ResultSet rs = null;

        // Inicialización de variables
        categoria = new Categorias();
        listaProductos = new ArrayList<Productos>();
        listaProveedores = new ArrayList<Proveedores>();

        // Consultas SQL para recuperar la información de la base de datos
        String sql_Categorias = 
            "select * "
            + "from categorias "
            + "where id=" + idCategoria;
        
        String sql_Proveedores_Productos_Categoria = 
            "select * "
            + "from proveedores "
            + "where id in (select distinct proveedor_id "
            +               "from productos "
            +               "where categoria_id= " + idCategoria + ")";
        
        String sql_Productos_Categoria = 
            "select * "
            + "from productos "
            + "where categoria_id=" + idCategoria;
        
        try {
            // Establece la conexión a la base de datos y desactiva el autocommit
            cn = conexion.conexion();
            cn.setAutoCommit(true);

            // Ejecución de la consulta de categorías
            stm = cn.createStatement();
            rs = stm.executeQuery(sql_Categorias);
            
            // Recupera la información de la categoría
            while (rs.next()) {
                categoria.setId(rs.getInt(1));
                categoria.setCategoria(rs.getString(2));
                categoria.setDescripcion(rs.getString(3));
            }
            
            rs.close();
            stm.close();
            
            // Ejecución de la consulta de productos
            stm = cn.createStatement();
            rs = stm.executeQuery(sql_Productos_Categoria);
            
            // Recupera la información de los productos
            while (rs.next()) {
                Productos p = new Productos();
                
                p.setId(rs.getInt(1));
                p.setProducto(rs.getString(2));
                p.setProveedorId(rs.getInt(3));
                p.setCategoriaId(rs.getInt(4));
                p.setCantidadPorUnidad(rs.getString(5));
                p.setPrecioUnidad(rs.getDouble(6));
                p.setUnidadesExistencia(rs.getInt(7));
                p.setUnidadesPedido(rs.getInt(8));
                p.setNivelNuevoPedido(rs.getInt(9));
                p.setSuspendido(rs.getInt(10));
                
                listaProductos.add(p);
            }
            
            rs.close();
            stm.close();
            
            // Ejecución de la consulta de proveedores relacionados con los productos de la categoría
            stm = cn.createStatement();
            rs = stm.executeQuery(sql_Proveedores_Productos_Categoria);

            // Recupera la información de los proveedores
            while (rs.next()) {
                Proveedores prov = new Proveedores();
                
                prov.setId(rs.getInt(1));
                prov.setEmpresa(rs.getString(2));
                prov.setContacto(rs.getString(3));
                
                listaProveedores.add(prov);
            }
            
            rs.close();
            stm.close();            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs!= null) rs.close();
                if (stm != null) stm.close();
                if (cn != null) cn.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }   
    }

    /**
     * Almacena la información en un archivo.
     */
    private void almacenaInfoEnFichero() {
        BufferedWriter escritor = null;

        try {
            // Abre el archivo para escritura
            escritor = new BufferedWriter(new FileWriter(nombreFichero));
            
            // Escribe la información de la categoría en el archivo
            escritor.write("CATEGORIA");
            escritor.newLine();
            escritor.write(Categorias.getCamposToString());
            escritor.newLine();
            escritor.write(categoria.toString());
            escritor.newLine();
            
            escritor.newLine();
            escritor.write("PROVEEDORES");
            escritor.newLine();
            escritor.write(Proveedores.getCamposToString());
            escritor.newLine();
            
            // Escribe la información de los proveedores en el archivo
            for(Proveedores prov: listaProveedores) {
                escritor.write(prov.toString());
                escritor.newLine();
            }
            
            escritor.newLine();
            escritor.write("PRODUCTOS");
            escritor.newLine();
            
            // Escribe la información de los productos en el archivo
            escritor.write(Productos.getCamposToString());
            escritor.newLine();
            
            for(Productos p: listaProductos) {
                escritor.write(p.toString());
                escritor.newLine();
            }                   
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Cierra el archivo
                escritor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Lee un archivo y almacena la información en las tablas correspondientes.
     * @param nombreFichero El nombre del archivo.
     */
    public void fichero_a_tablas(String nombreFichero) {
        // Conexión a la base de datos
        Conexion conexion = new Conexion();
        Connection cn = null;
        PreparedStatement pst = null;
        BufferedReader lector = null;
        String linea = "";
        boolean procesandoCategoria = false, procesandoProveedor = false, procesandoProducto = false;

        // Consultas SQL para insertar datos en las tablas
        String sql_Categorias = 
            "insert into "
            + "categorias_new values "
            + "(?,?,?)";
        
        String sql_Proveedores = 
            "insert into "
            + "proveedores_new values "
            + "(?,?,?)";
        
        String sql_Productos = 
            "insert into "
            + "productos_new values "
            + "(?,?,?,?,?,?,?,?,?,?)";
        
        try {
            // Establece la conexión a la base de datos y desactiva el autocommit
            cn = conexion.conexion();
            
            cn.setAutoCommit(false);
            
            // Abre el archivo para lectura
            lector = new BufferedReader(new FileReader(nombreFichero));
            linea = lector.readLine();
            
            // Procesamiento del archivo línea por línea
            while (linea != null) {
                if (linea.equals("")) {
                    procesandoCategoria = false;
                    procesandoProveedor = false;
                    procesandoProducto = false;
                }
                else if (linea.equals("CATEGORIA")) {
                    linea = lector.readLine();               
                    procesandoCategoria = true;
                }
                else if (linea.equals("PROVEEDORES")) {
                    linea = lector.readLine();               
                    procesandoProveedor = true;
                }
                else if (linea.equals("PRODUCTOS")) {
                    linea = lector.readLine();               
                    procesandoProducto = true;
                }
                else if (procesandoCategoria) {                 
                    String[] campos = linea.split(";");
                    
                    // Ejecución de la inserción de categorías
                    pst = cn.prepareStatement(sql_Categorias);
                    pst.setInt(1, Integer.parseInt(campos[0]));
                    pst.setString(2, campos[1]);
                    pst.setString(3, campos[2]);
                    
                    pst.executeUpdate();  
                }
                else if (procesandoProveedor) {                 
                    String[] campos = linea.split(";");
                    
                    // Ejecución de la inserción de proveedores
                    pst = cn.prepareStatement(sql_Proveedores);
                    pst.setInt(1, Integer.parseInt(campos[0]));
                    pst.setString(2, campos[1]);
                    pst.setString(3, campos[2]);
                    
                    pst.executeUpdate(); 
                }
                else if (procesandoProducto) {                 
                    String[] campos = linea.split(";");
                    
                    // Ejecución de la inserción de productos
                    pst = cn.prepareStatement(sql_Productos);
                    pst.setInt(1, Integer.parseInt(campos[0]));
                    pst.setString(2, campos[1]);
                    pst.setInt(3, Integer.parseInt(campos[2]));
                    pst.setInt(4, Integer.parseInt(campos[3]));
                    pst.setString(5, campos[4]);
                    pst.setDouble(6, Double.parseDouble(campos[5]));
                    pst.setInt(7, Integer.parseInt(campos[6]));
                    pst.setInt(8, Integer.parseInt(campos[7]));
                    pst.setInt(9, Integer.parseInt(campos[8]));
                    pst.setInt(10, Integer.parseInt(campos[9]));
                    
                    pst.executeUpdate(); 
                }
                
                linea = lector.readLine();
            }
            
            // Confirma las operaciones en la base de datos
            cn.commit();
                
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            try {
                // Si hay un error, hace rollback de las operaciones
                cn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                // Cierra el lector de archivo
                lector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {               
                // Cierra el PreparedStatement y la conexión a la base de datos
                if (pst != null) pst.close();             
                if (cn != null) cn.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }           
        }   
    }
}