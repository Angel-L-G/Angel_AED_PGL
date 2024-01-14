package es.iespto.agl.matriculas.controller.v2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.iespto.agl.matriculas.entity.Usuario;
import es.iespto.agl.matriculas.service.IUsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/api/v2/usuarios")
public class UsuarioControllerV2 {
	@Autowired
	private IUsuarioService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Usuario usuario) {
		Object principal =
				SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				
		String nombreAutenticado = ((UserDetails)principal).getUsername();
		Usuario findById = userService.findById(usuario.getId()).get();
		
		if(findById.getNombre().equals(nombreAutenticado)) {
			Usuario u = new Usuario();
			
			u.setId(usuario.getId());
			u.setEmail(usuario.getEmail());
			u.setPassword(passwordEncoder.encode(usuario.getPassword()));
			u.setRol(null);

			boolean update = userService.update(u);
			
			return ResponseEntity.ok(update);
		}else {
			
			return ResponseEntity
				.status(HttpStatus.FORBIDDEN)
				.body("usuario solicitado diferente del autenticado");
		}
	}
	
	@GetMapping
	public ResponseEntity<?> findAllEmail() {
		List<String> findAll = userService.findAllEmail();
		return ResponseEntity.ok(findAll);
	}
}
