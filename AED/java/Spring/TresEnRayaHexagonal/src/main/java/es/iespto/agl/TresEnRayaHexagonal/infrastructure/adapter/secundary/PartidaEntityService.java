package es.iespto.agl.TresEnRayaHexagonal.infrastructure.adapter.secundary;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ssl.pem.PemContent;
import org.springframework.stereotype.Service;

import es.iespto.agl.TresEnRayaHexagonal.domain.model.Partida;
import es.iespto.agl.TresEnRayaHexagonal.domain.port.secundary.ITresEnRayaRepository;

//@Service
public class PartidaEntityService implements ITresEnRayaRepository{
	@Autowired private PartidaEntityRepository partidaRepository;
	private PartidaEntityMapper pem = new PartidaEntityMapper();
	
	@Override
	public Iterable<Partida> findAll() {
		List<PartidaEntity> findAll = partidaRepository.findAll();
		List<Partida> find = new ArrayList<>();
		
		for (PartidaEntity pe : findAll) {
			find.add(pem.toDomain(pe));
		}
		
		return find;
	}

	@Override
	public Partida findById(Integer id) {
		PartidaEntity findById = null;
		
		if(id != null) {
			findById = partidaRepository.findById(id).get();
		}
		
		return pem.toDomain(findById);
	}

	@Override
	public Partida save(Partida element) {
		Partida save = null;
		if(element != null) {
			PartidaEntity p = pem.toEntity(element);
			save = pem.toDomain(partidaRepository.save(p));
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
				PartidaEntity findById = partidaRepository.findById(Integer.parseInt(p.getId())).get();
				
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
				PartidaEntity findById = partidaRepository.findById(Integer.parseInt(p.getId())).get();
				
				findById.setEscenario(p.getEscenario());
				findById.setTurno(p.getTurno());
				
				partidaRepository.save(findById);
				
				ok = true;
			}
		}
		
		return ok;
	}

	@Override
	public Partida findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

}

