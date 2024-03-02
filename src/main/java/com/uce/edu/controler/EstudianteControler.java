package com.uce.edu.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IEstudianteService;

@Controller
@RequestMapping(value = "/estudiantes")
public class EstudianteControler {

	@Autowired
	private IEstudianteService estudianteService;

	@GetMapping(value = "/registrarse")
	public String registrarse(Estudiante estudiante) {
		return "vistaRegistroEstudiante";
		// localhost:8080/estudiantes/registrarse
	}

	@PostMapping(value = "/registrar")
	public String registrar(Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
		return "redirect:/estudiantes/registrarse";
	}

}
