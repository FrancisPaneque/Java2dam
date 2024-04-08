package com.nttdata.spring.components;

import org.springframework.stereotype.Component;

/**
 * Formación - Spring - Ejemplos
 * 
 * Objeto 2 - Ejemplo lazy.
 * 
 * @author NTT Data Sevilla
 *
 */
@Component
public class Object2 {

	/**
	 * Constructor.
	 */
	public Object2() {
		System.out.println("Soy objeto 2 - He sido creado.");
	}

	/**
	 * Imprime un saludo.
	 */
	public void imHere() {
		System.out.println("Soy objeto 2 - Hola mundo.");
	}
	
}
