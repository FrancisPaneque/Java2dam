package com.nttdata.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

/**
 * Formación - Spring - Ejemplos
 * 
 * Ejemplo de obtención de parámetros en controladores.
 * 
 * @author NTT Data Sevilla
 *
 */
@Controller
@RequestMapping("/home/five/{viewID}")
public class Controller5 {

	/**
	 * Ejemplo de obtención por parámetro de URL.
	 * 
	 * Capta cualquier solicitud a /home/five/{viewID}/{name}/
	 * 
	 * @return @ResponseBody String
	 */
	@RequestMapping(path = "{name}", method = RequestMethod.GET)
	public @ResponseBody String fiveRegards(@PathVariable String viewID, @PathVariable String name) {

		// Respuesta.
		String responseBody = "Sin saludo";

		if (StringUtils.equals(viewID, "saludoFormal")) {
			responseBody = "Hola " + name + ", por favor, disfrute de nuestra aplicación.";
		} else {
			responseBody = "¡Ey! " + name + " ¿qué pasa? ¡Dale caña!";
		}

		System.out.println(responseBody);

		return responseBody;
	}

}
