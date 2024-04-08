package com.nttdata.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Formación - Spring - Ejemplos
 * 
 * Ejemplo de excepciones en controladores.
 * 
 * @author NTT Data Sevilla
 *
 */
@ControllerAdvice
public class Controller10 {

	/**
	 * Ejemplo de manejo de excepciones.
	 * 
	 * Capta cualquier excepción en los métodos de cualquier controlador.
	 * 
	 * @return @ResponseBody String
	 */
	@ExceptionHandler()
	public @ResponseBody String handleException(HttpServletRequest req, Exception e) {

		// Respuesta.
		final String responseBody = "HOLA SOY EL CONTROLADOR DE EXCEPCIONES. ¡CUIDADO AHÍ!";
		System.out.println(responseBody);

		return responseBody;
	}

}
