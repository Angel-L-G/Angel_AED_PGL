package es.iespto.agl.matriculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.iespto.agl.matriculas.entity.Alumno;

@Repository
public interface AlumnoJPARepository extends JpaRepository<Alumno, String> {
	@Query("SELECT a from Alumno a where a.nombre=:nombre")
	public Alumno findByName(@Param("nombre") String nombre);
 
	/*@Query(value="Update alumnos set nombre = :nombre "
			+ "where dni= :dni", nativeQuery=true)
	@Modifying
	public int updateNtive(
				@Param("nombre") String nombre,
				@Param("apellidos") String apellidos,
				@Param("fechanacimiento") Long fechanacimiento,
				@Param("foto") String foto,
				@Param("dni") String id
			);*/
}
