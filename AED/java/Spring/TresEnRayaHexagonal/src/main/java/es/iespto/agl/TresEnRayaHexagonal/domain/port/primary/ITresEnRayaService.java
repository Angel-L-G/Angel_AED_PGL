package es.iespto.agl.TresEnRayaHexagonal.domain.port.primary;

import es.iespto.agl.TresEnRayaHexagonal.domain.model.Partida;

public interface ITresEnRayaService {
	Partida findById(Integer id);
	Partida save(Partida partida);
	Partida nuevaPartida(String nombreJugador);
}
