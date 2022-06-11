package com.qaracter.sprintboot.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //annotation indicates that the class is a persistent Java class.
@Table(name = "alumnos") // annotation provides the table that maps this entity.

public class Alumno {
	@Id //annotation is for the primary key.
	@GeneratedValue(generator = "uuid") //automatically generating id,
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private Integer id;
	private String nombre;
	private String apellidos;
	private String numDocumento;
	private String fechaNacimiento;
	private String fechaRegistro;
	
	public Alumno() {
	}
	
	public Alumno(String nombre, String apellidos, String numDocumento, String fechaNacimiento, String fechaRegistro) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.numDocumento = numDocumento;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaRegistro = fechaRegistro;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	// the Identificator isn´t possible modificate
	public Integer getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Alumnos [idAlumno=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", numDocumento=" + numDocumento +  ", fechaNacimiento=" + fechaNacimiento + ", fechaRegistro=" + fechaRegistro +"]";
	}
	
	
	
}