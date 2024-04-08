package utils;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class Utilidades {
	

	public static SessionFactory sessionFactory;
	
	/**
     * Ejecuta la consulta HQL 1 y muestra los resultados.
     */
    public static void executeQuery1() {
        executeAndPrintResult("SELECT c.categoria, p.producto " +
                "FROM Categorias c " +
                "JOIN Productos p ON p.categoria_id = c.id " +
                "WHERE p.producto LIKE '%q%' " +
                "ORDER BY c.categoria, p.producto");
    }

    /**
     * Ejecuta la consulta HQL 2 y muestra los resultados.
     */
    public static void executeQuery2() {
        executeAndPrintResult("SELECT p.id, c.pais, p.fecha_pedido " +
                "FROM Pedidos p " +
                "JOIN Clientes c ON p.cliente_id = c.id " +
                "WHERE p.fecha_pedido BETWEEN '1997-05-01' AND '1997-05-31' " +
                "ORDER BY p.fecha_pedido, p.id");
    }

    /**
     * Ejecuta la consulta HQL 3 y muestra los resultados.
     */
    public static void executeQuery3() {
        executeAndPrintResult("SELECT d.pedido_id, p.fecha_pedido, d.cantidad, s.producto, d.precio_unidad " +
                "FROM Pedidos p " +
                "JOIN Detalles d ON p.id = d.pedido_id " +
                "JOIN Productos s ON s.id = d.producto_id " +
                "WHERE p.id IN (10285, 10298) " +
                "ORDER BY p.id, p.fecha_pedido");
    }

    /**
     * Ejecuta la consulta HQL 4 y muestra los resultados.
     */
    public static void executeQuery4() {
        executeAndPrintResult("SELECT year(p.fecha_pedido) as año, month(p.fecha_pedido) as mes, " +
                "SUM(d.cantidad * d.precio_unidad * (1 - d.descuento)) as total " +
                "FROM Pedidos p " +
                "JOIN Detalles d ON p.id = d.pedido_id " +
                "GROUP BY year(p.fecha_pedido), month(p.fecha_pedido) " +
                "ORDER BY total");
    }

    /**
     * Ejecuta la consulta HQL 5 y muestra los resultados.
     */
    public static void executeQuery5() {
        executeAndPrintResult("SELECT * FROM Pedidos p WHERE p.empleado_id = " +
                "(SELECT id FROM Empleados WHERE nombre = 'Nancy')");
    }

    /**
     * Ejecuta la consulta HQL 6 y muestra los resultados.
     */
    public static void executeQuery6() {
        executeAndPrintResult("SELECT * FROM Pedidos p WHERE p.cliente_id = " +
                "(SELECT id FROM Clientes WHERE codigo = 'ANTON')");
    }

    /**
     * Ejecuta la consulta HQL 7 y muestra los resultados.
     */
    public static void executeQuery7() {
        executeAndPrintResult("SELECT c.categoria, COUNT(p.id), AVG(p.precio_unidad) as precio_medio " +
                "FROM Productos p " +
                "LEFT JOIN Categorias c ON p.categoria_id = c.id " +
                "GROUP BY c.categoria");
    }

    /**
     * Ejecuta la consulta HQL 8 y muestra los resultados.
     */
    public static void executeQuery8() {
        executeAndPrintResult("SELECT DISTINCT d.pedido_id " +
                "FROM Detalles d " +
                "WHERE d.producto_id IN (SELECT p.id FROM Productos p WHERE p.categoria_id IN (2, 3)) " +
                "ORDER BY d.pedido_id");
    }

    /**
     * Ejecuta la consulta HQL 9 y muestra los resultados.
     */
    public static void executeQuery9() {
        executeAndPrintResult("SELECT DISTINCT c.empresa " +
                "FROM Clientes c " +
                "JOIN Pedidos p ON c.id = p.cliente_id " +
                "JOIN Detalles d ON p.id = d.pedido_id " +
                "JOIN Productos r ON r.id = d.producto_id " +
                "WHERE p.fecha_pedido BETWEEN '1997-07-01' AND '1997-07-31' " +
                "AND r.producto LIKE '%queso%'");
    }

    /**
     * Ejecuta la consulta HQL dada y muestra los resultados.
     *
     * @param hqlQuery Consulta HQL a ejecutar.
     */
    private static void executeAndPrintResult(String hqlQuery) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                List<Object[]> result = session.createQuery(hqlQuery).list();

                System.out.println("\nResultados de la consulta:");
                for (Object[] row : result) {
                    for (Object col : row) {
                        System.out.print(col + "\t");
                    }
                    System.out.println();
                }

                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
    }
}
