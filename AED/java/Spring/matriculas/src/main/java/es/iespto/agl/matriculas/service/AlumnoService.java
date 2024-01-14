package es.iespto.agl.matriculas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iespto.agl.matriculas.entity.Alumno;
import es.iespto.agl.matriculas.repository.AlumnoJPARepository;
import jakarta.transaction.Transactional;

@Service
public class AlumnoService implements IGenericService<Alumno, String>{
	@Autowired
	AlumnoJPARepository alumnoRepository;
	
	@Override
	public Iterable<Alumno> findAll() {
		return alumnoRepository.findAll();
	}

	@Override
	public Optional<Alumno> findById(String id) {
		Optional<Alumno> findById = null;
		
		if(id != null) {
			findById = alumnoRepository.findById(id);
		}
	
		return findById;
	}

	@Override
	@Transactional
	public Alumno save(Alumno element) {
		Alumno save = null;
		if(element != null) {
			if(element.getDni() != null) {
				save = alumnoRepository.save(element);
			}
		}
		
		return save;
	}
	
	@Transactional
	public boolean update(Alumno element) {
		boolean ok = false;
		if(element != null) {
			if(element.getDni() != null) {
				Optional<Alumno> findById = alumnoRepository.findById(element.getDni());
	
				findById.get().setApellidos(element.getApellidos());
				findById.get().setNombre(element.getNombre());
				findById.get().setFoto(element.getFoto());
				
				ok = true;
			}
		}	
		
		return ok;
	}

	@Override
	@Transactional
	public void deleteById(String id) {
		if(id != null) {
			Optional<Alumno> findById = alumnoRepository.findById(id);
			alumnoRepository.deleteById(id);
		}
	}
	
	@Transactional
	public Alumno findByName(String nombre) {
		Alumno find = null;
		
		if(nombre != null) {
			find = alumnoRepository.findByName(nombre);
		}
	
		return find;
	}

}
