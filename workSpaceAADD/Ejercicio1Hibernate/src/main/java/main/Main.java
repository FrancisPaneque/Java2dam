package main;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import utils.*;
import models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

private static String archivo = "prueba/Alumnado_nuevo.txt";
	
	public static void main(String[] args) throws IOException {
		
		// SessionFactory 
		// Generador de sesiones
    	StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
    	SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		
    	// Abro sesion
    	Session session = sf.openSession();
    	
    	// Inicio transaccion
    	session.getTransaction().begin();
    	
    	// Guardamos los datos en la base de datos
    
    	List<SuperUsuario> listaSuperUsuarios = Utilidades.creaSuperUsuarios(archivo);
    	int contador = 0;
    	
    	for (SuperUsuario  usuario : listaSuperUsuarios) {
    		
    		session.save(usuario);
    		// Tras guardar suma uno para el batch
    		contador++;
    		
    		if(contador % 10 == 0) { // como un batch de tamanio 5 
    			//flush de batch de iserts y limpia la memoria
    			session.flush();
    			session.clear();
    			
    			System.out.println("Batch correcto");
    		}
    		
    	}
    	
    	// Commit transaccion
    	session.getTransaction().commit();
    	
    	// Cierro Session y SessionFactory
    	session.close();
    	sf.close();	
	}
}
