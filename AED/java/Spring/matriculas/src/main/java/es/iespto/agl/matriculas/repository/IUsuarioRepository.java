package es.iespto.agl.matriculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.iespto.agl.matriculas.entity.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
	@Query("SELECT u from Usuario u where u.nombre=:nombre")
	public Usuario findByName(@Param("nombre") String nombre);
	
	@Query("SELECT u from Usuario u where u.email=:email")
	public Usuario findByEmail(@Param("email") String email);
}
