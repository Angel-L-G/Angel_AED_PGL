package es.iespto.agl.TresEnRayaHexagonal.domain.port.secundary;

import es.iespto.agl.TresEnRayaHexagonal.domain.model.Partida;

public interface ITresEnRayaRepository {
	Partida findById(Integer id);
	Partida save(Partida partida);
	Iterable<Partida> findAll();
	void deleteById(Integer id);
}