package com.nttdata.spring.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Formación - Spring - Ejemplos
 * 
 * Ejemplo de excepciones en controladores.
 * 
 * @author NTT Data Sevilla
 *
 */
@Controller
@RequestMapping("/home/nine")
public class Controller9 {

	/**
	 * Ejemplo de manejo de excepciones.
	 * 
	 * Capta cualquier solicitud a /home/nine/{key}
	 * 
	 * @return @ResponseBody String
	 * @throws Exception
	 */
	@RequestMapping(path = "{key}", method = RequestMethod.GET)
	public @ResponseBody String nineRegards(@PathVariable String key) throws Exception {

		// Respuesta.
		String responseBody;

		if (key.equals("Error")) {
			throw new IOException();
		} else if (key.equals("ErrorGeneral")) {
			throw new Exception();
		} else {

			responseBody = "HOLA SOY CONTROLADOR 9 MÉTODO nineRegards()";
			System.out.println(responseBody);
		}

		return responseBody;
	}

	/**
	 * Ejemplo de manejo de excepciones.
	 * 
	 * Capta cualquier excepción en los métodos del controlador.
	 * 
	 * @return @ResponseBody String
	 */
	@ExceptionHandler(IOException.class)
	public @ResponseBody String handleException() {

		// Respuesta.
		final String responseBody = "HOLA SOY CONTROLADOR 9 ¡¡¡ERROR!!! ¡¡USTED NO DEBE ESTAR AQUÍ!!";
		System.out.println(responseBody);

		return responseBody;
	}

}
