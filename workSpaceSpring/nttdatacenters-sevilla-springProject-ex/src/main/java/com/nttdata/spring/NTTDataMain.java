package com.nttdata.spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

import com.nttdata.spring.components.Object1;
import com.nttdata.spring.components.Object2;
import com.nttdata.spring.components.Object3;
import com.nttdata.spring.repository.EntityExample;
import com.nttdata.spring.repository.EntityExampleRepositoryI;
import com.nttdata.spring.services.MotherServiceI;
import com.nttdata.spring.services.SystemManagementServiceI;

/**
 * Formación - Spring - Ejemplos
 * 
 * Clase principal
 * 
 * @author NTT Data Sevilla
 *
 */
@SpringBootApplication()
public class NTTDataMain implements CommandLineRunner {

	/** Servicio: sistema */
	@Autowired
	private SystemManagementServiceI systemService;

	/** Servicio: hija */
	@Autowired
	@Qualifier("ainaraService")
	private MotherServiceI childService1;

	/** Servicio: hijo */
	@Autowired
	@Qualifier("raulService")
	private MotherServiceI childService2;

	/** Servicio: no especificada IMPL (@Primary) */
	@Autowired
	private MotherServiceI childService3;

	/** Objeto 1 */
	@Autowired
	private Object1 object1;

	/** Objeto 2 */
	@Autowired
	private Object2 object2;

	/** Objeto 3 */
	@Autowired
	@Lazy
	private Object3 object3;

	/** Ejemplo de repositorio */
	@Autowired
	private EntityExampleRepositoryI exampleRepo;

	/**
	 * Método principal.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(NTTDataMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Ejemplo de acoplamiento y solución por Spring.

		// Visualización del gasto mensual.
		final String month = "12";
		systemService.checkMonthlyExpenditure(month);

		// Ejemplo de @Autowired + @Qualifier o @Autowired + @Primary
		childService1.whoIAm();
		childService2.whoIAm();
		childService3.whoIAm();

		// Ejemplo de @Lazy
		object1.imHere();
		object2.imHere();
		object3.imHere();

		// Ejemplo de uso de repositorio.
		final EntityExample en1 = new EntityExample();
		en1.setFieldOne("FO1");
		en1.setFieldTwo("FT1");
		en1.setFieldDate(new Date(123, 1, 13));

		final EntityExample en2 = new EntityExample();
		en2.setFieldOne("FO2");
		en2.setFieldTwo("FT2");
		en2.setFieldDate(new Date(122, 1, 13));

		exampleRepo.save(en1);
		exampleRepo.save(en2);

		System.out.println("Hay añadidos: " + exampleRepo.count() + " registros.");

		System.out.println("Registros anteriores a la fecha de hoy: ");
		final List<EntityExample> results = exampleRepo.findByFieldDateBefore(new Date());
		for (final EntityExample ee : results) {
			System.out.println(ee.getFieldOne());
		}

		// Ejemplo de uso de repositorio personalizado.
		final List<EntityExample> results2 = exampleRepo.exampleCriteriaQuery();
		
	}

}
