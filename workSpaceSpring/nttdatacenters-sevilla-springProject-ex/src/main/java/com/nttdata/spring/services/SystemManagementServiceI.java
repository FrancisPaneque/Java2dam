package com.nttdata.spring.services;

/**
 * Formación - Spring - Ejemplos
 * 
 * Ejemplo de acoplamiento e inyección por @Autowired
 * 
 * @author NTT Data Sevilla
 *
 */
public interface SystemManagementServiceI {

	/**
	 * Comprueba el gasto mensual.
	 * 
	 * @param month
	 */
	public void checkMonthlyExpenditure(final String month);

}
