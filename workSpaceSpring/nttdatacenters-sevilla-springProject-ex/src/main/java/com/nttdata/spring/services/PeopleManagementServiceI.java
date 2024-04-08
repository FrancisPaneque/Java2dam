package com.nttdata.spring.services;

import java.util.List;

import com.nttdata.spring.repository.Employee;

/**
 * Formación - Spring - Ejemplos
 * 
 * Ejemplo de acoplamiento e inyección por @Autowired
 * 
 * @author NTT Data Sevilla
 *
 */
public interface PeopleManagementServiceI {

	/**
	 * Obtención de todos los empleados de la empresa.
	 * 
	 * @return List<Employee>
	 */
	public List<Employee> getAllEmployees();

}
