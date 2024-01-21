package es.iespto.agl.matriculas.controller.v3;

import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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

import es.iespto.agl.matriculas.entity.Usuario;
import es.iespto.agl.matriculas.service.IUsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/api/v3/usuarios")
public class UsuarioControllerV3 {
	@Autowired
	private IUsuarioService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;

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
		u.setPassword(passwordEncoder.encode(usuario.getPassword()));
		u.setRol(usuario.getRol());
		u.setActive(2);
		
		boolean update = userService.update(u);
		
		return ResponseEntity.ok(update);
	}
	
	@PutMapping("/getRol")
	public ResponseEntity<?> validate(@RequestParam String nombre) {
		System.out.println("_________________________________________");
		System.out.println("AAAA: " +nombre);
		Usuario u = userService.findByName(nombre);
		u.setActive(2);
		
		boolean update = userService.update(u);
		return ResponseEntity.ok(update);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Usuario usuario) {
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		
		int randInt = (int)Math.random()*10000;
		String randStrHashed = passwordEncoder.encode(randInt+"");
		usuario.setHash(randStrHashed);
		
		Usuario save = userService.save(usuario);
		return ResponseEntity.ok(save);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {
		userService.deleteById(id);
		return ResponseEntity.ok("Bien");
	}
}
