package es.iespto.agl.matriculas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iespto.agl.matriculas.entity.Asignatura;
import es.iespto.agl.matriculas.entity.Matricula;
import es.iespto.agl.matriculas.repository.AsignaturaJPARepository;
import es.iespto.agl.matriculas.repository.MatriculaJPARepository;
import jakarta.transaction.Transactional;

@Service
public class AsignaturaService implements IGenericService<Asignatura, Integer>{
	@Autowired
	AsignaturaJPARepository asinaturaRepository;
	@Autowired
	MatriculaJPARepository matriculaRepository;
	
	@Override
	public Iterable<Asignatura> findAll() {
		return asinaturaRepository.findAll();
	}

	@Override
	public Optional<Asignatura> findById(Integer id) {
		Optional<Asignatura> findById = null;
		
		if(id != null) {
			findById = asinaturaRepository.findById(id);
		}
	
		return findById;
	}

	@Override
	@Transactional
	public Asignatura save(Asignatura element) {
		if(element != null) {
			if(element.getId() != null) {
				asinaturaRepository.save(element);
			}
		}
		return element;
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		if(id != null) {
			List<Matricula> findAll = matriculaRepository.findAll();
			Optional<Asignatura> findById = asinaturaRepository.findById(id);
			
			for (Matricula m : findAll) {
				if(m.getAsignaturas().contains(findById)) {
					m.getAsignaturas().remove(findById);
				}
			}
			
			asinaturaRepository.deleteById(id);
		}
	}
	
	@Transactional
	public boolean update(Asignatura element) {
		boolean ok = false;
		
		if(element != null) {
			if(element.getId() != null) {
				Optional<Asignatura> findById = asinaturaRepository.findById(element.getId());
				ok = true;
			}
		}
		
		return ok;
	}

	@Transactional
	public boolean updateNative(Asignatura element) {
		boolean ok = false;
		
		if(element != null) {
			if(element.getId() != null) {
				asinaturaRepository.updateNtive(element.getNombre(), element.getCurso(), element.getId());
				ok = true;
			}
		}
		
		return ok;
	}

}
