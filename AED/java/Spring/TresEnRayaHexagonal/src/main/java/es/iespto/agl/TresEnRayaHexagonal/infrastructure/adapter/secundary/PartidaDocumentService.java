package es.iespto.agl.TresEnRayaHexagonal.infrastructure.adapter.secundary;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iespto.agl.TresEnRayaHexagonal.domain.model.Partida;
import es.iespto.agl.TresEnRayaHexagonal.domain.port.secundary.ITresEnRayaRepository;

@Service
public class PartidaDocumentService implements ITresEnRayaRepository{
	@Autowired private PartidaDocumentRepository partidaRepository;
	private PartidaDocumentMapper pm = new PartidaDocumentMapper();	
	@Override
	public Iterable<Partida> findAll() {
		List<PartidaDocument> findAll = partidaRepository.findAll();
		List<Partida> find = new ArrayList<>();
		
		for (PartidaDocument pe : findAll) {
			find.add(pm.toDomain(pe));
		}
		
		return find;
	}

	@Override
	public Partida findById(String id) {
		PartidaDocument findById = null;
		
		if(id != null) {
			findById = partidaRepository.findById(id).get();
		}
		
		return pm.toDomain(findById);
	}

	@Override
	public Partida save(Partida element) {
		Partida save = null;
		if(element != null) {
			PartidaDocument p = pm.toEntity(element);
			save = pm.toDomain(partidaRepository.save(p));
		}
		return save;
	}

	@Override
	public void deleteById(String id) {
		if(id != null) {
			partidaRepository.deleteById(id);
		}
	}
	
	public boolean update(Partida p) {
		boolean ok = false;
		
		if(p != null) {
			if(p.getId() != null) {
				PartidaDocument findById = partidaRepository.findById(p.getId()).get();
				
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
				PartidaDocument findById = partidaRepository.findById(p.getId()).get();
				
				findById.setEscenario(p.getEscenario());
				findById.setTurno(p.getTurno());
				
				partidaRepository.save(findById);
				
				ok = true;
			}
		}
		
		return ok;
	}

	@Override
	public Partida findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}
}
