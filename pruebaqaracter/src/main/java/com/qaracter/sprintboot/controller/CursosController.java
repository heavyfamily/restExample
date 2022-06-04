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

import com.qaracter.sprintboot.model.Cursos;
import com.qaracter.sprintboot.repository.CursosRepository;

@CrossOrigin(origins = "http://localhost:8081") //is for configuring allowed origins. Inthis case the angular interface conection
@RestController //annotation is used to define a controller and to indicate that the return value of the methods should be be bound to the web response body
@RequestMapping("/api") // declares that all Apis’ url in the controller will start with /api.
public class CursosController {

	@Autowired //– We use @Autowired to inject TutorialRepository bean to local variable.
	  CursosRepository cursosRepository;
	  @GetMapping("/cursos")
	  public ResponseEntity< List<Cursos> > getAllAlumnos(@RequestParam(required = false) String nombre) {
		  try {
		      List<Cursos> cursos = new ArrayList<Cursos>();
		      if (nombre == null)
		    	  cursosRepository.findAll().forEach(cursos::add);
		      else
		    	  cursosRepository.findByNameContaining(nombre).forEach(cursos::add);
		      if (cursos.isEmpty()) {
		    	  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(cursos, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }
	  
	  @GetMapping("/cursos/{id}")
	  public ResponseEntity<Cursos> getAlumnoById(@PathVariable("id") long id) {
		  Optional<Cursos> alumnoData = cursosRepository.findById(id);
		  if (alumnoData.isPresent()) {
			  return new ResponseEntity<>(alumnoData.get(), HttpStatus.OK);
		  } else {
			  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }
	  
	  @PostMapping("/cursos")
	  public ResponseEntity<Cursos> createTutorial(@RequestBody Cursos curso) {
		  try {
			  // I use _nomber to diferenciate of other list
		     Cursos _curso = cursosRepository.
		    		 save(new Cursos(curso.getNombre(), curso.getFechaInicio(), curso.getFechaFin(), curso.getFechaRegistro(), curso.getNumAlumnos()));
		     return new ResponseEntity<>(_curso, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  
	  }
	  
	  @PutMapping("/cursos/{id}")
	  public ResponseEntity<Cursos> updateAlumnos(@PathVariable("id") long id, @RequestBody Cursos curso) {
		  Optional<Cursos> alumnoData = cursosRepository.findById(id);
		    if (alumnoData.isPresent()) {
		      Cursos _curso = alumnoData.get();
		      _curso.setNombre(curso.getNombre());
		      _curso.setFechaInicio(curso.getFechaInicio());
		      _curso.setFechaFin(curso.getFechaFin());
		      _curso.setFechaRegistro(curso.getFechaRegistro());
		      _curso.setNumAlumnos(curso.getNumAlumnos());
		      return new ResponseEntity<>(cursosRepository.save(_curso), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
	  }
	  
	  @DeleteMapping("/cursos/{id}")
	  public ResponseEntity<HttpStatus> deleteAlumno(@PathVariable("id") long id) {
		  try {
		      cursosRepository.deleteById(id);
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }
	  
	  @DeleteMapping("/cursos")
	  public ResponseEntity<HttpStatus> deleteAllAlumnos() {
		  try {
		      cursosRepository.deleteAll();
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }
	  
	 
}
