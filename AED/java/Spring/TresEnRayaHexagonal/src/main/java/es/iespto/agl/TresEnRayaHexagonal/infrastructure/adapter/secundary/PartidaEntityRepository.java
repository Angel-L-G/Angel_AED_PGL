package es.iespto.agl.TresEnRayaHexagonal.infrastructure.adapter.secundary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iespto.agl.TresEnRayaHexagonal.domain.model.Partida;

//@Repository
public interface PartidaEntityRepository extends JpaRepository<PartidaEntity, Integer>{

}
