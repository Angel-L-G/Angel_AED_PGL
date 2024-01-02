package es.iepto.angel.peliculas.controller;

import java.lang.System.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.iepto.angel.peliculas.dto.UsuarioLoginDTO;
import es.iepto.angel.peliculas.entity.Usuario;
import es.iepto.angel.peliculas.security.AuthService;
import es.iepto.angel.peliculas.security.UserDetailsLogin;
import es.iepto.angel.peliculas.service.IUsuarioService;
import es.iepto.angel.peliculas.service.MailService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LoginController {
	Logger log;
	@Autowired
	private AuthService service;
	@Autowired
	private MailService mailService;
	@Autowired
	private IUsuarioService userService;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UsuarioLoginDTO request) {
		
		UserDetailsLogin user = new UserDetailsLogin();
		
		user.setUsername(request.getNombre());
		user.setPassword(request.getPassword());
		user.setRole("USER");
		user.setEmail(request.getEmail());
		
		return ResponseEntity.ok(service.register(user));
	}

	@PostMapping("/login")
	public ResponseEntity<String> authenticate(@RequestBody UsuarioLoginDTO request) {
		
		UserDetailsLogin user = new UserDetailsLogin();
		
		user.setUsername(request.getNombre());
		user.setPassword(request.getPassword());

		String token = service.authenticate(user);
		if (token == null)
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("User/pass erróneo");
		else
			return ResponseEntity.ok(token);
	}
	
	@GetMapping("/registerVerify")
	public ResponseEntity<?> verify(@RequestParam String email, @RequestParam String hash){
		Usuario user = userService.findByEmail(email);
		
		if(user != null) {
			if(hash.equals(user.getHash())) {
				user.setActive(1);
				userService.save(user);
				return ResponseEntity.ok(user.getNombre());
			}else {
				return (ResponseEntity<?>) ResponseEntity.unprocessableEntity();
			}
		}else {
			return (ResponseEntity<?>) ResponseEntity.noContent();
		}
	}
}