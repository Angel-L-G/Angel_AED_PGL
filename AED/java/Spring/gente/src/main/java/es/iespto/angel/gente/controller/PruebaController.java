package es.iespto.angel.gente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.iespto.angel.gente.entity.Persona;
import es.iespto.angel.gente.repository.IPersonaRepository;


@RestController
@CrossOrigin
@RequestMapping("/api/personas")
public class PruebaController {
	@Autowired IPersonaRepository personaRepository;
	
	@RequestMapping("/getAll")
	public ResponseEntity<?> getAll(){
		List<Persona> findAll = personaRepository.findAll();
		
		return ResponseEntity.ok(findAll);
	}
	
	@RequestMapping("/getById")
	public ResponseEntity<?> getById(@RequestParam Integer id){
		return ResponseEntity.ok(personaRepository.findById(id));
	}
	
	@RequestMapping("/getDeleteById")
	public ResponseEntity<?> deleteById(@RequestParam Integer id){
		personaRepository.deleteById(id);
		return ResponseEntity.ok("No se que ha pasado");
	}
	
	@RequestMapping("/getById")
	public ResponseEntity<?> save(@RequestParam Integer id, @RequestParam int edad, @RequestParam String nombre){
		Persona p = new Persona();
		
		p.setEdad(edad);
		p.setId(id);
		p.setNombre(nombre);
		
		return ResponseEntity.ok(personaRepository.save(p));
	}
	
	@RequestMapping("/getById")
	public ResponseEntity<?> getByName(@RequestParam String name){
		return ResponseEntity.ok(personaRepository.findByName(name));
	}
}
