package com.qaracter.sprintboot.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.qaracter.sprintboot.model.Alumno;
@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
	
	//CRUD
	//int save(Alumnos alumno);
	//int update(Alumnos alumno);
	//int deleteById(Integer id);
	

	//General query
	//List<Alumnos> findAll();
	List<Alumno> FindByName(String nombre);
	List<Alumno> FindByNacimiento(String fechaNacimiento);
	List<Alumno> findAllByNameContaining(String name);
  
}

