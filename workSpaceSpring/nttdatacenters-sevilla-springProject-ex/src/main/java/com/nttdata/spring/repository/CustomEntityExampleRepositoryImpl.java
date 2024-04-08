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
public class CustomEntityExampleRepositoryImpl implements CustomEntityExampleRepository {

	@Override
	public List<EntityExample> exampleCriteriaQuery() {
		// Método simulado.
		return null;
	}

}
