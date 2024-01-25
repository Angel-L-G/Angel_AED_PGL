package es.iespto.agl.TresEnRayaHexagonal.domain.port.secundary;

public interface ITresEnRayaRepository {
	Partida findById(Integer id);
	Partida save(Partida partida);
}