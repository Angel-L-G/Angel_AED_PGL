package es.iepto.angel.peliculas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.iepto.angel.peliculas.entity.Pelicula;

@Repository
public interface IPeliculaRepository extends JpaRepository<Pelicula, Integer>{
	@Modifying
	@Query(value="Update peliculas set titulo= :titulo, direccion= :direccion, "
			+ "actores= :actores, argumento= :argumento, "
			+ "imagen= :imagen, trailer= :trailer "
			+ "where id= :id", nativeQuery=true)
	public int updateNtive(
				@Param("id") Integer id,
				@Param("titulo") String titulo,
				@Param("direccion") String direccion,
				@Param("actores") String actores,
				@Param("argumento") String argumento,
				@Param("imagen") String imagen,
				@Param("trailer") String trailer
			);
	
}
