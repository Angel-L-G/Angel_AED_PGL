package es.iespto.agl.TresEnRaya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iespto.agl.TresEnRaya.entity.Partida;

@Repository
public interface PartidaJPARepository extends JpaRepository<Partida, Integer>{

}
