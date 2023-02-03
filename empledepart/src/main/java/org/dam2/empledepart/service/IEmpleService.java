package org.dam2.empledepart.service;

import java.util.List;
import java.util.Optional;

import org.dam2.empledepart.modelo.Emple;

public interface IEmpleService {

	public boolean insert (Emple cliente);
	
	public boolean update (Emple cliente);
	
	public boolean delete (String id);
	
	public List<Emple> findAll ();
	
	public Optional <Emple> findByNif (String nif);	

	
}
