package com.formacionspring.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacionspring.apirest.entity.Cliente;

@Repository
public interface ClienteDao extends CrudRepository<Cliente,Long >{


//	@Query("from Region")
//	public List<region> mostrarRegiones();

}
