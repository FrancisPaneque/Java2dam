package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.context.internal.ThreadLocalSessionContext;

/**
 * Utilidad para manejar la configuración y operaciones básicas con Hibernate.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Session session;

    /**
     * Devuelve el objeto Session de Hibernate.
     *
     * @return
     * <ul>
     *   <li>Si la sesión no está creada: la crea y la abre.</li>
     *   <li>Si la sesión está creada: simplemente devuelve la sesión abierta.</li>
     * </ul>
     */
    public static Session getSession() {
        if (sessionFactory == null) {
            session = getSessionFactory().openSession();
        }

        return session;
    }

    /**
     * Cierra el objeto Session de HibernateUtil y el SessionFactory.
     */
    public static void closeSession() {
        Session session = ThreadLocalSessionContext.unbind(sessionFactory);
        if (session != null) {
            session.close();
        }
        closeSessionFactory();
    }

    /**
     * Obtiene o crea el objeto SessionFactory de Hibernate.
     *
     * @return El objeto SessionFactory.
     */
    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // Configuración y construcción del ServiceRegistry y SessionFactory.
            StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
            sessionFactory = new MetadataSources(sr).buildMetadata().buildSessionFactory();
        }
        return sessionFactory;
    }

    /**
     * Cierra el objeto SessionFactory si no está cerrado.
     */
    private static void closeSessionFactory() {
        if ((sessionFactory != null) && (!sessionFactory.isClosed())) {
            sessionFactory.close();
        }
    }

}