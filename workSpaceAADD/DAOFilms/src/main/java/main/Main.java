package main;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import dao.*;
import models.*;
import java.util.List;

import utils.*;

public class Main {
		
	public static void main(String[] args) {
        // Obtener la sesión de Hibernate utilizando HibernateUtil
        Session session = HibernateUtil.getSession();

        // Crear instancia de PeliculaDaoImp
        PeliculaDaoImpl peliculaDao = new PeliculaDaoImpl(session);
        
        // Crear una nueva película
        Pelicula nuevaPelicula = new Pelicula();
        nuevaPelicula.setTitulo("Ejemplo Película");
        nuevaPelicula.setDirector("Director de Prueba");
        nuevaPelicula.setAnio("2022");
        
        // Agregar la película a la base de datos
        peliculaDao.insertPelicula(nuevaPelicula);
        
        // Obtener la película por su titulo
        Pelicula peliculaObtenida = peliculaDao.getPeliculaByTitulo(nuevaPelicula.getTitulo());
        System.out.println("Película obtenida: " + peliculaObtenida);

     // Crear instancia de UsuarioDaoImpl
        UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl(session);

        // Crear algunos usuarios ficticios
        Usuario usuario1 = new Usuario("usuario1", "usuario1@example.com", "contraseña1");
        Usuario usuario2 = new Usuario("usuario2", "usuario2@example.com", "contraseña2");

        // Insertar usuarios
        usuarioDao.insertUsuario(usuario1);
        usuarioDao.insertUsuario(usuario2);

        // Actualizar un usuario
        usuario1.setCorreo("usuario1_actualizado@example.com");
        usuarioDao.updateUsuario(usuario1);

        // Obtener un usuario por nombre
        String nombreUsuario = "usuario2";
        Usuario usuarioObtenido = usuarioDao.getUsuarioByName(nombreUsuario);
        if (usuarioObtenido != null) {
            System.out.println("Usuario encontrado por nombre " + nombreUsuario + ": " + usuarioObtenido);
        } else {
            System.out.println("No se encontró ningún usuario con el nombre " + nombreUsuario);
        }

        // Verificar existencia por nombre
        String nombreAverificar = "usuario3"; // Usuario ficticio que no existe
        boolean existe = usuarioDao.existByName(nombreAverificar);
        if (existe) {
            System.out.println("El usuario con nombre " + nombreAverificar + " existe.");
        } else {
            System.out.println("El usuario con nombre " + nombreAverificar + " no existe.");
        }
        
        // Cerrar la sesión de Hibernate utilizando HibernateUtil
        HibernateUtil.closeSession();
    }
    
}