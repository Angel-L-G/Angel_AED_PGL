package es.iespto.agl.TresEnRayaHexagonal.infrastructure.adapter.secundary;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iespto.agl.TresEnRayaHexagonal.domain.model.Partida;
import es.iespto.agl.TresEnRayaHexagonal.domain.port.secundary.ITresEnRayaRepository;

@Service
public class PartidaEntityService implements ITresEnRayaRepository{
	@Autowired private PartidaEntityRepository partidaRepository;
	
	@Override
	public Iterable<Partida> findAll() {
		return partidaRepository.findAll();
	}

	@Override
	public Partida findById(Integer id) {
		Partida findById = null;
		
		if(id != null) {
			findById = partidaRepository.findById(id).get();
		}
	
		return findById;
	}

	@Override
	public Partida save(Partida element) {
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

