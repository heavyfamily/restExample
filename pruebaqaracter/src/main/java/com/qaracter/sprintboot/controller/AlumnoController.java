package com.qaracter.sprintboot.controller;


import com.qaracter.sprintboot.model.Alumno;
import com.qaracter.sprintboot.model.AlumnoRequest;
import com.qaracter.sprintboot.service.AlumnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {
    private final AlumnoService alumnoService;


    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Alumno> alumno(@PathVariable Integer id) {
        Optional<Alumno> alumno = alumnoService.findById(id);
        return alumno.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound()
                        .build());
    }

    @GetMapping
    public List<Alumno> list(@RequestParam(required = false) String name) {
        if (StringUtils.isEmpty(name)) {
            return alumnoService.getAll();
        }
        return alumnoService.findByName(name);
    }

    @PostMapping
    public Integer save(@RequestBody AlumnoRequest request) {
        return alumnoService.save(request);
    }



    @PutMapping("{id}")
    public void update(@PathVariable Integer id, @RequestBody AlumnoRequest request) {
        Optional<Alumno> alumno = alumnoService.findById(id);
        if (alumno.isPresent()) {
            alumnoService.update(id, request);
        } else {
            alumnoService.save(request);
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        alumnoService.delete(id);
    }
/*
    @PutMapping("{id}/publish")
    public void publishUnpublish(@PathVariable Integer id, @RequestBody AlumnoRequest request) {
        alumnoService.changePublishedFlag(id, request);
    }
    */
}
