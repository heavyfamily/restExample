package com.qaracter.sprintboot.controller;

import com.qaracter.sprintboot.model.CursoAlumno;
import com.qaracter.sprintboot.model.CursoAlumnoRequest;
import com.qaracter.sprintboot.service.CursoAlumnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/cursoscursoCursoAlumnos")
public class CursoAlumnoController {
    private final CursoAlumnoService cursoAlumnoService;


    public CursoAlumnoController(CursoAlumnoService cursoAlumnoService) {
        this.cursoAlumnoService = cursoAlumnoService;
    }

    @GetMapping("{id}")
    public ResponseEntity<CursoAlumno> cursoCursoAlumno(@PathVariable Integer id) {
        Optional<CursoAlumno> cursoCursoAlumno = cursoAlumnoService.findById(id);
        return cursoCursoAlumno.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound()
                        .build());
    }
        /*
    @GetMapping
    public List<CursoAlumno> list(@RequestParam(required = false) String name) {
        if (StringUtils.isEmpty(name)) {
            return cursoAlumnoService.getAll();
        }
        return cursoAlumnoService.findByName(name);
    }
     */

    @PostMapping
    public Integer save(@RequestBody CursoAlumnoRequest request) {
        return cursoAlumnoService.save(request);
    }



    @PutMapping("{id}")
    public void update(@PathVariable Integer id, @RequestBody CursoAlumnoRequest request) {
        Optional<CursoAlumno> cursoCursoAlumno = cursoAlumnoService.findById(id);
        if (cursoCursoAlumno.isPresent()) {
            cursoAlumnoService.update(id, request);
        } else {
            cursoAlumnoService.save(request);
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        cursoAlumnoService.delete(id);
    }


}
