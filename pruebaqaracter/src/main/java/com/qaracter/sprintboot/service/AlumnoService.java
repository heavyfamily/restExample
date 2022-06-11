package com.qaracter.sprintboot.service;

import com.qaracter.sprintboot.model.Alumno;
import com.qaracter.sprintboot.model.AlumnoRequest;
import com.qaracter.sprintboot.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {
    private final AlumnoRepository alumnoRepository;

    @Autowired
    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public Optional<Alumno> findById(Integer id) {
        return alumnoRepository.findById(id);
    }

    public Integer save(AlumnoRequest request) {
        Alumno alumno = new Alumno();
        alumno.setNombre(request.getNombre());
        alumno.setApellidos(request.getApellidos());
        alumno.setNumDocumento(request.getNumDocumento());
        alumno.setFechaNacimiento(request.getFechaNacimiento());
        alumno.setFechaRegistro(request.getFechaRegistro());

        return alumnoRepository.save(alumno).getId();
    }

    public void update(Integer id, AlumnoRequest request) {
        Optional<Alumno> alumno = findById(id);
        if (alumno.isPresent()) {
            Alumno forUpdate = alumno.get();
            forUpdate.setNombre(request.getNombre());
            forUpdate.setApellidos(request.getApellidos());
            forUpdate.setNumDocumento(request.getNumDocumento());
            forUpdate.setFechaNacimiento(request.getFechaNacimiento());
            forUpdate.setFechaRegistro(request.getFechaRegistro());

            alumnoRepository.save(forUpdate);
        }
    }

    public List<Alumno> getAll() {
        return alumnoRepository.findAll();
    }

    public List<Alumno> findByName(String name) {
        return alumnoRepository.findAllByNameContaining(name);
    }

    public void delete(Integer id) {
        Optional<Alumno> post = findById(id);
        post.ifPresent(alumnoRepository::delete);
    }


}
