package com.nttdata.spring.repository;

/**
 * Formación - Spring - Ejemplos
 * 
 * Ejemplo para MVC.
 * 
 * @author NTT Data Sevilla
 *
 */
public class Recipe {

	/** Descriptión */
	private String description;

	/**
	 * Constructor.
	 * 
	 * @param description
	 */
	public Recipe(final String description) {
		this.description = description;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
