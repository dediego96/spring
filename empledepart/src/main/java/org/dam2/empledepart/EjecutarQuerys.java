package org.dam2.empledepart;

import org.dam2.empledepart.modelo.Depart;
import org.dam2.empledepart.repository.DepartRepository;
import org.dam2.empledepart.repository.EmpleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 2)
public class EjecutarQuerys implements CommandLineRunner {

	@Autowired
	private EmpleRepository empleDao;
	
	@Autowired
	private DepartRepository departDao;

	@Override
	public void run(String... args) throws Exception {

		queys();
	}

	private void queys() {

		empleDao.buscarNombreYSal().stream().
			map(a -> a[0] + "" + a[1]).
			forEach(System.out::println);

		empleDao.buscarNombreYSalz().stream().	
			map(t -> t.get(0) + ", " + t.get(1)).
			forEach(System.out::println);
		
		departDao.listarNombresOrdenados().stream().
		forEach(System.out::println);
		
		empleDao.findByDepto(Depart.builder().codDepto("2000").build()).stream().
			forEach(System.out::println);;

	}

}
