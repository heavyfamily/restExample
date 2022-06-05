package com.qaracter.sprintboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qaracter.sprintboot.model.CursosAlumnos;
import com.qaracter.sprintboot.repository.CursosAlumnosRepository;

@CrossOrigin(origins = "http://localhost:8081") //is for configuring allowed origins. Inthis case the angular interface conection
@RestController //annotation is used to define a controller and to indicate that the return value of the methods should be be bound to the web response body
@RequestMapping("/api") // declares that all Apis’ url in the controller will start with /api.
public class CursosAlumnosController {
	@Autowired //– We use @Autowired to inject TutorialRepository bean to local variable.
	  CursosAlumnosRepository cursosAlumnosRepository;
	  @GetMapping("/cursosAlumnos")
	  public ResponseEntity< List<CursosAlumnos> > getAllAlumnos(@RequestParam(required = false) Integer idCurso, Integer idAlumno) {
		  try {
		      List<CursosAlumnos> cursosAlumnos = new ArrayList<CursosAlumnos>();
		      if (idCurso == null && idAlumno == null)
		    	  cursosAlumnosRepository.findAll().forEach(cursosAlumnos::add);
		      else if (idCurso == null)
		    	  cursosAlumnosRepository.findByIdAlumno(idAlumno).forEach(cursosAlumnos::add);
		      else if (idAlumno == null)
		    	  cursosAlumnosRepository.FindByIdCurso(idCurso).forEach(cursosAlumnos::add);

		      if (cursosAlumnos.isEmpty()) {
		    	  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(cursosAlumnos, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		
	  }
	  
	  @GetMapping("/cursosAlumnos/{id}")
	  public ResponseEntity<CursosAlumnos> getAlumnoById(@PathVariable("id") Integer id) {
		  Optional<CursosAlumnos> cursoAlumnoData = cursosAlumnosRepository.findById(id);
		  if (cursoAlumnoData.isPresent()) {
			  return new ResponseEntity<>(cursoAlumnoData.get(), HttpStatus.OK);
		  } else {
			  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }
	  
	  @PostMapping("/cursosAlumnos")
	  public ResponseEntity<CursosAlumnos> createTutorial(@RequestBody CursosAlumnos cursoAlumno) {
		  try {
			  // I use _nomber to diferenciate of other list
		     CursosAlumnos _cursoAlumno = cursosAlumnosRepository.
		    		 save(new CursosAlumnos(cursoAlumno.getIdCurso(), cursoAlumno.getIdAlumno(), cursoAlumno.getFechaInscripcion(), cursoAlumno.getFechaBaja()));
		     return new ResponseEntity<>(_cursoAlumno, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  
	  }
	  
	  @PutMapping("/cursosAlumnos/{id}")
	  public ResponseEntity<CursosAlumnos> updateAlumnos(@PathVariable("id") Integer id, @RequestBody CursosAlumnos cursoAlumno) {
		  Optional<CursosAlumnos> cursoAlumnoData = cursosAlumnosRepository.findById(id);
		    if (cursoAlumnoData.isPresent()) {
		      CursosAlumnos _cursoAlumno = cursoAlumnoData.get();
		      _cursoAlumno.setIdCurso(cursoAlumno.getIdCurso());
		      _cursoAlumno.setIdAlumno(cursoAlumno.getIdAlumno());
		      _cursoAlumno.setFechaInscripcion(cursoAlumno.getFechaInscripcion());
		      _cursoAlumno.setFechaBaja(cursoAlumno.getFechaBaja());
		      return new ResponseEntity<>(cursosAlumnosRepository.save(_cursoAlumno), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
	  }
	  
	  @DeleteMapping("/cursosAlumnos/{id}")
	  public ResponseEntity<HttpStatus> deleteAlumno(@PathVariable("id") Integer id) {
		  try {
		      cursosAlumnosRepository.deleteById(id);
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }
	  
	  @DeleteMapping("/cursosAlumnos")
	  public ResponseEntity<HttpStatus> deleteAllAlumnos() {
		  try {
		      cursosAlumnosRepository.deleteAll();
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }
	  
	  
}
