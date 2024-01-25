package es.iespto.agl.TresEnRayaHexagonal.domain.service;

import org.springframework.beans.factory.annotation.Autowired;

import es.iespto.agl.TresEnRayaHexagonal.domain.model.Partida;
import es.iespto.agl.TresEnRayaHexagonal.domain.port.primary.ITresEnRayaService;
import es.iespto.agl.TresEnRayaHexagonal.domain.port.secundary.ITresEnRayaRepository;

public class TresEnRayaService implements ITresEnRayaService {
	@Autowired
	ITresEnRayaRepository partidaRepository;

	@Override
	public Partida findById(Integer id) {
		Partida findById = null;
		if (id != null) {
			findById = partidaRepository.findById(id);
		}
		return findById;
	}

	@Override
	public Partida nuevaPartida(String nombreJugador) {
		Partida partida = new Partida(nombreJugador);
		return partidaRepository.save(partida);
	}

	@Override
	public Partida save(Partida partida) {
		return partidaRepository.save(partida);
	}
}
