package es.iespto.angel.gente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iespto.angel.gente.entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{

}
