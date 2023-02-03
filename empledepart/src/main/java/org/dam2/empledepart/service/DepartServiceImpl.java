package org.dam2.empledepart.service;

import java.util.List;
import java.util.Optional;

import org.dam2.empledepart.modelo.Depart;
import org.dam2.empledepart.modelo.Emple;
import org.dam2.empledepart.repository.DepartRepository;
import org.dam2.empledepart.repository.EmpleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartServiceImpl implements IDepartService{

	@Autowired
	private DepartRepository daoDepart;
	
	@Override
	public boolean insert(Depart depart) {

		boolean exito = false;
		
		if (!daoDepart.existsById(depart.getCodDepto()))
		{
			daoDepart.save(depart);
			exito = true;
		}
		
		return exito;
		
	}

	@Override
	public boolean update(Depart depart) {

		boolean exito = false;

		if (daoDepart.existsById(depart.getCodDepto())) {
			daoDepart.save(depart);
			exito = true;
		}

		return exito;
		
	}

	@Override
	public boolean delete(String id) {

		boolean exito = false;

		if (daoDepart.existsById(id)) {
			daoDepart.deleteById(id);
			exito = true;
		}

		return exito;
		
	}

	@Override
	public List<Depart> findAll() {
		return (List<Depart>) daoDepart.findAll();
	}

	@Override
	public Optional<Depart> findByNif(String nif) {
		return daoDepart.findById(nif);
	}

}
