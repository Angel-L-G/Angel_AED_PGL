package es.iespto.agl.matriculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iespto.agl.matriculas.entity.Asignatura;

public interface AsignaturaJPARepository extends JpaRepository<Asignatura, Integer> {

}
