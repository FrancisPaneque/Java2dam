package com.nttdata.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
public class SystemManagementServiceImpl implements SystemManagementServiceI {

	/** Servicio: gestión de contabilidad */
	@Autowired
	private AccountingManagementServiceI accountingService;

	/** Servicio: gestión de personas */
	@Autowired
	private PeopleManagementServiceI peopleService;

	// Ejemplo de inyección acoplada. Mala práctica.
	// /** Servicio: gestión de contabilidad */
	// private EverisAccountingManagementServiceI accountingService = new EverisAccountingManagementServiceImpl();
	//
	// /** Servicio: gestión de personas */
	// private EverisPeopleManagementServiceI peopleService = new EverisPeopleManagementServiceImpl();

	// /**
	// * Método constructor.
	// *
	// * Ejemplo de acoplamiento.
	// *
	// * Esta misma situación podría multiplicarse exponencialmente por número de dependencias anidadas.
	// *
	// *
	// * @param aS
	// * @param pS
	// */
	// public EverisSystemManagementServiceImpl(EverisAccountingManagementServiceImpl aS, EverisPeopleManagementServiceImpl pS) {
	// this.accountingService = aS;
	// this.peopleService = pS;
	// }

	@Override
	public void checkMonthlyExpenditure(String month) {

		// 1. Obtención de los empleados.
		final List<Employee> employeesList = peopleService.getAllEmployees();

		// 2. Obtención de contratos en función de los empleados.
		final List<Contract> contractsList = accountingService.getContractsByEmployee(employeesList);

		// 3. Algoritmo de cálculo de nónimas.
		if (!CollectionUtils.isEmpty(contractsList)) {
			for (Contract contract : contractsList) {
				System.out.println(contract.toString());
			}
		}

	}

}
