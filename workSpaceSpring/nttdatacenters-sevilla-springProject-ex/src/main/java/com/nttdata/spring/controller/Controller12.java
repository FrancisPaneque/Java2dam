package com.nttdata.spring.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import com.nttdata.spring.repository.Car;

/**
 * Formación - Spring - Ejemplos
 * 
 * Ejemplo MVC.
 * 
 * @author NTT Data Sevilla
 *
 */
@Controller
@RequestMapping("/home/car/")
public class Controller12 {

	/**
	 * Ejemplo de solicitud con respuesta hacia vista.
	 * 
	 * Capta cualquier solicitud a /home/car/
	 * 
	 * @return String
	 */
	@GetMapping("/")
	public String newCarForm() {
		return "/newCarView";
	}

	/**
	 * Ejemplo de solicitud con respuesta hacia vista.
	 * 
	 * Resultada al formulario de matriculación.
	 * 
	 * @return String
	 */
	@PostMapping("/createCar")
	public String saveCar(@Valid @ModelAttribute("cochecito") Car newCar, Model model, BindingResult br) {

		// Se establece referencia de matriculación.
		final String carMakeFirstLetter = StringUtils.substring(newCar.getMake(), 0, 1);
		final String carModelFirstLetter = StringUtils.substring(newCar.getModel(), 0, 1);
		final String registerRef = newCar.getCarRegistration() + "-2020-" + carMakeFirstLetter + carModelFirstLetter;
		newCar.setRegisterRef(registerRef);

		// Se retorna actualizado al modelo.
		//model.addAttribute("newCar", newCar);

		return "/showCar";
	}

	@ExceptionHandler(BindException.class)
	public String checkExceptions(BindingResult br) {

		// Resultado
		String output = "";

		// Verificación de errores.
		if (br.hasErrors()) {

			output = "/showErrorView";

		}

		return output;
	}
}
