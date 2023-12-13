package es.iepto.angel.peliculas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import es.iepto.angel.peliculas.entity.Usuario;
import es.iepto.angel.peliculas.service.IUsuarioService;

@Service
public class AuthService {
	@Autowired
	private IUsuarioService usuarioservice;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtService jwtService;

	public String register(UserDetailsLogin userdetails) {
		Usuario userentity = new Usuario();
		userentity.setNombre(userdetails.getUsername());
		userentity.setPassword(passwordEncoder.encode(userdetails.getPassword()));
		userentity.setRol("ROLE_USER");
		Usuario save = usuarioservice.save(userentity);
		userdetails.setRole(userentity.getRol());
		String generateToken = jwtService.generateToken(userdetails.username, userdetails.password);
		return generateToken;
	}

	public String authenticate(UserDetailsLogin request) {
		Usuario userentity = usuarioservice.findByName(request.getUsername());
		UserDetailsLogin userlogin = null;
		if (userentity != null) {
			if (passwordEncoder.matches(request.getPassword(), userentity.getPassword())) {
				userlogin = new UserDetailsLogin();
				userlogin.setUsername(userentity.getNombre());
				userlogin.setPassword(userentity.getPassword());
				userlogin.setRole(userentity.getRol());
			}
		}
		String generateToken = null;
		if (userlogin != null) {
			generateToken = jwtService.generateToken(userentity.getNombre(), userentity.getRol());
		}
		return generateToken;
	}
}