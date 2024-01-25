package es.iespto.agl.TresEnRayaHexagonal.domain.port.primary;

public interface ITresEnRayaService {
	Partida findById(Integer id);
	Partida save(Partida partida);
	Partida nuevaPartida(String nombreJugador);
}
