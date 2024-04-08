package utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import NM.*;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            // Cargar configuración desde hibernate.cfg.xml
            Configuration configuration = new Configuration().configure();

            // Registrar clases de entidad
            configuration.addAnnotatedClass(Estudiante.class);
            configuration.addAnnotatedClass(Curso.class);

            // Construir la fábrica de sesiones
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(registryBuilder.build());

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError("Error al inicializar Hibernate: " + ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Cerrar fábrica de sesiones al cerrar la aplicación
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}