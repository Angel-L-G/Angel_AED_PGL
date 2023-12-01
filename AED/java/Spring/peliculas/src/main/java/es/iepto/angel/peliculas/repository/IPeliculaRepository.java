package es.iepto.angel.peliculas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import es.iepto.angel.peliculas.entity.Pelicula;

public interface IPeliculaRepository extends JpaRepository<Pelicula, Integer>{
	
	@Query(value="Select * from Peliculas where Peliculas.id = :id", nativeQuery = true)
	public Optional<Pelicula> findByIdNative(Integer id);

	@Modifying
	@Query(value="Delete form Peliculas where Peliculas.id = :id", nativeQuery=true)
	public void DeleteByIdNative();
	
	@Query(value="Select * from Peliculas", nativeQuery=true)
	public Iterable<Pelicula> findAllNative();
	
	@Query(value="", nativeQuery=true)
	public Pelicula saveNative(Pelicula element);
	
}
