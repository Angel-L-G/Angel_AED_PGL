package es.iepto.angel.peliculas.controller.v3;

import java.util.Base64;
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

import es.iepto.angel.peliculas.dto.PeliculaDTO;
import es.iepto.angel.peliculas.entity.Pelicula;
import es.iepto.angel.peliculas.service.IFileStorageService;
import es.iepto.angel.peliculas.service.IPeliculaService;

@RestController
@CrossOrigin
@RequestMapping("/api/v3/peliculas")
public class PeliculaControllerV3 {
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

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Pelicula pelicula) {
		boolean updateNative = peliculaService.updateNative(pelicula);
		return ResponseEntity.ok(updateNative);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Pelicula pelicula) {
		Pelicula save = peliculaService.save(pelicula);
		return ResponseEntity.ok(save);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {
		peliculaService.deleteById(id);
		return ResponseEntity.ok("Bien");
	}

	@PostMapping("/files64")
	public ResponseEntity<?> nuevoProducto(@RequestBody PeliculaDTO peliculaDTO) {
		Pelicula pelicula = new Pelicula();
		
		pelicula.setId(peliculaDTO.getId());
		pelicula.setActores(peliculaDTO.getActores());
		pelicula.setArgumento(peliculaDTO.getArgumento());
		pelicula.setCategorias(peliculaDTO.getCategorias());
		pelicula.setDireccion(peliculaDTO.getDireccion());
		pelicula.setTitulo(peliculaDTO.getTitulo());
		pelicula.setTrailer(peliculaDTO.getTrailer());
		pelicula.setImagen(peliculaDTO.getNameImagen());
		
		String codedfoto = peliculaDTO.getImagen();
		byte[] photoBytes = Base64.getDecoder().decode(codedfoto);
		
		String nombreNuevoFichero = storageService.save(peliculaDTO.getNameImagen(), photoBytes);
		pelicula.setImagen(nombreNuevoFichero);
		
		Pelicula save = peliculaService.save(pelicula);
		return ResponseEntity.ok(save);
	} 
	
}
