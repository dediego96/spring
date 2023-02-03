package org.dam2.empledepart;

import org.dam2.empledepart.service.IDepartService;
import org.dam2.empledepart.service.IEmpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class CargarDatos implements CommandLineRunner {

	@Autowired IEmpleService empleService;
	@Autowired IDepartService departService;
	
	@Override
	public void run(String... args) throws Exception {

		cargarDatos();
		
	}

	private void cargarDatos() {

		System.out.println("\nDepartamentos: \n");
		departService.findAll().stream()
			.map(d -> "\nCod: " + d.getCodDepto() + ", Nombre: " + d.getNombreDepto() + ";").
			forEach(System.out::println);		
	}

}