package es.iespto.agl.TresEnRayaHexagonal.infrastructure.adapter.secundary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iespto.agl.TresEnRayaHexagonal.domain.model.Partida;

public interface PartidaEntityRepository extends JpaRepository<Partida, Integer>{

}
