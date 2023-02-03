package org.dam2.empledepart.service;

import java.util.List;
import java.util.Optional;

import org.dam2.empledepart.modelo.Emple;
import org.dam2.empledepart.repository.EmpleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleServiceImpl implements IEmpleService {

	@Autowired
	private EmpleRepository daoEmple;

	@Override
	public boolean insert(Emple emple) {
		
		boolean exito = false;
		
		if (!daoEmple.existsById(emple.getNidemp()))
		{
			daoEmple.save(emple);
			exito = true;
		}
		
		return exito;
	}

	@Override
	public boolean update(Emple emple) {

		boolean exito = false;

		if (daoEmple.existsById(emple.getNidemp())) {
			daoEmple.save(emple);
			exito = true;
		}

		return exito;

	}

	@Override
	public boolean delete(String id) {
		
		boolean exito = false;

		if (daoEmple.existsById(id)) {
			daoEmple.deleteById(id);
			exito = true;
		}

		return exito;
	}

	@Override
	public List<Emple> findAll() {
		return (List<Emple>) daoEmple.findAll();
	}

	@Override
	public Optional<Emple> findByNif(String nif) {
		return daoEmple.findById(nif);
	}

}

