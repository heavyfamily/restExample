package com.qaracter.sprintboot.service;

import com.qaracter.sprintboot.model.CursoAlumno;
import com.qaracter.sprintboot.model.CursoAlumnoRequest;
import com.qaracter.sprintboot.repository.CursoAlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoAlumnoService {

    private final CursoAlumnoRepository cursoAlumnoRepository;

    @Autowired
    public CursoAlumnoService(CursoAlumnoRepository cursoAlumnoRepository) {
        this.cursoAlumnoRepository = cursoAlumnoRepository;
    }

    public Optional<CursoAlumno> findById(Integer id) {
        return cursoAlumnoRepository.findById(id);
    }

    public Integer save(CursoAlumnoRequest request) {
        CursoAlumno cursoAlumno = new CursoAlumno();
        cursoAlumno.setIdAlumno(request.getIdAlumno());
        cursoAlumno.setIdCurso(request.getIdCurso());
        cursoAlumno.setFechaInscripcion(request.getFechaInscripcion());
        cursoAlumno.setFechaBaja(request.getFechaBaja());

        return cursoAlumnoRepository.save(cursoAlumno).getId();
    }

    public void update(Integer id, CursoAlumnoRequest request) {
        Optional<CursoAlumno> cursoAlumno = findById(id);
        if (cursoAlumno.isPresent()) {
            CursoAlumno forUpdate = cursoAlumno.get();
            forUpdate.setIdAlumno(request.getIdAlumno());
            forUpdate.setIdCurso(request.getIdCurso());
            forUpdate.setFechaInscripcion(request.getFechaInscripcion());
            forUpdate.setFechaBaja(request.getFechaBaja());

            cursoAlumnoRepository.save(forUpdate);
        }
    }

    public List<CursoAlumno> getAll() {
        return cursoAlumnoRepository.findAll();
    }



    public void delete(Integer id) {
        Optional<CursoAlumno> post = findById(id);
        post.ifPresent(cursoAlumnoRepository::delete);
    }
}
