package es.iespto.agl.matriculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.iespto.agl.matriculas.entity.Matricula;

@Repository
public interface MatriculaJPARepository extends JpaRepository<Matricula, Integer> {

}
