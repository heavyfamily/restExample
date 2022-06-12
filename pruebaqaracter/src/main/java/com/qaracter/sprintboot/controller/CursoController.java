package com.qaracter.sprintboot.controller;

import com.qaracter.sprintboot.model.Curso;
import com.qaracter.sprintboot.model.CursoRequest;
import com.qaracter.sprintboot.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Curso> curso(@PathVariable Integer id) {
        Optional<Curso> curso = cursoService.findById(id);
        return curso.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound()
                        .build());
    }

    @GetMapping
    public List<Curso> list(@RequestParam(required = false) String name) {
        if (StringUtils.isEmpty(name)) {
            return cursoService.getAll();
        }
        return cursoService.findByName(name);
    }

    @PostMapping
    public Integer save(@RequestBody CursoRequest request) {
        return cursoService.save(request);
    }



    @PutMapping("{id}")
    public void update(@PathVariable Integer id, @RequestBody CursoRequest request) {
        Optional<Curso> curso = cursoService.findById(id);
        if (curso.isPresent()) {
            cursoService.update(id, request);
        } else {
            cursoService.save(request);
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        cursoService.delete(id);
    }


}
