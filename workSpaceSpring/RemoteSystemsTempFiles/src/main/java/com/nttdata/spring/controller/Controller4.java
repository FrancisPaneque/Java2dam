package com.nttdata.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Formación - Spring - Ejemplos
 * 
 * Ejemplo de obtención de parámetros en controladores.
 * 
 * @author NTT Data Sevilla
 *
 */
@Controller
@RequestMapping("/home/four")
public class Controller4 {

	/**
	 * Ejemplo básico de solicitud sin parámetros.
	 * 
	 * Capta cualquier solicitud a /home/four/getExample
	 * 
	 * @return @ResponseBody String
	 */
	@RequestMapping(path = "/getExample", method = RequestMethod.GET)
	public @ResponseBody String fourGetRegards() {

		// Respuesta.
		final String responseBody = "SOY CONTROLADOR 4 MÉTODO fourGetRegards()";
		System.out.println(responseBody);

		return responseBody;
	}

	/**
	 * Ejemplo de solicitud con parámetros obligatorios.
	 * 
	 * Capta cualquier solicitud a /home/es/four/getParamsExample + parámetros obligatorios.
	 * 
	 * @param firstParam
	 * @param secondParam
	 * @return @ResponseBody String
	 */
	@RequestMapping(value = "/fourGetParamsRegards", method = RequestMethod.GET, params = { "firstParam", "secondParam" })
	public @ResponseBody String fourGetParamsRegards(@RequestParam("firstParam") String firstParam, @RequestParam("secondParam") String secondParam) {

		// Respuesta.
		final String responseBody = "SOY CONTROLADOR 4 MÉTODO fourGetParamsRegards() Y MIS PARÁMETROS SON: " + firstParam + " Y " + secondParam;
		System.out.println(responseBody);

		return responseBody;
	}

	/**
	 * Ejemplo de parámetros opcionales.
	 * 
	 * Capta cualquier solicitud a /home/es/four/getParamsExample2 + parámetros opcionales.
	 * 
	 * @param firstParam
	 * @param secondParam
	 * @return @ResponseBody String
	 */
	@RequestMapping(value = "/fourGetParamsRegards2", method = RequestMethod.GET)
	public @ResponseBody String fourGetParamsRegards2(@RequestParam(name = "firstParam", required = false) String firstParam,
	        @RequestParam("secondParam") String secondParam) {

		// Respuesta.
		final String responseBody = "SOY CONTROLADOR 4 MÉTODO fourGetParamsRegards() Y MIS PARÁMETROS SON: " + firstParam + " Y " + secondParam;
		System.out.println(responseBody);

		return responseBody;
	}

	/**
	 * Ejemplo de parámetros no permitidos.
	 * 
	 * Capta cualquier solicitud a /home/es/four/getParamsExample3 + parámetros prohibidos.
	 * 
	 * @param firstParam
	 * @return @ResponseBody String
	 */
	@RequestMapping(value = "/fourGetParamsRegards3", method = RequestMethod.GET, params = { "!secondParam" })
	public @ResponseBody String fourGetParamsRegards3(@RequestParam(name = "firstParam") String firstParam) {

		// Respuesta.
		final String responseBody = "SOY CONTROLADOR 4 MÉTODO fourGetParamsRegards() Y MI PARÁMETROS ES: " + firstParam;
		System.out.println(responseBody);

		return responseBody;
	}

}
