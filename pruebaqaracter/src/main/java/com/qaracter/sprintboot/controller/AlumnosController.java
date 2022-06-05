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

import com.qaracter.sprintboot.model.Alumnos;
import com.qaracter.sprintboot.repository.AlumnosRepository;

@CrossOrigin(origins = "http://localhost:8081") //is for configuring allowed origins. Inthis case the angular interface conection
@RestController //annotation is used to define a controller and to indicate that the return value of the methods should be be bound to the web response body
@RequestMapping("/api") // declares that all Apis’ url in the controller will start with /api.
public class AlumnosController {
	
  @Autowired //– We use @Autowired to inject TutorialRepository bean to local variable.
  AlumnosRepository alumnosRepository;
  @GetMapping("/alumnos")
  public ResponseEntity< List<Alumnos> > getAllAlumnos(@RequestParam(required = false) String nombre) {
	  try {
	      List<Alumnos> alumnos = new ArrayList<Alumnos>();
	      if (nombre == null)
	    	  alumnosRepository.findAll().forEach(alumnos::add);
	      else
	    	  alumnosRepository.findByNameContaining(nombre).forEach(alumnos::add);
	      if (alumnos.isEmpty()) {
	    	  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(alumnos, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
  }
  
  @GetMapping("/alumnos/{id}")
  public ResponseEntity<Alumnos> getAlumnoById(@PathVariable("id") Integer id) {
	  Optional<Alumnos> alumnoData = alumnosRepository.findById(id);
	  if (alumnoData.isPresent()) {
		  return new ResponseEntity<>(alumnoData.get(), HttpStatus.OK);
	  } else {
		  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
  }
  
  @PostMapping("/alumnos")
  public ResponseEntity<Alumnos> createAlumno(@RequestBody Alumnos alumno) {
	  try {
		  // I use _nomber to diferenciate of other list
	     Alumnos _alumno = alumnosRepository.
	    		 save(new Alumnos(alumno.getNombre(), alumno.getApellidos(), alumno.getNumDocumento(), alumno.getFechaNacimiento(), alumno.getFechaRegistro()));
	     return new ResponseEntity<>(_alumno, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  
  }
  
  @PutMapping("/alumnos/{id}")
  public ResponseEntity<Alumnos> updateAlumno(@PathVariable("id") Integer id, @RequestBody Alumnos alumno) {
	  Optional<Alumnos> alumnoData = alumnosRepository.findById(id);
	    if (alumnoData.isPresent()) {
	      Alumnos _alumno = alumnoData.get();
	      _alumno.setNombre(alumno.getNombre());
	      _alumno.setApellidos(alumno.getApellidos());
	      _alumno.setNumDocumento(alumno.getNumDocumento());
	      _alumno.setFechaNacimiento(alumno.getFechaNacimiento());
	      _alumno.setFechaRegistro(alumno.getFechaRegistro());
	      return new ResponseEntity<>(alumnosRepository.save(_alumno), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
  }
  
  @DeleteMapping("/alumnos/{id}")
  public ResponseEntity<HttpStatus> deleteAlumno(@PathVariable("id") Integer id) {
	  try {
	      alumnosRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
  }
  
  @DeleteMapping("/alumnos")
  public ResponseEntity<HttpStatus> deleteAllAlumnos() {
	  try {
	      alumnosRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
  }

  
}

