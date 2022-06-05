package com.qaracter.sprintboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qaracter.sprintboot.model.CursosAlumnos;


public interface CursosAlumnosRepository extends JpaRepository<CursosAlumnos, Integer> {
	//CRUD
		//int save(Alumnos alumno);
		//int update(Alumnos alumno);
		//int deleteById(Integer id);
		

		//General query
		//List<Alumnos> findAll();
		List<CursosAlumnos> FindByFechaInscripcion(String fechaInscripcion);
		List<CursosAlumnos> findByFechaBaja(String fechaBaja);
		
		List<CursosAlumnos> FindByIdCurso(Integer idCurso);
		List<CursosAlumnos> findByIdAlumno(Integer idAlumno);
}
