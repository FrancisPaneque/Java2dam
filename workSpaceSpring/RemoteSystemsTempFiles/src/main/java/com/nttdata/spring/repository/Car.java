package com.nttdata.spring.repository;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

/**
 * Formación - Spring - Ejemplos
 * 
 * Ejemplo para MVC.
 * 
 * @author NTT Data Sevilla
 *
 */
public class Car {

	/** Matrícula del vehículo */
	@Length(min = 1, max = 8)
	private String carRegistration;

	/** Marca */
	@NotBlank
	private String make;

	/** Modelo */
	private String model;

	/** Referencia de matriculación */
	private String registerRef;

	/**
	 * @return the carRegistration
	 */
	public String getCarRegistration() {
		return carRegistration;
	}

	/**
	 * @param carRegistration
	 *            the carRegistration to set
	 */
	public void setCarRegistration(String carRegistration) {
		this.carRegistration = carRegistration;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make
	 *            the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the registerRef
	 */
	public String getRegisterRef() {
		return registerRef;
	}

	/**
	 * @param registerRef
	 *            the registerRef to set
	 */
	public void setRegisterRef(String registerRef) {
		this.registerRef = registerRef;
	}

}
