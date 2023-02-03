package org.dam2.empledepart.repository;

import java.util.List;

import org.dam2.empledepart.modelo.Depart;
import org.dam2.empledepart.modelo.Emple;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface EmpleRepository  extends CrudRepository<Emple,String>  {

	//	3.	Obtener los datos de los empleados con cargo 'Secretaria'.
	public List<Emple> findByCargoEEquals (String cargo);
	
	// Salario y nombre de emples
	@Query("SELECT e.nomemp, e.salEmp FROM Emple e")
	public List<Object[]> buscarNombreYSal();
	
	@Query("SELECT e.nomemp, e.salEmp FROM Emple e")
	public List<Tuple> buscarNombreYSalz();
	
	//Mostrar todos los empleados de un departamento
	public List<Emple> findByDepto (Depart d);
	
	
}
