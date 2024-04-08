package com.nttdata.spring.repository;

/**
 * Formación - Spring - Ejemplos
 * 
 * Ejemplo para MVC.
 * 
 * @author NTT Data Sevilla
 *
 */
public class Employee {

	/** ID del empleado */
	private Long employeeId;

	/** Nombre del empleado */
	private String employeeName;

	/**
	 * @return the employeeId
	 */
	public Long getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName
	 *            the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

}
