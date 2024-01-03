package es.iepto.angel.peliculas.controller.v2;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.iepto.angel.peliculas.entity.Categoria;
import es.iepto.angel.peliculas.service.ICategoriaService;

@RestController
@CrossOrigin
@RequestMapping("/api/v2/categorias")
public class CategoriaControllerV2 {
	@Autowired private ICategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		Iterable<Categoria> findAll = categoriaService.findAll();
		return ResponseEntity.ok(findAll);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id){
		Optional<Categoria> find = categoriaService.findById(id);         
		return ResponseEntity.ok(find);  
	}
	
	@PutMapping()
	public ResponseEntity<?> update(@RequestBody Categoria categoria) {
		categoriaService.updateNative(categoria);
		return ResponseEntity.ok(null);
	}
	
	@PostMapping()
	public ResponseEntity<?> save(@RequestBody Categoria categoria) {
		Categoria save = categoriaService.save(categoria);
		return ResponseEntity.ok(save);
	}
}