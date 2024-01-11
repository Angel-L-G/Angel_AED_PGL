package es.iespto.agl.matriculas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import es.iespto.agl.matriculas.entity.Alumno;
import es.iespto.agl.matriculas.repository.AlumnoJPARepository;

public class AlumnoService implements IGenericService<Alumno, String>{
	@Autowired
	AlumnoJPARepository alumnoRepository;
	
	@Override
	public Iterable<Alumno> findAll() {
		return alumnoRepository.findAll();
	}

	@Override
	public Optional<Alumno> findById(String id) {
		return alumnoRepository.findById(id);
	}

	@Override
	public Alumno save(Alumno element) {
		return alumnoRepository.save(element);
	}

	@Override
	public void deleteById(String id) {
		alumnoRepository.deleteById(id);
		
	}

}
