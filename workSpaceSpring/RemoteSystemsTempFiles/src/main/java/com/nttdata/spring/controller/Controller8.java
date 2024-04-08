package com.nttdata.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Formación - Spring - Ejemplos
 * 
 * Ejemplo de redirección entre controladores.
 * 
 * @author NTT Data Sevilla
 *
 */
@Controller
@RequestMapping("/home/eight")
public class Controller8 {

	/**
	 * Ejemplo de redirección entre controladores.
	 * 
	 * Capta cualquier solicitud a /home/eight/
	 * 
	 * @return @ResponseBody String
	 */
	@GetMapping()
	public @ResponseBody String eightRegards() {

		// Respuesta.
		final String responseBody = "HOLA SOY CONTROLADOR 8 MÉTODO eightRegards() ¡GRACIAS CONTROLADOR 7!";
		System.out.println(responseBody);

		return responseBody;
	}

}
