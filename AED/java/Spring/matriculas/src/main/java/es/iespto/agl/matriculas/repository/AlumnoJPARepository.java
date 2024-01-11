package es.iespto.agl.matriculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.iespto.agl.matriculas.entity.Alumno;

public interface AlumnoJPARepository extends JpaRepository<Alumno, String> {
	@Query("SELECT a from alumnos a where a.nombre=:nombre")
	public Alumno findByName(@Param("nombre") String nombre);
}
