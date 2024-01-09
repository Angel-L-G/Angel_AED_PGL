package es.iepto.angel.peliculas.controller.v1;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.iepto.angel.peliculas.entity.Pelicula;
import es.iepto.angel.peliculas.service.IFileStorageService;
import es.iepto.angel.peliculas.service.IPeliculaService;

//@RestController
@CrossOrigin
//@RequestMapping("/api/v1/peliculas")
public class PeliculaControllerV1 {
	@Autowired
	private IPeliculaService peliculaService;
	@Autowired
	private IFileStorageService storageService;

	@GetMapping
	public ResponseEntity<?> findAll() {
		Iterable<Pelicula> findAll = peliculaService.findAll();
		return ResponseEntity.ok(findAll);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Optional<Pelicula> find = peliculaService.findById(id);
		return ResponseEntity.ok(find);
	}
}
