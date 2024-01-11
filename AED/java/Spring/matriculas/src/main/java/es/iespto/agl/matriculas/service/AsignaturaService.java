package es.iespto.agl.matriculas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import es.iespto.agl.matriculas.entity.Asignatura;
import es.iespto.agl.matriculas.repository.AsignaturaJPARepository;

public class AsignaturaService implements IGenericService<Asignatura, Integer>{
	@Autowired
	AsignaturaJPARepository asinaturaRepository;
	
	@Override
	public Iterable<Asignatura> findAll() {
		return asinaturaRepository.findAll();
	}

	@Override
	public Optional<Asignatura> findById(Integer id) {
		return asinaturaRepository.findById(id);
	}

	@Override
	public Asignatura save(Asignatura element) {
		return asinaturaRepository.save(element);
	}

	@Override
	public void deleteById(Integer id) {
		asinaturaRepository.deleteById(id);
	}

}
