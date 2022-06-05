package com.qaracter.sprintboot.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qaracter.sprintboot.model.Alumnos;

public interface AlumnosRepository extends JpaRepository<Alumnos, Integer> {
	
	//CRUD
	//int save(Alumnos alumno);
	//int update(Alumnos alumno);
	//int deleteById(Integer id);
	

	//General query
	//List<Alumnos> findAll();
	List<Alumnos> FindByName(String nombre);
	List<Alumnos> FindByNacimiento(String fechaNacimiento);
	List<Alumnos> findByNameContaining(String name);
  
}

