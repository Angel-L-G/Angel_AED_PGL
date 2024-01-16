package es.iespto.agl.TresEnRaya.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import es.iespto.agl.TresEnRaya.entity.Partida;
import es.iespto.agl.TresEnRaya.repository.PartidaJPARepository;

public class PartidaService implements IGenericService<Partida, Integer>{
	@Autowired private PartidaJPARepository partidaRepository;
	
	@Override
	public Iterable<Partida> findAll() {
		return partidaRepository.findAll();
	}

	@Override
	public Optional<Partida> findById(Integer id) {
		Optional<Partida> findById = null;
		
		if(id != null) {
			findById = partidaRepository.findById(id);
		}
	
		return findById;
	}

	@Override
	public Partida save(Partida element) {
		if(element != null) {
			if(element.getId() != null) {
				partidaRepository.save(element);
			}
		}
		return element;
	}

	@Override
	public void deleteById(Integer id) {
		if(id != null) {
			partidaRepository.deleteById(id);
		}
	}
	
	public boolean update(Partida p) {
		boolean ok = false;
		
		if(p != null) {
			if(p.getId() != null) {
				Partida findById = partidaRepository.findById(p.getId()).get();
				
				findById.setEscenario(p.getEscenario());
				findById.setWinner(p.getWinner());
				findById.setEstado(p.getEstado());
				
				ok = true;
			}
		}
		
		return ok;
	}
	
	public boolean

}
