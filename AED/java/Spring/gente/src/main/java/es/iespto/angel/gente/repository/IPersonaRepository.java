package es.iespto.angel.gente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.iespto.angel.gente.entity.Persona;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer>{

	@Query("select p from Persona p where p.nombre Like :name")
	public List<Persona> findByName(String name);
	
}
