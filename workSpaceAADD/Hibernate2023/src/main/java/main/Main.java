package main;

import org.hibernate.Session;
import models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

	public static void main(String[] args) {

		// SessionFactory. Generador de sesiones
    	StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
    	SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		
    	// Abro sesi�n
    	Session session = sf.openSession();
    	
    	// Inicio transacci�n
    	session.getTransaction().begin();
    	
    	// Creaci�n de objetos simples
    	Alumno alumno1 = new Alumno();
    	alumno1.setNombre("Nacho");
    	alumno1.setApellido("Lorenzo");
    	alumno1.setEdad(44);
    	
    	Matricula m = new Matricula();
    	m.setAlumno(alumno1);
    	m.setCampo("AADD");
    	alumno1.setMatricula(m);
    	
    	
    	Alumno alumno2 = new Alumno("PEpe", "Perez", 44);
    	
    	// Guardar objetos en BBDD
    	session.save(alumno1);
    	session.save(alumno2);
    	
    	// Commit transacci�n
    	session.getTransaction().commit();
    	
    	// Cierro Session y SessionFactory
    	session.close();
    	sf.close();
	}
}
