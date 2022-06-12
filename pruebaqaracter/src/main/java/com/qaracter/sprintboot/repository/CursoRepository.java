package com.qaracter.sprintboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qaracter.sprintboot.model.Curso;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
	
	//CRUD
	//int save(Alumnos alumno);
	//int update(Alumnos alumno);
	//int deleteById(Integer id);
	
	//Specific query
	//Optional <Alumnos> FindById(Integer id);
	//long count();

	//General query
	//List<Alumnos> findAll();
	List<Curso> FindByName(String nombre);
	List<Curso> findAllByNameContaining(String name);
  
}