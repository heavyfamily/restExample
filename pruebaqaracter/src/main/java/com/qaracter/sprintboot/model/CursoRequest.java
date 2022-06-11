package com.qaracter.sprintboot.model;

public class CursoRequest {

    private String nombre;
    private String fechaInicio;
    private String fechaFin;
    private String fechaRegistro;
    private String numAlumnos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNumAlumnos() {
        return numAlumnos;
    }

    public void setNumAlumnos(String numAlumnos) {
        this.numAlumnos = numAlumnos;
    }
}
