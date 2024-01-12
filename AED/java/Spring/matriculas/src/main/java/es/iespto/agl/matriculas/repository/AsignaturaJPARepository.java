package es.iespto.agl.matriculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.iespto.agl.matriculas.entity.Asignatura;

@Repository
public interface AsignaturaJPARepository extends JpaRepository<Asignatura, Integer> {
	@Query(value="Update asiganturas set nombre = :nombre, curso= :curso"
			+ "where id= :id", nativeQuery=true)
	@Modifying
	public void updateNtive(
				@Param("nombre") String nombre,
				@Param("curso") String curso,
				@Param("id") Integer id
			);
}
