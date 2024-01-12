package es.iespto.agl.matriculas.controller;

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

import es.iespto.agl.matriculas.dto.AlumnoDTO;
import es.iespto.agl.matriculas.dto.AlumnoInputDTO;
import es.iespto.agl.matriculas.entity.Alumno;
import es.iespto.agl.matriculas.service.AlumnoService;
import es.iespto.agl.matriculas.service.IFileStorageService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/alumnos")
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
	public ResponseEntity<?> update(@RequestBody AlumnoInputDTO alumno) {
		Alumno a = new Alumno();
		
		a.setDni(alumno.getDni());
		a.setApellidos(alumno.getApellidos());
		a.setFoto(alumno.getFoto());
		a.setNombre(alumno.getNombre());
			
		String codedfoto = alumno.getImg64();
		byte[] photoBytes = Base64.getDecoder().decode(codedfoto);
		
		String nombreNuevoFichero = storageService.save(alumno.getFoto(), photoBytes);
		alumno.setFoto(alumno.getFoto());
		
		boolean updateNative = alumnoService.update(a);
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

	@PostMapping("/files64")
	public ResponseEntity<?> nuevoProducto(@RequestBody AlumnoDTO alumnoDTO) {
		Alumno alumno = new Alumno();
		
		alumno.setDni(alumnoDTO.getDni());
		alumno.setApellidos(alumnoDTO.getApellidos());
		alumno.setFechanacimiento(alumnoDTO.getFechanacimiento());
		alumno.setNombre(alumnoDTO.getNombre());
		alumno.setMatriculas(null);
		
		String codedfoto = alumnoDTO.getImg64();
		byte[] photoBytes = Base64.getDecoder().decode(codedfoto);
		
		String nombreNuevoFichero = storageService.save(alumnoDTO.getFoto(), photoBytes);
		alumno.setFoto(alumnoDTO.getFoto());
		
		Alumno save = alumnoService.save(alumno);
		return ResponseEntity.ok(save);
	}
}
