package com.nttdata.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Formación - Spring - Ejemplos
 * 
 * Ejemplo de mapeos duplicados (con C1) hacia controladores.
 * 
 * @author NTT Data Sevilla
 *
 */
@Controller
@RequestMapping("/home/es/")
public class Controller3 {

//	/**
//	 * Ejemplo de controlador duplicado.
//	 * 
//	 * Capta cualquier solicitud a /home/es/saludos
//	 * 
//	 * Error: Ambiguous mapping (éste método dará conflicto con oneRegards() por duplicidad)
//	 * 
//	 * @return String
//	 */
//	@GetMapping("/saludos")
//	public String threeRegards() {
//
//		// Respuesta.
//		final String responseBody = "SOY CONTROLADOR 3 MÉTODO threeRegards()";
//		System.out.println(responseBody);
//
//		return responseBody;
//	}

}
