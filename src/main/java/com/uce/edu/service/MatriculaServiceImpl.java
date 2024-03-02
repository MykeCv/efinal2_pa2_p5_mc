package com.uce.edu.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IEstudianteRepository;
import com.uce.edu.repository.IMateriaRepository;
import com.uce.edu.repository.IMatriculaRepository;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.dto.MatriculaDTO;
import com.uce.edu.service.dto.MatriculaServiceDTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IMatriculaRepository iMatriculaRepository;

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Autowired
	private IMateriaRepository iMateriaRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public List<MatriculaDTO> reporte() {
		return this.iMatriculaRepository.seleccionarTodosEficiente();
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void matriculacionAsincrona(MatriculaServiceDTO matriculaDTO) {

		Matricula m1 = new Matricula();
		m1.setFecha(LocalDate.now());
		Materia ma1 = new Materia();
		ma1.setCodigo(matriculaDTO.getCodigoMateria1());
		m1.setMateria(ma1);

		Matricula m2 = new Matricula();
		m2.setFecha(LocalDate.now());
		Materia ma2 = new Materia();
		ma2.setCodigo(matriculaDTO.getCodigoMateria2());
		m2.setMateria(ma2);

		Matricula m3 = new Matricula();
		m3.setFecha(LocalDate.now());
		Materia ma3 = new Materia();
		ma3.setCodigo(matriculaDTO.getCodigoMateria3());
		m3.setMateria(ma3);

		Matricula m4 = new Matricula();
		Materia ma4 = new Materia();
		ma4.setCodigo(matriculaDTO.getCodigoMateria4());
		m4.setMateria(ma4);

		List<Matricula> matriculas = new ArrayList<>();
		matriculas.add(m1);
		matriculas.add(m2);
		matriculas.add(m3);
		matriculas.add(m4);
		matriculas.parallelStream().forEach(matricula -> {
			String hilo = Thread.currentThread().getName();
			matricula.setNombreHilo(hilo);
			this.matricularConCedulaCodigo(matriculaDTO.getCedulaEstudiante(), matricula.getMateria().getCodigo(),
					matricula);
		});
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void matricularConCedulaCodigo(String cedula, String codigo, Matricula matricula) {
		Estudiante estudiante = this.estudianteRepository.seleccionarPorCedula(cedula);
		Materia materia = this.iMateriaRepository.seleccionarPorCodigo(codigo);
		matricula.setEstudiante(estudiante);
		matricula.setMateria(materia);
		matricula.setFecha(LocalDate.now());
		this.iMatriculaRepository.insertar(matricula);

	}

}
