package es.iespto.agl.TresEnRaya.controller;

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

import es.iespto.agl.TresEnRaya.domain.Apuesta;
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
			Partida p = partidaService.findById(id).get();
			
			if(a.getPlayer() == p.getTurno()) {
				
				int pos = a.getX();
				String c = ""+p.getEscenario().charAt(pos);
				
				System.out.println("//////////////////////////////////////");
				System.out.println("0.5 " + c);
				System.out.println("//////////////////////////////////////");

				
				if(c.equals("-")) {
					StringBuilder sb = new StringBuilder(p.getEscenario());
					
					sb.setCharAt(pos, p.getSimbJ1().charAt(0));
					
					System.out.println("//////////////////////////////////////");
					System.out.println("1 " + sb.toString());
					System.out.println("//////////////////////////////////////");
					
					p.setEscenario(sb.toString());
					
					p.setTurno(2);
					p = IAMovement(p);
					p.setTurno(1);
					
					System.out.println("//////////////////////////////////////");
					System.out.println("2" + p.getEscenario());
					System.out.println("//////////////////////////////////////");
					
					boolean apostar = partidaService.apostar(p);
					
					System.out.println("//////////////////////////////////////");
					System.out.println("3" + apostar);
					System.out.println("//////////////////////////////////////");

					if (apostar == false) {
						return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fallo en la base de datos");
					}
					
					String winned = checkWinner(p);
					
					p.setWinner(winned);
					
					System.out.println("//////////////////////////////////////");
					System.out.println("4" + p.getWinner());
					System.out.println("//////////////////////////////////////");
					
					apostar = partidaService.apostar(p);
					
					System.out.println("//////////////////////////////////////");
					System.out.println("5" + apostar);
					System.out.println("//////////////////////////////////////");

					
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
	
	private Partida IAMovement(Partida p) {
		if(p.getTurno() == 2) {
			boolean finish = false;
			
			do {
				Apuesta a = new Apuesta();
				a.setX((int)(Math.random()*8));
				
				int pos = a.getX();
				String c = ""+p.getEscenario().charAt(pos);
				
				if(c.equals("-")) {
					StringBuilder sb = new StringBuilder(p.getEscenario());
					
					sb.setCharAt(pos, p.getSimbJ2().charAt(0));
					
					p.setEscenario(sb.toString());
					
					finish = true;
				}
				
			}while(finish == false);
		}
		return p;
	}
	
	public String checkWinner(Partida p) {
		String playground = p.getEscenario();
		String winner = null;
		String[][] lines = {
			    {"0", "1", "2"},
			    {"3", "4", "5"},
			    {"6", "7", "8"},
			    {"0", "3", "6"},
			    {"1", "4", "7"},
			    {"2", "5", "8"},
			    {"0", "4", "8"},
			    {"2", "4", "6"}
			};

       for (int i = 0; i < lines.length; i++) {
           String[] linea = lines[i];
           if (linea[1] != "-" && linea[1] == linea[2] && linea[1] == linea[3]) {           
               String aux = linea[1];
               if(aux.equals(p.getSimbJ1())){
            	   winner = p.getNickJ1();
               }else {
            	   winner = p.getNickJ2();
               }
           }
       }
       return winner;
	}
}