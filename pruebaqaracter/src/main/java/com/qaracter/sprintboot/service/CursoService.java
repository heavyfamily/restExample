package com.qaracter.sprintboot.service;

import com.qaracter.sprintboot.model.Curso;
import com.qaracter.sprintboot.model.CursoRequest;
import com.qaracter.sprintboot.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Optional<Curso> findById(Integer id) {
        return cursoRepository.findById(id);
    }

    public Integer save(CursoRequest request) {
        Curso curso = new Curso();
        curso.setNombre(request.getNombre());
        curso.setFechaInicio(request.getFechaInicio());
        curso.setFechaFin(request.getFechaFin());
        curso.setNumAlumnos(request.getNumAlumnos());
        curso.setFechaRegistro(request.getFechaRegistro());

        return cursoRepository.save(curso).getId();
    }

    public void update(Integer id, CursoRequest request) {
        Optional<Curso> curso = findById(id);
        if (curso.isPresent()) {
            Curso forUpdate = curso.get();
            forUpdate.setNombre(request.getNombre());
            forUpdate.setFechaInicio(request.getFechaInicio());
            forUpdate.setFechaFin(request.getFechaFin());
            forUpdate.setNumAlumnos(request.getNumAlumnos());
            forUpdate.setFechaRegistro(request.getFechaRegistro());

            cursoRepository.save(forUpdate);
        }
    }

    public List<Curso> getAll() {
        return cursoRepository.findAll();
    }

    public List<Curso> findByName(String name) {
        return cursoRepository.findAllByNameContaining(name);
    }

    public void delete(Integer id) {
        Optional<Curso> post = findById(id);
        post.ifPresent(cursoRepository::delete);
    }

}
