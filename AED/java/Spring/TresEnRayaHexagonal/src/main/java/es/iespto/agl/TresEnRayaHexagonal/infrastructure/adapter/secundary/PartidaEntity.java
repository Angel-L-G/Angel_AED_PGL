package es.iespto.agl.TresEnRayaHexagonal.infrastructure.adapter.secundary;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the partidas database table.
 * 
 */
@Entity
@Table(name="partidas")
@NamedQuery(name="Partida.findAll", query="SELECT p FROM PartidaEntity p")
public class PartidaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=9)
	private String escenario;

	@Column(length=15)
	private String estado;

	@Column(length=14)
	private String nickJ1;

	@Column(length=14)
	private String nickJ2;

	@Column(length=1)
	private String simbJ1;

	@Column(length=1)
	private String simbJ2;

	private int turno;

	@Column(length=14)
	private String winner;

	public PartidaEntity() {
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
