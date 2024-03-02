package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.dto.MatriculaDTO;
import com.uce.edu.service.dto.MatriculaServiceDTO;

public interface IMatriculaService {

	public List<MatriculaDTO> reporte();

	public void matriculacionAsincrona(MatriculaServiceDTO matriculaDTO);

	public void matricularConCedulaCodigo(String cedula, String codigo, Matricula matricula);
}
