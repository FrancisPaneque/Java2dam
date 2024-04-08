package AADD.main;

import java.io.*;
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

/**
 * Clase Utilidades que proporciona métodos para almacenar y recuperar información relacionada con productos, proveedores y categorías.
 */

public class Utilidades {
    // Declaración de variables
    int idCategoria;
    String nombreFichero;
    Categorias categoria = null;
    ArrayList<Productos> listaProductos = null;
    ArrayList<Proveedores> listaProveedores = null;

    /**
     * Almacena los productos en un archivo dado el ID de categoría y el nombre del archivo.
     * Además, almacena los objetos en archivos binarios.
     * @param idCategoria El ID de la categoría.
     * @param nombreFichero El nombre del archivo.
     */
    public void almacenarProductosEnFichero(int idCategoria, String nombreFichero) {
        this.idCategoria = idCategoria;
        this.nombreFichero = nombreFichero;

        // Almacena los productos en estructuras de Java
        almacenarProductosEnEstructurasJava();
        // Almacena la información en un archivo de texto
        almacenaInfoEnFichero();
        // Almacena los objetos en archivos binarios
        almacenarObjetosEnBinario();
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
        listaProductos = new ArrayList<>();
        listaProveedores = new ArrayList<>();

        // Consultas SQL para recuperar la información de la base de datos
        String sql_Categorias = "select * from categorias where id=" + idCategoria;

        String sql_Proveedores_Productos_Categoria = "select * from proveedores where id in (select distinct proveedor_id from productos where categoria_id= " + idCategoria + ")";

        String sql_Productos_Categoria = "select * from productos where categoria_id=" + idCategoria;

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
                if (rs != null) rs.close();
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
            for (Proveedores prov : listaProveedores) {
                escritor.write(prov.toString());
                escritor.newLine();
            }

            escritor.newLine();
            escritor.write("PRODUCTOS");
            escritor.newLine();

            // Escribe la información de los productos en el archivo
            escritor.write(Productos.getCamposToString());
            escritor.newLine();

            for (Productos p : listaProductos) {
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
     * Almacena los objetos en archivos binarios.
     */
    private void almacenarObjetosEnBinario() {
        ObjectOutputStream objetoSalida = null;

        try {
            // Abre el archivo binario para escritura de productos
            objetoSalida = new ObjectOutputStream(new FileOutputStream(nombreFichero + "_prod.dat"));
            // Escribe cada producto en el archivo binario
            for (Productos p : listaProductos) {
                objetoSalida.writeObject(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Cierra el archivo binario de productos
                if (objetoSalida != null) objetoSalida.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            // Abre el archivo binario para escritura de categoría
            objetoSalida = new ObjectOutputStream(new FileOutputStream(nombreFichero + "_cat.dat"));
            // Escribe la categoría en el archivo binario
            objetoSalida.writeObject(categoria);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Cierra el archivo binario de categoría
                if (objetoSalida != null) objetoSalida.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            // Abre el archivo binario para escritura de proveedores
            objetoSalida = new ObjectOutputStream(new FileOutputStream(nombreFichero + "_prov.dat"));
            // Escribe cada proveedor en el archivo binario
            for (Proveedores prov : listaProveedores) {
                objetoSalida.writeObject(prov);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Cierra el archivo binario de proveedores
                if (objetoSalida != null) objetoSalida.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Lee los archivos binarios y almacena la información en las tablas correspondientes de la base de datos.
     *
     * @param nombreFicheroCat El nombre del archivo binario de categorías.
     * @param nombreFicheroProv El nombre del archivo binario de proveedores.
     * @param nombreFicheroProd El nombre del archivo binario de productos.
     */
    public void ficheros_binarios_a_tablas(String nombreFicheroCat, String nombreFicheroProv, String nombreFicheroProd) {
        // Conexión a la base de datos
        Connection cn = null;
        PreparedStatement pstCat = null;
        PreparedStatement pstProv = null;
        PreparedStatement pstProd = null;
        ObjectInputStream objetoEntradaCat = null;
        ObjectInputStream objetoEntradaProv = null;
        ObjectInputStream objetoEntradaProd = null;
        int batchSize = 10; // Tamaño del lote de productos
        int count = 0; // Contador para el tamaño del lote

        try {
            // Establece la conexión a la base de datos y desactiva el autocommit
            cn = Conexion.conexion();
            cn.setAutoCommit(false);

            // Abre los archivos binarios para lectura
            objetoEntradaCat = new ObjectInputStream(new FileInputStream(nombreFicheroCat));
            objetoEntradaProv = new ObjectInputStream(new FileInputStream(nombreFicheroProv));
            objetoEntradaProd = new ObjectInputStream(new FileInputStream(nombreFicheroProd));

            // Consultas SQL para insertar datos en las tablas
            String sql_Categorias =
                    "insert into categorias_new2 values (?, ?, ?)";

            String sql_Proveedores =
                    "insert into proveedores_new2 values (?, ?, ?)";

            String sql_Productos =
                    "insert into productos_new2 values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Prepara los PreparedStatement
            pstCat = cn.prepareStatement(sql_Categorias);
            pstProv = cn.prepareStatement(sql_Proveedores);
            pstProd = cn.prepareStatement(sql_Productos);

            // Lee y almacena las categorías
            Categorias categoria;
            while ((categoria = (Categorias) objetoEntradaCat.readObject()) != null) {
                pstCat.setInt(1, categoria.getId());
                System.out.println(pstCat);
                pstCat.setString(2, categoria.getCategoria());
                System.out.println(pstCat);
                pstCat.setString(3, categoria.getDescripcion());
                System.out.println(pstCat);
                pstCat.addBatch();
             // Si se ha alcanzado el tamaño del lote, ejecuta el lote de inserciones
                if (++count % batchSize == 0) {
                    pstCat.executeBatch();
                    pstCat.clearBatch();
                }
            }
            
            
            pstCat.close();

            // Lee y almacena los proveedores
            Proveedores proveedor;
            while ((proveedor = (Proveedores) objetoEntradaProv.readObject()) != null) {
                pstProv.setInt(1, proveedor.getId());
                pstProv.setString(2, proveedor.getEmpresa());
                pstProv.setString(3, proveedor.getContacto());
                pstProv.addBatch();
             // Si se ha alcanzado el tamaño del lote, ejecuta el lote de inserciones
                if (++count % batchSize == 0) {
                    pstProv.executeBatch();
                    pstProv.clearBatch();
                }
            }

            
            pstProv.close();

            // Lee y almacena los productos en lotes
            Productos producto;
            while ((producto = (Productos) objetoEntradaProd.readObject()) != null) {
                pstProd.setInt(1, producto.getId());
                pstProd.setString(2, producto.getProducto());
                pstProd.setInt(3, producto.getProveedorId());
                pstProd.setInt(4, producto.getCategoriaId());
                pstProd.setString(5, producto.getCantidadPorUnidad());
                pstProd.setDouble(6, producto.getPrecioUnidad());
                pstProd.setInt(7, producto.getUnidadesExistencia());
                pstProd.setInt(8, producto.getUnidadesPedido());
                pstProd.setInt(9, producto.getNivelNuevoPedido());
                pstProd.setInt(10, producto.getSuspendido());
                pstProd.addBatch();

                // Si se ha alcanzado el tamaño del lote, ejecuta el lote de inserciones
                if (++count % batchSize == 0) {
                    pstProd.executeBatch();
                    pstProd.clearBatch();
                }
            }

            // Ejecuta el lote final de inserciones de productos
            pstProd.executeBatch();
            pstProd.close();

            // Confirma las operaciones en la base de datos
            cn.commit();
        } catch (EOFException e) {
            // Se alcanzó el final del archivo, no es un error
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // En caso de error, realiza rollback de las operaciones
            try {
                if (cn != null) cn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                // Cierra los objetos de entrada y la conexión a la base de datos
                if (objetoEntradaCat != null) objetoEntradaCat.close();
                if (objetoEntradaProv != null) objetoEntradaProv.close();
                if (objetoEntradaProd != null) objetoEntradaProd.close();
                if (pstCat != null) pstCat.close();
                if (pstProv != null) pstProv.close();
                if (pstProd != null) pstProd.close();
                if (cn != null) cn.close();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
}