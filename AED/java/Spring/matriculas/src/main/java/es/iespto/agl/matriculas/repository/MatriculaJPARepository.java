package es.iespto.agl.matriculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iespto.agl.matriculas.entity.Matricula;

public interface MatriculaJPARepository extends JpaRepository<Matricula, Integer> {

}
