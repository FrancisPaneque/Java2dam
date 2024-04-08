package utils;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelo_neptuno.Pedidos;

public class HibernateQueries {
	

    private static SessionFactory factory;
    
	// Método 1
    public static List<Object[]> obtenerProductosConLetraQ(Session session) {
        try {
            String hql = "SELECT p, p.categorias " + 
					"FROM Productos p JOIN p.categorias c " + 
					"WHERE p.producto LIKE '%q%' " + 
					"ORDER BY categoria, producto";

            Query query = session.createQuery(hql);

            return (List<Object[]>) query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

 // Método 2
    public static void pedidosMayo1997(Session session) {
        String hql = "SELECT p.id, p.clientes.pais " + 
				"FROM Pedidos p " + 
				"WHERE YEAR(p.fechaPedido) = 1997 AND MONTH(p.fechaPedido) = 5";
        Query query = session.createQuery(hql);
        List<Object[]> results = query.list();
        // Trabaja con los resultados
    }

    // Método 3
    public static void detallesPedidos10285o10298(Session session) {
        String hql = "SELECT d.pedido_id, p.fecha_pedido, d.cantidad, s.producto, d.precio_unidad " +
                "FROM Pedidos p " +
                "JOIN Detalles d ON p.id = d.pedido_id " +
                "JOIN Productos s ON s.id = d.producto_id " +
                "WHERE p.id IN (10285, 10298) " +
                "ORDER BY p.id, p.fecha_pedido";
        Query query = session.createQuery(hql);
        List<Object[]> results = query.list();
        // Trabaja con los resultados
    }

    // Método 4
    public static void facturacionPorMes(Session session) {
        String hql = "SELECT YEAR(p.fechaPedido) as ano, MONTH(p.fechaPedido) as mes, " +
                     "SUM(d.cantidad * d.precioUnidad * (1 - d.descuento)) as total " +
                     "FROM Pedidos p INNER JOIN p.detalles d GROUP BY YEAR(p.fechaPedido), MONTH(p.fechaPedido) ORDER BY total";
        Query query = session.createQuery(hql);
        List<Object[]> results = query.list();
        // Trabaja con los resultados
    }

    // Método 5
    public static void pedidosDeNancy(Session session) {
        String hql = "FROM Pedidos WHERE empleado.id = (SELECT id FROM Empleados WHERE nombre = 'Nancy')";
        Query query = session.createQuery(hql);
        List<Pedidos> results = query.list();
        // Trabaja con los resultados
    }

    // Método 6
    public static void pedidosDeAnton(Session session) {
        String hql = "FROM Pedidos WHERE cliente.id = (SELECT id FROM Clientes WHERE codigo = 'ANTON')";
        Query query = session.createQuery(hql);
        List<Pedidos> results = query.list();
        // Trabaja con los resultados
    }

    // Método 7
    public static void productosPorCategoriaPrecioMedio(Session session) {
        String hql = "SELECT c.categoria, COUNT(p.id), AVG(p.precioUnidad) as precioMedio " +
                     "FROM Productos p LEFT JOIN p.categoria c GROUP BY c.categoria";
        Query query = session.createQuery(hql);
        List<Object[]> results = query.list();
        // Trabaja con los resultados
    }

    // Método 8
    public static void pedidosConProductosCategoria2o3(Session session) {
        String hql = "SELECT DISTINCT d.pedido.id " +
                     "FROM Detalles d WHERE d.producto.id IN (SELECT p.id FROM Productos p WHERE p.categoria.id IN (2, 3)) " +
                     "ORDER BY d.pedido.id";
        Query query = session.createQuery(hql);
        List<Integer> results = query.list();
        // Trabaja con los resultados
    }

    // Método 9
    public static void clientesQuePidieronQuesoJulio1997(Session session) {
        String hql = "SELECT DISTINCT c.empresa " +
                     "FROM Clientes c INNER JOIN c.pedidos p INNER JOIN p.detalles d INNER JOIN d.producto r " +
                     "WHERE p.fechaPedido BETWEEN '1997-07-01' AND '1997-07-31' AND r.producto LIKE '%queso%'";
        Query query = session.createQuery(hql);
        List<String> results = query.list();
        // Trabaja con los resultados
    }
}
