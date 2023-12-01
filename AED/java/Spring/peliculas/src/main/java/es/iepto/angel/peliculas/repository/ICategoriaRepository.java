package es.iepto.angel.peliculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iepto.angel.peliculas.entity.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer>{

}
