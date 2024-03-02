package com.uce.edu.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.repository.modelo.dto.MatriculaDTO;
import com.uce.edu.service.IMatriculaService;
import com.uce.edu.service.dto.MatriculaServiceDTO;

@Controller
@RequestMapping(value = "/matriculas")
public class MatriculaControler {

	@Autowired
	private IMatriculaService iMatriculaService;

	@GetMapping(value = "/reporteMatriculas")
	public String reporteMatriculas(MatriculaDTO matriculaDTO, Model modelo) {
		List<MatriculaDTO> matriculas = this.iMatriculaService.reporte();
		modelo.addAttribute("reporteMatriculas", matriculas);
		return "vistaReporteDeMatriculas";
		// http://localhost:8080/matriculas/reporteMatriculas
	}

	@GetMapping(value = "/registrarMatricula")
	public String registrarMatricula(MatriculaServiceDTO matriculaServiceDTO) {
		return "vistaRegistroMatricula";
		// http://localhost:8080/matriculas/registrarMatricula
	}

	@PostMapping(value = "/matricular")
	public String matricular(MatriculaServiceDTO matriculaServiceDTO) {
		this.iMatriculaService.matriculacionAsincrona(matriculaServiceDTO);
		return "redirect:/matriculas/registrarMatricula";
	}
}
