package es.iespto.agl.TresEnRayaHexagonal.infrastructure.adapter.secundary;

import es.iespto.agl.TresEnRayaHexagonal.domain.model.Partida;

public class PartidaEntityMapper {
	public Partida toDomain(PartidaEntity pe) {
		Partida p = new Partida();
		
		p.setEscenario(pe.getEscenario());
		p.setEstado(pe.getEstado());
		p.setId(pe.getId());
		p.setNickJ1(pe.getNickJ1());
		p.setNickJ2(pe.getNickJ2());
		p.setSimbJ1(pe.getSimbJ1());
		p.setSimbJ2(pe.getSimbJ2());
		p.setTurno(pe.getTurno());
		p.setWinner(pe.getWinner());
		
		return p;
	}
	
	public PartidaEntity toEntity(Partida pe) {
		PartidaEntity p = new PartidaEntity();
		
		p.setEscenario(pe.getEscenario());
		p.setEstado(pe.getEstado());
		p.setId(pe.getId());
		p.setNickJ1(pe.getNickJ1());
		p.setNickJ2(pe.getNickJ2());
		p.setSimbJ1(pe.getSimbJ1());
		p.setSimbJ2(pe.getSimbJ2());
		p.setTurno(pe.getTurno());
		p.setWinner(pe.getWinner());
		
		return p;
	}
}
