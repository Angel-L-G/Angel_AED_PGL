package es.iespto.angel.gente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.iespto.angel.gente.entity.Persona;
import es.iespto.angel.gente.entity.Usuario;
import es.iespto.angel.gente.repository.IUsuarioRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/usuarios")
public class UsuarioController {
	@Autowired IUsuarioRepository usuarioRepository;

	@RequestMapping("/getAll")
	public ResponseEntity<?> getAll(){
		List<Usuario> findAll = usuarioRepository.findAll();
		
		return ResponseEntity.ok(findAll);
	}
	
	@RequestMapping("/getById")
	public ResponseEntity<?> getById(@RequestParam Integer id){
		return ResponseEntity.ok(usuarioRepository.findById(id));
	}
	
	@RequestMapping("/getDeleteById")
	public ResponseEntity<?> deleteById(@RequestParam Integer id){
		usuarioRepository.deleteById(id);
		return ResponseEntity.ok("No se que ha pasado");
	}
	
	@RequestMapping("/getById")
	public ResponseEntity<?> save(@RequestParam Integer id, @RequestParam String rol, @RequestParam String nombre, @RequestParam String psswd){
		Usuario u = new Usuario();
		
		u.setId(id);
		u.setNombre(nombre);
		u.setPassword(psswd);
		u.setRol(rol);
		
		return ResponseEntity.ok(usuarioRepository.save(u));
	}
	
}
