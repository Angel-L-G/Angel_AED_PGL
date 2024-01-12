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
public class MatriculaService implements IGenericService<Matricula, Integer>{
	@Autowired
	MatriculaJPARepository matriculaRepository;
	@Autowired
	AsignaturaJPARepository asinaturaRepository;
	
	@Override
	public Iterable<Matricula> findAll() {
		return matriculaRepository.findAll();
	}

	@Override
	public Optional<Matricula> findById(Integer id) {
		Optional<Matricula> findById = null;
		
		if(id != null) {
			findById = matriculaRepository.findById(id);
		}
	
		return findById;
	}

	@Override
	@Transactional
	public Matricula save(Matricula element) {
		Matricula save = null;
		if(element != null) {
			if(element.getId() != null) {
				save = matriculaRepository.save(element);
				
				List<Asignatura> findAll = asinaturaRepository.findAll();
				
				for (Asignatura a : findAll) {
					if(element.getAsignaturas() != null) {
						if(element.getAsignaturas().contains(a)) {
							a.getMatriculas().add(element);
						}
					}
				}
			}
		}
		
		return save;
	}
	
	@Transactional
	public boolean updateNative(Matricula element) {
		boolean ok = false;
		if(element != null) {
			if(element.getId() != null) {
				int updateNtive = matriculaRepository.updateNtive(
							element.getId(), 
							element.getYear()
						);
				
				List<Asignatura> findAll = asinaturaRepository.findAll();
				Optional<Matricula> findById = matriculaRepository.findById(element.getId());
				
				for (Asignatura a : findAll) {
					if(findById.get().getAsignaturas().contains(a)) {
						a.getMatriculas().remove(findById.get());
					}
				}
				
				ok = true;
			}
		}
		
		return ok;
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		if(id != null) {
			List<Asignatura> findAll = asinaturaRepository.findAll();
			Optional<Matricula> findById = matriculaRepository.findById(id);
			
			for (Asignatura a : findAll) {
				if(a.getMatriculas().contains(findById)) {
					a.getMatriculas().remove(findById);
				}
			}
			
			matriculaRepository.deleteById(id);
		}
	}
}
