package com.nttdata.spring.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Formación - Spring - Ejemplos
 * 
 * Implementaciones (hijo)
 * 
 * Ejemplo de @Qualifier y @Primary
 * 
 * @author NTT Data Sevilla
 *
 */
@Service("raulService")
@Primary
public class BoyServiceImpl implements MotherServiceI {

	@Override
	public void whoIAm() {
		System.out.println("Hola, soy Raúl.");
	}

}
