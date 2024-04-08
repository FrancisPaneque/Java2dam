package com.nttdata.spring.components;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Formación - Spring - Ejemplos
 * 
 * Objeto 3 - Ejemplo lazy.
 * 
 * @author NTT Data Sevilla
 *
 */
@Component
@Lazy
public class Object3 {

	/**
	 * Constructor.
	 */
	public Object3() {
		System.out.println("Soy objeto 3 - He sido creado.");
	}

	/**
	 * Imprime un saludo.
	 */
	public void imHere() {
		System.out.println("Soy objeto 3 - Hola mundo.");
	}

}
