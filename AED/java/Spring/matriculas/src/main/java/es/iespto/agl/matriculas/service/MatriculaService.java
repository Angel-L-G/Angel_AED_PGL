package es.iespto.agl.matriculas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import es.iespto.agl.matriculas.entity.Matricula;
import es.iespto.agl.matriculas.repository.MatriculaJPARepository;

public class MatriculaService implements IGenericService<Matricula, Integer>{
	@Autowired
	MatriculaJPARepository matriculaRepository;
	
	@Override
	public Iterable<Matricula> findAll() {
		return matriculaRepository.findAll();
	}

	@Override
	public Optional<Matricula> findById(Integer id) {
		return matriculaRepository.findById(id);
	}

	@Override
	public Matricula save(Matricula element) {
		return matriculaRepository.save(element);
	}

	@Override
	public void deleteById(Integer id) {
		matriculaRepository.deleteById(id);
	}
}
