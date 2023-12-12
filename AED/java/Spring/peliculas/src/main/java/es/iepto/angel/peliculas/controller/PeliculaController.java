package es.iepto.angel.peliculas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.iepto.angel.peliculas.entity.Pelicula;
import es.iepto.angel.peliculas.service.IPeliculaService;

@RestController
@CrossOrigin
@RequestMapping("/api/peliculas")
public class PeliculaController {
	@Autowired private IPeliculaService peliculaService;

	@GetMapping
	public ResponseEntity<?> findAll(){
		Iterable<Pelicula> findAll = peliculaService.findAll();
		return ResponseEntity.ok(findAll);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id){
		Optional<Pelicula> find = peliculaService.findById(id);         
		return ResponseEntity.ok(find);     
	}
	
	@PutMapping
	public ResponseEntity<?> update() {
		
		
		return ResponseEntity.ok(null);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Pelicula pelicula) {
		Pelicula save = peliculaService.save(pelicula);
		return ResponseEntity.ok(null);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {
		peliculaService.deleteById(id);
		return ResponseEntity.ok("Bien");
	}
}
