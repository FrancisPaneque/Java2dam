package main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import NM.*;
import utils.HibernateUtil;

public class App {

    public static void main(String[] args) {

        // Crear algunos estudiantes y cursos
        Estudiante estudiante1 = new Estudiante();
        estudiante1.setNombre("Estudiante 1");

        Estudiante estudiante2 = new Estudiante();
        estudiante2.setNombre("Estudiante 2");

        Curso curso1 = new Curso();
        curso1.setNombre("Curso 1");

        Curso curso2 = new Curso();
        curso2.setNombre("Curso 2");

        // Asignar cursos a estudiantes y estudiantes a cursos
        estudiante1.agregarCurso(curso1);
        estudiante2.agregarCurso(curso1);
        estudiante2.agregarCurso(curso2);

        // Guardar los estudiantes y cursos en la base de datos
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Guardar estudiantes y cursos
            session.save(estudiante1);
            session.save(estudiante2);
            session.save(curso1);
            session.save(curso2);

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }

        // Cerrar la fábrica de sesiones al finalizar la aplicación
        HibernateUtil.shutdown();
    }
}
