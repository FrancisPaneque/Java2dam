package com.nttdata.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Formación - Spring - Ejemplos
 * 
 * Ejemplo de repositorio de Spring Data.
 * 
 * @author NTT Data Sevilla
 *
 */
@Repository
public interface EntityExampleRepositoryI extends JpaRepository<EntityExample, Long>, CustomEntityExampleRepository {

	/**
	 * Búsqueda por atributo fieldOne.
	 * 
	 * @param value
	 * @return List<EntityExample>
	 */
	public List<EntityExample> findByFieldOne(final String value);

	/**
	 * Búsqueda por atributos fieldOne y fieldTwo.
	 * 
	 * @param value1
	 * @param value2
	 * @return List<EntityExample>
	 */
	public List<EntityExample> findByFieldOneAndFieldTwo(final String value1, final String value2);

	/**
	 * Búsqueda por atributo fieldDate.
	 * 
	 * @param date
	 * @return List<EntityExample>
	 */
	public List<EntityExample> findByFieldDateBefore(final Date date);

}
