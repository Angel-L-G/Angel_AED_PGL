package es.iespuertodelacruz.jc.ejemplowebsocketseguro.document;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PartidaDocument {
	@Id
	String id;
	String nombreJ1;
	String eleccionJ1;
	String nombreJ2;
	String eleccionJ2;
	String ganador;
	enum ResultadosPosibles {piedra, papel, tijera}
	
	public boolean apostar(String a, String j) {
		if (!j.equals(nombreJ1) && !j.equals(nombreJ2) && ganador != null) {
			return false;
		}
		
		String apu = "";
		
		try {
			ResultadosPosibles valueOf = ResultadosPosibles.valueOf(a.toLowerCase());	
			apu = valueOf.toString();
		}catch(Exception ex){
			System.err.println(ex.getMessage());
			return false;
		}
		
		if(j.equals(nombreJ1)) {
			eleccionJ1 = apu;
		}else {
			eleccionJ2 = apu;
		}	
		
		if(eleccionJ1 != null && eleccionJ2 != null) {
			String resultado = "";
			switch (eleccionJ1) {
				case "tijera": {
					switch (eleccionJ2) {
						case "tijera": {
							resultado = "Empate";
							break;
						}
						case "papel": {
							resultado = "Gana Jugador: 1";
							ganador = nombreJ1;
							break;
						}
						case "piedra": {
							resultado = "Gana Jugador: 2";
							ganador = nombreJ2;
							break;
						}
						default:
							System.err.println("Puta Interior");
						}
				}
				case "papel": {
					switch (eleccionJ2) {
						case "tijera": {
							resultado = "Gana Jugador: 2";
							ganador = nombreJ2;
							break;
						}
						case "papel": {
							resultado = "Empate";
							break;
						}
						case "piedra": {
							resultado = "Gana Jugador: 1";
							ganador = nombreJ1;
							break;
						}
						default:
							System.err.println("Puta Interior");
						}
				}
				case "piedra": {
					switch (eleccionJ2) {
						case "tijera": {
							resultado = "Gana Jugador: 1";
							ganador = nombreJ1;
							break;
						}
						case "papel": {
							resultado = "Gana Jugador: 2";
							ganador = nombreJ2;
							break;
						}
						case "piedra": {
							resultado = "Empate";
							break;
						}
						default:
							System.err.println("Puta Interior");
						}
				}
				default:
					System.err.println("Puta");
			}
		}

		return true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombreJ1() {
		return nombreJ1;
	}

	public void setNombreJ1(String nombreJ1) {
		this.nombreJ1 = nombreJ1;
	}

	public String getEleccionJ1() {
		return eleccionJ1;
	}

	public void setEleccionJ1(String eleccionJ1) {
		this.eleccionJ1 = eleccionJ1;
	}

	public String getNombreJ2() {
		return nombreJ2;
	}

	public void setNombreJ2(String nombreJ2) {
		this.nombreJ2 = nombreJ2;
	}

	public String getEleccionJ2() {
		return eleccionJ2;
	}

	public void setEleccionJ2(String eleccionJ2) {
		this.eleccionJ2 = eleccionJ2;
	}

	public String getGanador() {
		return ganador;
	}

	public void setGanador(String ganador) {
		this.ganador = ganador;
	}

	public PartidaDocument() {
		
	}
}
