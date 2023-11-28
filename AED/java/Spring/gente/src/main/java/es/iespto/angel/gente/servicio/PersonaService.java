package es.iespto.angel.gente.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import es.iespto.angel.gente.entity.Persona;
import es.iespto.angel.gente.repository.IPersonaRepository;
import jakarta.transaction.Transactional;

public class PersonaService implements IGenericService<Persona, Integer>{
	@Autowired
	private IPersonaRepository personaRepository;
	
	@Override
	@Transactional()
	public Iterable<Persona> findAll() {
		return personaRepository.findAll();
	}
	
	@Override
	@Transactional()
	public Optional<Persona> findById(Integer id) {
	return personaRepository.findById(id);
	}

	@Override
	public Persona save(Persona element) {
		
		return personaRepository.save(element);
	}

	@Override
	public void deleteById(Integer id) {
		
		personaRepository.deleteById(id);
	}
}
