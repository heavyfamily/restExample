package com.qaracter.sprintboot.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity //annotation indicates that the class is a persistent Java class.
@Table(name = "cursos") // annotation provides the table that maps this entity.
public class Curso {

	@Id //annotation is for the primary key.
	@GeneratedValue(generator = "uuid") //automatically generating id,
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private Integer id;
	private String nombre;
	private String fechaInicio;
	private String fechaFin;
	private String fechaRegistro;
	private String numAlumnos;
	
	public Curso() {
	}
	
	public Curso(String nombre, String fechaInicio, String fechaFin, String fechaRegistro, String numAlumnos) {
		super();
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaRegistro = fechaRegistro;
		this.numAlumnos = numAlumnos;
	}
	
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

	// the Identificator isn´t possible modificate
	public long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Cursos [idCurso=" + id + ", nombre=" + nombre + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", fechaRegistro=" + fechaRegistro +  ", numAlumnos=" + numAlumnos + "]";
	}
}
