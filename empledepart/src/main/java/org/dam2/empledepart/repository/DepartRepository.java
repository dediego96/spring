package org.dam2.empledepart.repository;

import java.util.List;

import org.dam2.empledepart.modelo.Depart;
import org.dam2.empledepart.modelo.Emple;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface DepartRepository extends CrudRepository<Depart,String> {


	//	7.	Listar el nombre de los departamentos, ordenado por nombre

	@Query("Select d.nombreDepto FROM Depart d ORDER BY d.ciudad")
	public List<String> listarNombresOrdenados();
	
}
