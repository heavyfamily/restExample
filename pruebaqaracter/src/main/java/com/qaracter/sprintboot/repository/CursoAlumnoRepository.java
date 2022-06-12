package com.qaracter.sprintboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qaracter.sprintboot.model.CursoAlumno;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoAlumnoRepository extends JpaRepository<CursoAlumno, Integer> {
	//CRUD
		//int save(Alumnos alumno);
		//int update(Alumnos alumno);
		//int deleteById(Integer id);
		

		//General query
		//List<Alumnos> findAll();
		List<CursoAlumno> FindByFechaInscripcion(String fechaInscripcion);
		List<CursoAlumno> findByFechaBaja(String fechaBaja);
		
		List<CursoAlumno> FindByIdCurso(Integer idCurso);
		List<CursoAlumno> findByIdAlumno(Integer idAlumno);
}
