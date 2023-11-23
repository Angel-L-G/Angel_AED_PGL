package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the coches database table.
 * 
 */
@Entity
@Table(name="coches")
@NamedQuery(name="Coche.findAll", query="SELECT c FROM Coche c")
public class Coche implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=20)
	private String matricula;

	@Column(length=100)
	private String marca;

	@Column(length=100)
	private String modelo;

	//bi-directional many-to-many association to Conductor
	@ManyToMany
	@JoinTable( name="coches_conductores",
	joinColumns = @JoinColumn(name="matricula"),
	inverseJoinColumns = @JoinColumn(name="idconductor")
	)	private List<Conductor> conductores;

	public Coche() {
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public List<Conductor> getConductores() {
		return this.conductores;
	}

	public void setConductores(List<Conductor> conductores) {
		this.conductores = conductores;
	}

}