package com.nttdata.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Formación - Spring - Ejemplos
 * 
 * Ejemplo de mapeos hacia controladores.
 * 
 * @author NTT Data Sevilla
 *
 */
@Controller
@RequestMapping("/home/es/")
public class Controller1 {

	/**
	 * Ejemplo de solicitud sin formato de salida.
	 * 
	 * Capta cualquier solicitud a /home/es/saludos
	 * 
	 * @return @ResponseBody String
	 */
	@GetMapping("/saludos")
	public @ResponseBody String oneRegards() {

		// Respuesta.
		final String responseBody = "SOY CONTROLADOR 1 MÉTODO oneRegards()";
		System.out.println(responseBody);

		return responseBody;
	}

	@GetMapping("/*")
	public @ResponseBody String rootRegards() {

		// Respuesta.
		final String responseBody = "SOY CONTROLADOR 1 MÉTODO rootRegards()";
		System.out.println(responseBody);

		return responseBody;
	}

	/**
	 * Ejemplo de solicitud con respuesta en formato HTML.
	 * 
	 * Capta cualquier solicitud a /home/es/saludosListado
	 * 
	 * @return @ResponseBody String
	 */
	@GetMapping("/saludosListado")
	public @ResponseBody String oneRegardsList() {

		// Respuesta.
		final String responseBody = "<ul><li>SOY</li><li>CONTROLADOR</li><li>1</li><li>MÉTODO</li><li>oneRegardsList()</li></ul>";
		System.out.println(responseBody);

		return responseBody;
	}

	/**
	 * Ejemplo de solicitud con respuesta hacia vista.
	 * 
	 * Capta cualquier solicitud a /home/es/saludosVista
	 * 
	 * @return String
	 */
	@GetMapping("/saludosVista")
	public String oneRegardsView() {

		// Respuesta.
		final String responseBody = "/showRegards.html";
		System.out.println(responseBody);

		return responseBody;
	}

}
