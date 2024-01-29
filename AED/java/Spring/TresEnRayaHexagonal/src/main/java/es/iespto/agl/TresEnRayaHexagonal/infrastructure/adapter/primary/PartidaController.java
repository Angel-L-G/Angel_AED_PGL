package es.iespto.agl.TresEnRayaHexagonal.infrastructure.adapter.primary;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import es.iespto.agl.TresEnRayaHexagonal.domain.model.Apuesta;
import es.iespto.agl.TresEnRayaHexagonal.domain.model.Partida;
import es.iespto.agl.TresEnRayaHexagonal.domain.port.secundary.ITresEnRayaRepository;
import es.iespto.agl.TresEnRayaHexagonal.infrastructure.adapter.secundary.PartidaEntityService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/partidas")
public class PartidaController {
	@Autowired private ITresEnRayaRepository partidaService;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		Iterable<Partida> findAll = partidaService.findAll();
		return ResponseEntity.ok(findAll);
	}
	
	//MYSQL
	/*@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id){
		Partida find = partidaService.findById(id);         	
		return ResponseEntity.ok(find); 
	}*/
	
	//MONGO
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable String id){
		Partida find = partidaService.findById(id);         	
		return ResponseEntity.ok(find); 
	}
	
	@PutMapping()
	public ResponseEntity<?> update(@RequestBody Partida p) {
		boolean update = partidaService.update(p);
		return ResponseEntity.ok(update);
	}
	
	@PostMapping()
	public ResponseEntity<?> save(@RequestParam String nombreJ1, @RequestParam String simboloJ1) {
		Partida p = new Partida();
		p.setNickJ1(nombreJ1);
		p.setNickJ2("IA");
		
		if (simboloJ1.equals("-")) {
			p.setSimbJ1("O");
		}
		
		if(simboloJ1.equals("O")) {
			p.setSimbJ2("X");
		} else {
			p.setSimbJ2("O");
		}
		
		p.setSimbJ1(simboloJ1);
		p.setTurno(1);
		p.setEscenario("---------");
		p.setEstado("JUGANDO");
		p.setWinner(null);
		
		Partida save = partidaService.save(p);

		return ResponseEntity.ok(save);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {
		partidaService.deleteById(id);
		return ResponseEntity.ok("Bien");
	}
	
	@PutMapping("/{id}/apostar")
	public ResponseEntity<?> apostar(@RequestBody Apuesta a, @PathVariable Integer id) {
		if(a != null && id != null) {
			Partida p = partidaService.findById(id);
			
			if(a.getPlayer() == p.getTurno()) {
				
				int pos = a.getX();
				String c = ""+p.getEscenario().charAt(pos);
				
				if(c.equals("-")) {
					StringBuilder sb = new StringBuilder(p.getEscenario());
					
					sb.setCharAt(pos, p.getSimbJ1().charAt(0));
					
					p.setEscenario(sb.toString());
					
					p.setTurno(2);
					p = p.IAMovement(p);
					p.setTurno(1);
					
					boolean apostar = partidaService.apostar(p);

					if (apostar == false) {
						return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fallo en la base de datos");
					}
					
					String winned = p.checkWinner(p);
					
					p.setWinner(winned);
					
					apostar = partidaService.apostar(p);
					
					if(winned != null) {
						return ResponseEntity.status(HttpStatus.ACCEPTED).body(p);
					}else {
						return ResponseEntity.status(HttpStatus.ACCEPTED).body(p.getEscenario());
					}
					
				}else {
					return ResponseEntity.status(HttpStatus.CONFLICT).body("Movimiento ya hecho: " + p.getEscenario());
				}
			} else {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No Es Su Turno");
			}
		}else {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Tus datos no llegaron al servidor");
		}
	}
}
