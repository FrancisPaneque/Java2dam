package main;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

import utils.*;

public class Main {
		
    public static void main(String[] args) {
    	
    	// Abro sesi�n
    	Session session = HibernateUtil.getSession();
    	try {
    					
            // Llama a los metodos 
    	   System.out.println("1");
           HibernateQueries.obtenerProductosConLetraQ(session);
           System.out.println("2");
           HibernateQueries.pedidosMayo1997(session);
           System.out.println("3");
           HibernateQueries.detallesPedidos10285o10298(session);
           System.out.println("4");
           HibernateQueries.facturacionPorMes(session);
           System.out.println("5");
           HibernateQueries.pedidosDeNancy(session);
           System.out.println("6");
           HibernateQueries.pedidosDeAnton(session);
           System.out.println("7");
           HibernateQueries.productosPorCategoriaPrecioMedio(session);
           System.out.println("8");
           HibernateQueries.pedidosConProductosCategoria2o3(session);
           System.out.println("9");
           HibernateQueries.clientesQuePidieronQuesoJulio1997(session);
           

        } catch (Throwable ex) {
            System.err.println("Error al inicializar la SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        } finally {
        	HibernateUtil.closeSession();
        }
    }
    
}