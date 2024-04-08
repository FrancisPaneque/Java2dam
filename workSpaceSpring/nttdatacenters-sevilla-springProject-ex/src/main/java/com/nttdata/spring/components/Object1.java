package com.nttdata.spring.components;

import org.springframework.stereotype.Component;

/**
 * Formación - Spring - Ejemplos
 * 
 * Objeto 1 - Ejemplo lazy.
 * 
 * @author NTT Data Sevilla
 *
 */
@Component
public class Object1 {

	/**
	 * Constructor.
	 */
	public Object1() {
		System.out.println("Soy objeto 1 - He sido creado.");
	}

	/**
	 * Imprime un saludo.
	 */
	public void imHere() {
		System.out.println("Soy objeto 1 - Hola mundo.");
	}

}
