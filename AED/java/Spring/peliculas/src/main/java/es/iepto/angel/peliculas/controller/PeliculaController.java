package es.iepto.angel.peliculas.controller;

import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import es.iepto.angel.peliculas.dto.PeliculaDTO;
import es.iepto.angel.peliculas.entity.Pelicula;
import es.iepto.angel.peliculas.service.IFileStorageService;
import es.iepto.angel.peliculas.service.IPeliculaService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/peliculas")
public class PeliculaController {
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

	@PostMapping("/files")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			String namefile = storageService.save(file);
			message = "" + namefile;
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}

	//@PostMapping("/files/upload")
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
