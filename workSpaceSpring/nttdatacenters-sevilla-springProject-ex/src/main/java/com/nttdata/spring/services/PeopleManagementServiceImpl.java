package com.nttdata.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nttdata.spring.repository.Employee;

/**
 * Formación - Spring - Ejemplos
 * 
 * Ejemplo de acoplamiento e inyección por @Autowired
 * 
 * @author NTT Data Sevilla
 *
 */
@Service
public class PeopleManagementServiceImpl implements PeopleManagementServiceI {

	@Override
	public List<Employee> getAllEmployees() {
		// Método simulado.
		return null;
	}

}
