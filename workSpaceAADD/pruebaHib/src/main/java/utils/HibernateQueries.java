package utils;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateQueries {
	

    private static SessionFactory factory;
    
	// Método 1
    public void productosConLetraQ() {
        try (Session session = factory.openSession()) {
            String hql = "SELECT c.categoria, p.producto FROM Categorias c INNER JOIN Productos p " +
                         "ON p.categoria.id = c.id WHERE p.producto LIKE '%q%' ORDER BY c.categoria, p.producto";
            Query query = session.createQuery(hql);
            List<Object[]> results = query.list();
            // Trabaja con los resultados
        }
    }

    // Método 2
    public void pedidosMayo1997() {
        try (Session session = factory.openSession()) {
            String hql = "SELECT p.id as NumeroPedido, c.pais, p.fechaPedido FROM Pedidos p " +
                         "INNER JOIN p.cliente c WHERE p.fechaPedido BETWEEN '1997-05-01' AND '1997-05-31' " +
                         "ORDER BY p.fechaPedido, p.id";
            Query query = session.createQuery(hql);
            List<Object[]> results = query.list();
            // Trabaja con los resultados
        }
    }

    // Método 3
    public void detallesPedidos10285o10298() {
        try (Session session = factory.openSession()) {
            String hql = "SELECT d.pedido.id, p.fechaPedido, d.cantidad, s.producto, d.precioUnidad " +
                         "FROM Pedidos p INNER JOIN p.detalles d INNER JOIN d.producto s " +
                         "WHERE p.id IN (10285, 10298) ORDER BY p.id, p.fechaPedido";
            Query query = session.createQuery(hql);
            List<Object[]> results = query.list();
            // Trabaja con los resultados
        }
    }

    // Método 4
    public void facturacionPorMes() {
        try (Session session = factory.openSession()) {
            String hql = "SELECT YEAR(p.fechaPedido) as ano, MONTH(p.fechaPedido) as mes, " +
                         "SUM(d.cantidad * d.precioUnidad * (1 - d.descuento)) as total " +
                         "FROM Pedidos p INNER JOIN p.detalles d GROUP BY YEAR(p.fechaPedido), MONTH(p.fechaPedido) ORDER BY total";
            Query query = session.createQuery(hql);
            List<Object[]> results = query.list();
            // Trabaja con los resultados
        }
    }
    
 // Método 5
	/*
	 * public void pedidosDeNancy() { try (Session session = factory.openSession())
	 * { String hql =
	 * "FROM Pedidos WHERE empleado.id = (SELECT id FROM Empleados WHERE nombre = 'Nancy')"
	 * ; Query query = session.createQuery(hql); List<Pedidos> results =
	 * query.list(); // Trabaja con los resultados } }
	 */

    // Método 6
	/*
	 * public void pedidosDeAnton() { try (Session session = factory.openSession())
	 * { String hql =
	 * "FROM Pedidos WHERE cliente.id = (SELECT id FROM Clientes WHERE codigo = 'ANTON')"
	 * ; Query query = session.createQuery(hql); List<Pedidos> results =
	 * query.list(); // Trabaja con los resultados } }
	 */

    // Método 7
    public void productosPorCategoriaPrecioMedio() {
        try (Session session = factory.openSession()) {
            String hql = "SELECT c.categoria, COUNT(p.id), AVG(p.precioUnidad) as precioMedio " +
                         "FROM Productos p LEFT JOIN p.categoria c GROUP BY c.categoria";
            Query query = session.createQuery(hql);
            List<Object[]> results = query.list();
            // Trabaja con los resultados
        }
    }

    // Método 8
    public void pedidosConProductosCategoria2o3() {
        try (Session session = factory.openSession()) {
            String hql = "SELECT DISTINCT d.pedido.id " +
                         "FROM Detalles d WHERE d.producto.id IN (SELECT p.id FROM Productos p WHERE p.categoria.id IN (2, 3)) " +
                         "ORDER BY d.pedido.id";
            Query query = session.createQuery(hql);
            List<Integer> results = query.list();
            // Trabaja con los resultados
        }
    }

    // Método 9
    public void clientesQuePidieronQuesoJulio1997() {
        try (Session session = factory.openSession()) {
            String hql = "SELECT DISTINCT c.empresa " +
                         "FROM Clientes c INNER JOIN c.pedidos p INNER JOIN p.detalles d INNER JOIN d.producto r " +
                         "WHERE p.fechaPedido BETWEEN '1997-07-01' AND '1997-07-31' AND r.producto LIKE '%queso%'";
            Query query = session.createQuery(hql);
            List<String> results = query.list();
            // Trabaja con los resultados
        }
    }
}
