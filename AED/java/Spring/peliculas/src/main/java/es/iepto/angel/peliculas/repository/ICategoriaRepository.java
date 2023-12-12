package es.iepto.angel.peliculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.iepto.angel.peliculas.entity.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Integer>{

	@Query(value="Update Categorias set nombre = :nombre "
			+ "where id= :id", nativeQuery=true)
	@Modifying
	public void updateNtive(
				@Param("nombre") String nombre, 
				@Param("id") Integer id
			);
	
}
