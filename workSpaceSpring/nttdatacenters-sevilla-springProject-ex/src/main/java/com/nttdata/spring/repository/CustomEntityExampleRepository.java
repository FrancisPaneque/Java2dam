package com.nttdata.spring.repository;

import java.util.List;

/**
 * Formación - Spring - Ejemplos
 * 
 * Ejemplo de repositorio personalizado de Spring Data.
 * 
 * @author NTT Data Sevilla
 *
 */
public interface CustomEntityExampleRepository {

	/**
	 * Consulta programática con JPA Criteria.
	 * 
	 * @return List<EntityExample>
	 */
	public List<EntityExample> exampleCriteriaQuery();

}
