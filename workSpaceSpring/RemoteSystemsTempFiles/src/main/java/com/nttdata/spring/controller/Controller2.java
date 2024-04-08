package com.nttdata.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Formación - Spring - Ejemplos
 * 
 * Ejemplo de mapeos duplicados hacia controladores.
 * 
 * @author NTT Data Sevilla
 *
 */
@Controller
@RequestMapping("/home/en")
public class Controller2 {

	/**
	 * Capta cualquier solicitud a /home/en/*
	 * 
	 * @return String
	 */
	@RequestMapping(path = "/*", method = RequestMethod.GET)
	public @ResponseBody String twoFullRegards() {

		// Respuesta.
		final String responseBody = "SOY CONTROLADOR 2 MÉTODO twoFullRegards()";
		System.out.println(responseBody);

		return responseBody;
	}

//	/**
//	 * Ejemplo de solicitud con método duplicado.
//	 * 
//	 * Capta cualquier solicitud a /home/en/*
//	 * 
//	 * Conjunción RequestMapping + Método GET.
//	 * 
//	 * Error: Ambiguous mapping (éste método dará conflicto con twoFullRegards() por duplicidad)
//	 * 
//	 * @return @ResponseBody String
//	 */
//	@GetMapping("/*")
//	public @ResponseBody String twoRegards() {
//
//		// Respuesta.
//		final String responseBody = "SOY CONTROLADOR 2 MÉTODO twoRegards()";
//		System.out.println(responseBody);
//
//		return responseBody;
//	}

}
