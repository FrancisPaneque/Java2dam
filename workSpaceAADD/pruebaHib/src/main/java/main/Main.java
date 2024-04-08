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
    		
            // Llama a tus métodos aquí
            System.out.println("hola");
            obtenerCategorias(session);

           

        } catch (Throwable ex) {
            System.err.println("Error al inicializar la SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        } finally {
        	HibernateUtil.closeSession();
        }
    }
    
    
    public static void obtenerCategorias(Session session) {
        try {
            String hql = "SELECT c.categoria " +
                         "FROM Categorias c";

            Query query = session.createQuery(hql);
            List<String> resultados = (List<String>) query.list();

            if (resultados != null) {
                for (String categoria : resultados) {
                    System.out.println("Categoría: " + categoria);
                }
            } else {
                System.out.println("No se obtuvieron resultados.");
            }
           // return resultados;
        } catch (Exception e) {
            e.printStackTrace();
        }

        // return null;
    }
}