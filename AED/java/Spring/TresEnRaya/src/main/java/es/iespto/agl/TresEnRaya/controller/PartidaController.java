package es.iespto.agl.TresEnRaya.controller;

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

import es.iespto.agl.TresEnRaya.entity.Partida;
import es.iespto.agl.TresEnRaya.service.PartidaService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/partidas")
public class PartidaController {
	@Autowired private PartidaService partidaService;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		Iterable<Partida> findAll = partidaService.findAll();
		return ResponseEntity.ok(findAll);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id){
		Optional<Partida> find = partidaService.findById(id);         	
		return ResponseEntity.ok(find); 
	}
	
	@PutMapping()
	public ResponseEntity<?> update(@RequestBody Partida categoria) {
		partidaService.update(categoria);
		return ResponseEntity.ok(null);
	}
	
	@PostMapping()
	public ResponseEntity<?> save(@RequestBody String nombreJ1, @RequestBody String simboloJ1) {
		Partida p = new Partida();
		p.setNickJ1(nombreJ1);
		p.setNickJ2("IA");
		
		if(simboloJ1.equals("O")) {
			p.setSimbJ2("X");
		}else {
			p.setSimbJ2("O");
		}
		
		p.setSimbJ1(simboloJ1);
		p.setTurno(1);
		p.setEscenario("---------");
		p.setEstado("JUGANDO");
		p.setWinner(null);

		return ResponseEntity.ok(null);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {
		partidaService.deleteById(id);
		return ResponseEntity.ok("Bien");
	}
	
	@PutMapping("/{id}/")
	public ResponseEntity<?> apostar(@RequestBody Partida categoria) {
		partidaService.update(categoria);
		return ResponseEntity.ok(null);
	}
}
