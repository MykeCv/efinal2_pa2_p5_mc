package com.uce.edu.repository.modelo.dto;

public class MatriculaDTO {

	private String cedulaEstudiante;
	private String nombreMateria;
	private String nombreHilo;
	private String cedulaProfesor;

	public MatriculaDTO() {
		super();
	}

	public MatriculaDTO(String cedulaEstudiante, String nombreMateria, String nombreHilo, String cedulaProfesor) {
		super();
		this.cedulaEstudiante = cedulaEstudiante;
		this.nombreMateria = nombreMateria;
		this.nombreHilo = nombreHilo;
		this.cedulaProfesor = cedulaProfesor;

	}

	// gets y sets
	public String getCedulaEstudiante() {
		return cedulaEstudiante;
	}

	public void setCedulaEstudiante(String cedulaEstudiante) {
		this.cedulaEstudiante = cedulaEstudiante;
	}

	public String getNombreMateria() {
		return this.nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

	public String getNombreHilo() {
		return nombreHilo;
	}

	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}

	public String getCedulaProfesor() {
		return cedulaProfesor;
	}

	public void setCedulaProfesor(String cedulaProfesor) {
		this.cedulaProfesor = cedulaProfesor;
	}

}
