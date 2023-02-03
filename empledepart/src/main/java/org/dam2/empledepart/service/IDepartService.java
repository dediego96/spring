package org.dam2.empledepart.service;

import java.util.List;
import java.util.Optional;

import org.dam2.empledepart.modelo.Depart;


public interface IDepartService {

	public boolean insert (Depart cliente);
	
	public boolean update (Depart cliente);
	
	public boolean delete (String id);
	
	public List<Depart> findAll ();
	
	public Optional <Depart> findByNif (String nif);

	
}
