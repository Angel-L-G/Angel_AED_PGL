package es.iespto.agl.matriculas.controller.v3;

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

import es.iespto.agl.matriculas.entity.Matricula;
import es.iespto.agl.matriculas.service.MatriculaService;

@RestController
@CrossOrigin
@RequestMapping("/api/v3/matriculas")
public class MatriculaControllerV3 {
	@Autowired private MatriculaService matriculaService;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		Iterable<Matricula> findAll = matriculaService.findAll();
		return ResponseEntity.ok(findAll);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id){
		Optional<Matricula> find = matriculaService.findById(id);         	
		return ResponseEntity.ok(find);  
	}
	
	@PutMapping()
	public ResponseEntity<?> update(@RequestBody Matricula matricula) {
		matriculaService.updateNative(matricula);
		return ResponseEntity.ok(null);
	}
	
	@PostMapping()
	public ResponseEntity<?> save(@RequestBody Matricula matricula) {
		Matricula save = matriculaService.save(matricula);
		return ResponseEntity.ok(save);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {
		matriculaService.deleteById(id);
		return ResponseEntity.ok("Bien");
	}
}
