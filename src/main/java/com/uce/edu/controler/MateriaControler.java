package com.uce.edu.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.service.IMateriaService;

@Controller
@RequestMapping(value = "/materias")
public class MateriaControler {

	@Autowired
	private IMateriaService iMateriaService;

	@GetMapping(value = "/registrarMateria")
	public String registrarMateria(Materia materia) {
		return "vistaRegistroMateria";
		// http://localhost:8080/materias/registrarMateria
	}

	@PostMapping(value = "/registrar")
	public String registrar(Materia materia) {
		this.iMateriaService.guardar(materia);
		return "redirect:/materias/registrarMateria";

	}
}
