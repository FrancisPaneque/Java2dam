package com.nttdata.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.spring.repository.Recipe;

/**
 * Formación - Spring - Ejemplos
 * 
 * Ejemplo MVC.
 * 
 * @author NTT Data Sevilla
 *
 */
@Controller
@RequestMapping("/home/cocina/")
public class Controller11 {

	/**
	 * Ejemplo de solicitud con respuesta hacia vista.
	 * 
	 * Capta cualquier solicitud a /home/cocina/menuNavidad
	 * 
	 * @return String
	 */
	@GetMapping("menuNavidad")
	public String cookSpaguettis(Model modelAndView) {

		// Creación de platos.
		final Recipe aperitivos = new Recipe("Bombones crocantes de foie y almendras.");
		final Recipe primerPlato = new Recipe("Pierna de cordero rellena de castañas.");
		final Recipe segundoPlato = new Recipe("Solomillo de ternera al vino tinto.");
		
		// TODO: Generación de postres.
		
		// Se añaden al menú.
		List<Recipe> menuNavidad = new ArrayList<Recipe>();
		menuNavidad.add(aperitivos);
		menuNavidad.add(primerPlato);
		menuNavidad.add(segundoPlato);
		
		// Se retorna el menú a la vista y modelo.
		modelAndView.addAttribute("menu", menuNavidad);
		
		return "mostrarMenu";
	}

}
