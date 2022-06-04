package com.qaracter.sprintboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qaracter.sprintboot.model.Cursos;

public interface CursosRepository extends JpaRepository<Cursos, Long> {
	
	//CRUD
	//int save(Alumnos alumno);
	//int update(Alumnos alumno);
	//int deleteById(Integer id);
	
	//Specific query
	//Optional <Alumnos> FindById(Integer id);
	//long count();

	//General query
	//List<Alumnos> findAll();
	List<Cursos> FindByName(String nombre);
	List<Cursos> findByNameContaining(String name);
  
}