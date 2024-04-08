package dao;

import java.util.List;

import org.hibernate.Session;

import models.Pelicula;

public interface PeliculaDaoInt extends CommonDaoInt<Pelicula> {
	/**
	 * Devuelve la pelicula que esta en la base de datos con ese titulo
	 * @param titulo de la pelicula que quieres buscar 
	 * @return the pelicula
	 */
	public Pelicula getPeliculaByTitulo(String titulo);

}
