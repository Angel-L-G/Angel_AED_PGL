package es.iespto.agl.matriculas.controller;

import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import es.iespto.agl.matriculas.entity.Alumno;
import es.iespto.agl.matriculas.service.AlumnoService;
import es.iespto.agl.matriculas.service.IFileStorageService;


public class AlumnoController {
	@Autowired
	private AlumnoService alumnoService;
	@Autowired
	private IFileStorageService storageService;
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		Iterable<Alumno> findAll = alumnoService.findAll();
		return ResponseEntity.ok(findAll);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> findById(@PathVariable String id) {
		Optional<Alumno> find = alumnoService.findById(id);
		return ResponseEntity.ok(find);
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Alumno alumno) {
		boolean updateNative = alumnoService.updateNative(alumno);
		return ResponseEntity.ok(updateNative);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Alumno alumno) {
		Alumno save = alumnoService.save(alumno);
		return ResponseEntity.ok(save);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable String id) {
		alumnoService.deleteById(id);
		return ResponseEntity.ok("Bien");
	}

	/*@PostMapping("/files64")
	public ResponseEntity<?> nuevoProducto(@RequestBody PeliculaDTO peliculaDTO) {
		Alumno alumno = new Alumno();
		
		alumno.setId(peliculaDTO.getId());
		alumno.setActores(peliculaDTO.getActores());
		alumno.setArgumento(peliculaDTO.getArgumento());
		alumno.setCategorias(peliculaDTO.getCategorias());
		alumno.setDireccion(peliculaDTO.getDireccion());
		alumno.setTitulo(peliculaDTO.getTitulo());
		alumno.setTrailer(peliculaDTO.getTrailer());
		alumno.setImagen(peliculaDTO.getNameImagen());
		
		String codedfoto = peliculaDTO.getImagen();
		byte[] photoBytes = Base64.getDecoder().decode(codedfoto);
		
		String nombreNuevoFichero = storageService.save(peliculaDTO.getNameImagen(), photoBytes);
		alumno.setImagen(nombreNuevoFichero);
		
		Alumno save = alumnoService.save(alumno);
		return ResponseEntity.ok(save);
	}*/
}
