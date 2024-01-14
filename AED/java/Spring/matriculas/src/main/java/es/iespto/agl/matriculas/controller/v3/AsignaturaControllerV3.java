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

import es.iespto.agl.matriculas.entity.Asignatura;
import es.iespto.agl.matriculas.service.AsignaturaService;

@RestController
@CrossOrigin
@RequestMapping("/api/v3/asignaturas")
public class AsignaturaControllerV3 {
@Autowired private AsignaturaService AsignaturaService;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		Iterable<Asignatura> findAll = AsignaturaService.findAll();
		return ResponseEntity.ok(findAll);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id){
		Optional<Asignatura> find = AsignaturaService.findById(id);         	
		return ResponseEntity.ok(find);  
	}
	
	@PutMapping()
	public ResponseEntity<?> update(@RequestBody Asignatura asignatura) {
		AsignaturaService.updateNative(asignatura);
		return ResponseEntity.ok(null);
	}
	
	@PostMapping()
	public ResponseEntity<?> save(@RequestBody Asignatura asignatura) {
		Asignatura save = AsignaturaService.save(asignatura);
		return ResponseEntity.ok(save);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {
		AsignaturaService.deleteById(id);
		return ResponseEntity.ok("Bien");
	}
}
