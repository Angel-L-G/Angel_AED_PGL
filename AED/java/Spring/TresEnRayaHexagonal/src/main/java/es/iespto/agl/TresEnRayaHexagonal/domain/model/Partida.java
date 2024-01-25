package es.iespto.agl.TresEnRayaHexagonal.domain.model;

public class Partida {
	private Integer id;
	private String escenario;
	private String estado;
	private String nickJ1;
	private String nickJ2;
	private String simbJ1;
	private String simbJ2;
	private int turno;
	private String winner;

	public Partida() {
	}
	
	public Partida(String j1) {
		this.nickJ1 = j1;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEscenario() {
		return this.escenario;
	}

	public void setEscenario(String escenario) {
		this.escenario = escenario;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNickJ1() {
		return this.nickJ1;
	}

	public void setNickJ1(String nickJ1) {
		this.nickJ1 = nickJ1;
	}

	public String getNickJ2() {
		return this.nickJ2;
	}

	public void setNickJ2(String nickJ2) {
		this.nickJ2 = nickJ2;
	}

	public String getSimbJ1() {
		return this.simbJ1;
	}

	public void setSimbJ1(String simbJ1) {
		this.simbJ1 = simbJ1;
	}

	public String getSimbJ2() {
		return this.simbJ2;
	}

	public void setSimbJ2(String simbJ2) {
		this.simbJ2 = simbJ2;
	}

	public int getTurno() {
		return this.turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public String getWinner() {
		return this.winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
}
