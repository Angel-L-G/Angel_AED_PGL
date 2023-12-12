package es.iepto.angel.peliculas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.iepto.angel.peliculas.entity.Pelicula;

@Repository
public interface IPeliculaRepository extends JpaRepository<Pelicula, Integer>{
	
	/*@Query(value="Select * from Peliculas where Peliculas.id = :id", nativeQuery = true)
	public Optional<Pelicula> findByIdNative(Integer id);

	@Modifying
	@Query(value="Delete form Peliculas where Peliculas.id = :id", nativeQuery=true)
	public void DeleteByIdNative(Integer id);
	
	@Query(value="Select * from Peliculas", nativeQuery=true)
	public Iterable<Pelicula> findAllNative();
	
	@Modifying
	@Query(value="Insert into Peliculas(id, titulo, direccion, actores, argumento, imagen, trailer) "
							+ "values(:id, :titulo, :direccion, :actores, :argumento, :imagen, :trailer);", 
			nativeQuery=true)
	public Pelicula saveNative(Pelicula element);
	
	@Modifying
	@Query(value="Update Peliculas set titulo= :titulo, direccion= :direccion, "
			+ "actores= :actores, argumento= :argumento, "
			+ "imagen= :imagen, trailer= :trailer "
			+ "where id= :id", nativeQuery=true)
	public boolean updateNtive(Pelicula element);
	
	RECORDAR CAMBIAR LO QUE RECIBE LAS FUNCIONES 
	*/
}
