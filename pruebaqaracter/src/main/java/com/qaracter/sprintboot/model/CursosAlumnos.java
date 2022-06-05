package com.qaracter.sprintboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //annotation indicates that the class is a persistent Java class.
@Table(name = "cursosalumnos") // annotation provides the table that maps this entity.
public class CursosAlumnos {

	@Id //annotation is for the primary key.
	@GeneratedValue(strategy = GenerationType.AUTO) // annotation is used to define generation strategy for the primary key.
	private Integer id;
	@Column(name = "idCurso")
	private Integer idCurso;
	@Column(name = "idAlumno")
	private Integer idAlumno;
	@Column(name = "fechaInscripcion")
	private String fechaInscripcion;
	@Column(name = "fechaBaja")
	private String fechaBaja;
	
	public CursosAlumnos() {
		super();
	}

	public CursosAlumnos(Integer idCurso, Integer idAlumno, String fechaInscripcion, String fechaBaja) {
		super();
		this.idCurso = idCurso;
		this.idAlumno = idAlumno;
		this.fechaInscripcion = fechaInscripcion;
		this.fechaBaja = fechaBaja;
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(String fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public String getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(String fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	// the Identificator isn´t possible modificate
	public Integer getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "CursosAlumnos [idCursoAlumno=" + id + ", idCurso=" + idCurso + ", idAlumno=" + idAlumno + ", fechaInscripcion=" + fechaInscripcion + ", fechaBaja=" + fechaBaja + "]";
	}
	
	
}
