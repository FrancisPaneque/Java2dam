package com.nttdata.spring.services;

import org.springframework.stereotype.Service;

/**
 * Formación - Spring - Ejemplos
 * 
 * Implementaciones (hija)
 * 
 * Ejemplo de @Qualifier y @Primary
 * 
 * @author NTT Data Sevilla
 *
 */
@Service("ainaraService")
public class GirlServiceImpl implements MotherServiceI {

	@Override
	public void whoIAm() {
		System.out.println("Hola, soy Ainara.");
	}

}
