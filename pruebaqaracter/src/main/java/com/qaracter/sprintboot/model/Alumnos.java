package com.qaracter.sprintboot.model;

import javax.persistence.*;

@Entity //annotation indicates that the class is a persistent Java class.
@Table(name = "alumnos") // annotation provides the table that maps this entity.

public class Alumnos {
	@Id //annotation is for the primary key.
	@GeneratedValue(strategy = GenerationType.AUTO) // annotation is used to define generation strategy for the primary key.
	private long id;
	@Column(name = "nombre") //annotation is used to define the column in database that maps annotated field.
	private String nombre;
	@Column(name = "apellidos")
	private String apellidos;
	@Column(name = "numDocumento")
	private String numDocumento;
	@Column(name = "fechaNacimiento")
	private String fechaNacimiento;
	@Column(name = "fechaRegistro")
	private String fechaRegistro;
	
	public Alumnos() {
	}
	
	public Alumnos(String nombre, String apellidos, String numDocumento, String fechaNacimiento, String fechaRegistro) {
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
	public long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Alumnos [idAlumno=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", numDocumento=" + numDocumento +  ", fechaNacimiento=" + fechaNacimiento + ", fechaRegistro=" + fechaRegistro +"]";
	}
	
	
	
}