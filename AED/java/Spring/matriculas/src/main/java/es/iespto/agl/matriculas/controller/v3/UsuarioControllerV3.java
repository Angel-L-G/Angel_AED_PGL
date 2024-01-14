package es.iespto.agl.matriculas.controller.v3;

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

import es.iespto.agl.matriculas.entity.Usuario;
import es.iespto.agl.matriculas.service.IUsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/api/v3/usuarios")
public class UsuarioControllerV3 {
	@Autowired
	private IUsuarioService userService;

	@GetMapping
	public ResponseEntity<?> findAll() {
		Iterable<Usuario> findAll = userService.findAll();
		return ResponseEntity.ok(findAll);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Optional<Usuario> find = userService.findById(id);
		return ResponseEntity.ok(find);
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Usuario usuario) {
		Usuario u = new Usuario();
		
		u.setEmail(usuario.getEmail());
		u.setPassword(usuario.getPassword());
		u.setRol(usuario.getRol());
		u.setActive(usuario.getActive());
		
		boolean update = userService.update(u);
		
		return ResponseEntity.ok(update);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Usuario usuario) {
		Usuario save = userService.save(usuario);
		return ResponseEntity.ok(save);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {
		userService.deleteById(id);
		return ResponseEntity.ok("Bien");
	}
}
