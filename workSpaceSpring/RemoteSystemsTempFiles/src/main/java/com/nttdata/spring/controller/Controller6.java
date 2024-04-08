package com.nttdata.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nttdata.spring.repository.Employee;

/**
 * Formación - Spring - Ejemplos
 * 
 * Ejemplo de obtención de parámetros en controladores.
 * 
 * @author NTT Data Sevilla
 *
 */
@Controller
@RequestMapping("/home/six")
public class Controller6 {

	/**
	 * Ejemplo de mapeo directo al modelo de datos.
	 * 
	 * Capta cualquier solicitud a /home/six/
	 * 
	 * @return @ResponseBody String
	 */
	@RequestMapping(path = "/employee", method = RequestMethod.GET, params = { "employeeId", "employeeName" })
	public @ResponseBody String sixRegards(@ModelAttribute("employeeView") Employee employee) {

		// Respuesta.
		final String responseBody = "ID: " + employee.getEmployeeId() + " Name: " + employee.getEmployeeName();
		System.out.println(responseBody);

		return responseBody;
	}

}
