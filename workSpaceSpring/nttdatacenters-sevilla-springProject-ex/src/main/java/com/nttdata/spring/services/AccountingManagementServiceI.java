package com.nttdata.spring.services;

import java.util.List;

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
public interface AccountingManagementServiceI {

	/**
	 * Retorna una lista de contratos por empleado.
	 * 
	 * @param employeeList
	 * @return List<Contract>
	 */
	public List<Contract> getContractsByEmployee(final List<Employee> employeeList);

}
