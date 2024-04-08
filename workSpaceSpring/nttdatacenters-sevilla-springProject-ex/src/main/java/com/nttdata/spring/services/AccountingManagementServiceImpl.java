package com.nttdata.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nttdata.spring.repository.Contract;
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
public class AccountingManagementServiceImpl implements AccountingManagementServiceI {

	@Override
	public List<Contract> getContractsByEmployee(List<Employee> employeeList) {
		// Método simulado.
		return null;
	}

}
