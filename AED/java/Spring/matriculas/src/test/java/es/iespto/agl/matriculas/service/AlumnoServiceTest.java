package es.iespto.agl.matriculas.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import es.iespto.agl.matriculas.entity.Alumno;
import jakarta.transaction.Transactional;

public class AlumnoServiceTest {
	@Autowired AlumnoService alumnoService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	@Transactional
	void findAllAlumnoService() {
		List<Alumno> findAll = (List<Alumno>) alumnoService.findAll();
		assertNotNull(findAll);
		assertTrue(findAll.size() == 3);
	}
	
	@Test
	@Transactional
	void findByIdAlumnoService() {
		Alumno pel2 = alumnoService.findById("12345678Z").get();
		assertTrue(pel2.getMatriculas().size() == 1);
	}

	
	/*@Test
	void deleteWithRelPeliculaService() {
		//borrando elemento con categorias
		peliculaService.deleteById(1);
		Optional<Pelicula> opt = okRepository.findByIdWithRel(1);
		assertTrue(!opt.isPresent());
		
		//borrando elemento sin categorias
		peliculaService.deleteById(13);
		opt = okRepository.findByIdWithRel(13);
		assertTrue(!opt.isPresent());		
	}
	
	
	@Test
	void savePeliculaService() {
		Pelicula pelicula = new Pelicula();

		pelicula.setId(0);
		pelicula.setActores("actor, actriz");
		pelicula.setArgumento("argumento");
		pelicula.setDireccion("dirección");
		pelicula.setImagen("imagen");
		pelicula.setTitulo("título");
		pelicula.setTrailer("trailer");

		Pelicula save = peliculaService.save(pelicula);
		assertTrue(save != null);
		assertTrue(save.getId() > 0);

		Optional<Pelicula> opt = okRepository.findByIdWithRel(save.getId());
		Pelicula found = opt.get();
		assertNotNull(found);
		assertTrue(found.getActores().equals("actor, actriz"));
		assertTrue(found.getArgumento().equals("argumento"));
		assertTrue(found.getDireccion().equals("dirección"));
		assertTrue(found.getImagen().equals("imagen"));
		assertTrue(found.getTitulo().equals("título"));
		assertTrue(found.getTrailer().equals("trailer"));
		assertTrue(found.getCategorias().size() == 0);

		pelicula = new Pelicula();
		pelicula.setId(0);
		pelicula.setActores("1actor, actriz");
		pelicula.setArgumento("1argumento");
		pelicula.setDireccion("1dirección");
		pelicula.setImagen("1imagen");
		pelicula.setTitulo("1título");
		pelicula.setTrailer("1trailer");

		pelicula.setCategorias(new ArrayList<Categoria>());
		Categoria categoria = new Categoria();
		categoria.setId(1);
		pelicula.getCategorias().add(categoria);

		categoria = new Categoria();
		categoria.setId(2);
		pelicula.getCategorias().add(categoria);

		save = peliculaService.save(pelicula);
		assertTrue(save != null);
		assertTrue(save.getId() > 0);

		opt = okRepository.findByIdWithRel(save.getId());
		found = opt.get();
		assertNotNull(found);
		assertTrue(found.getActores().equals("1actor, actriz"));
		assertTrue(found.getArgumento().equals("1argumento"));
		assertTrue(found.getDireccion().equals("1dirección"));
		assertTrue(found.getImagen().equals("1imagen"));
		assertTrue(found.getTitulo().equals("1título"));
		assertTrue(found.getTrailer().equals("1trailer"));
		assertTrue(found.getCategorias().size() == 2);

		for (int id : List.of(1, 2)) {
			boolean anyMatch = found.getCategorias()
					.stream()
					.anyMatch(p -> p.getId() == id);

			assertTrue(anyMatch);
		}
	}*/
}
