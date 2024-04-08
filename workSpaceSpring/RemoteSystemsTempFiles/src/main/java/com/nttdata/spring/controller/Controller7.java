package com.nttdata.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Formación - Spring - Ejemplos
 * 
 * Ejemplo de redirección entre controladores.
 * 
 * @author NTT Data Sevilla
 *
 */
@Controller
@RequestMapping("/home/seven/")
public class Controller7 {

	/**
	 * Ejemplo de redirección entre controladores.
	 * 
	 * Capta cualquier solicitud a /home/seven/
	 * 
	 * @return String
	 */
	@GetMapping()
	public String sevenRegards() {

		// Respuesta.
		final String responseBody = "HOLA SOY CONTROLADOR 7 MÉTODO sevenRegards()";
		System.out.println(responseBody);

		return "redirect:./holaManolito";
	}

	@GetMapping("holaManolito")
	public String holaManolito() {

		// Respuesta.
		final String responseBody = "HOLA SOY CONTROLADOR 7 MÉTODO holaManolito()";
		System.out.println(responseBody);

		return "redirect:../eight";
	}
}
