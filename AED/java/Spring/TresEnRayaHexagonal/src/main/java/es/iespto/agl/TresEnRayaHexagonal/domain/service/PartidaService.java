package es.iespto.agl.TresEnRayaHexagonal.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iespto.agl.TresEnRayaHexagonal.domain.port.primary.ITresEnRayaService;

@Service
public class PartidaService implements ITresEnRayaService{
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
	public Partida nuevaPartida(String nombreJugador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Partida save(Partida partida) {
		Partida save = null;
		if(element != null) {
			save = partidaRepository.save(element);
		}
		return save;
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
	
	public boolean apostar(Partida p) {
		boolean ok = false;
		
		if(p != null) {
			if(p.getId() != null) {
				Partida findById = partidaRepository.findById(p.getId()).get();
				
				findById.setEscenario(p.getEscenario());
				findById.setTurno(p.getTurno());
				
				partidaRepository.save(findById);
				
				ok = true;
			}
		}
		
		return ok;
	}
}