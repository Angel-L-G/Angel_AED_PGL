package es.iespto.angel.InstitutoJPA.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the alumnos database table.
 * 
 */
@Entity
@Table(name="alumnos")
@NamedQuery(name="Alumno.findAll", query="SELECT a FROM Alumno a")
@NamedNativeQuery(name="Alumno.findByAsignaturaAndYear", query="SELECT a.*, matriculas.year, asignaturas.nombre FROM alumnos"
		+ "    JOIN matriculas ON alumnos.dni = matriculas.dni"
		+ "    JOIN asignatura_matricula ON matriculas.id = asignatura_matricula.idmatricula"
		+ "    JOIN asignaturas ON asignatura_matricula.idasignatura = asignaturas.id"
		+ "    WHERE matriculas.year = ? AND asignaturas.nombre = ?;")
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=20)
	private String dni;

	@Column(length=50)
	private String apellidos;

	private Long fechanacimiento;

	@Column(length=50)
	private String nombre;

	//bi-directional many-to-one association to Matricula
	@OneToMany(mappedBy="alumno")
	private List<Matricula> matriculas;

	public Alumno() {
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Long getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(Long fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Matricula> getMatriculas() {
		return this.matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Matricula addMatricula(Matricula matricula) {
		getMatriculas().add(matricula);
		matricula.setAlumno(this);

		return matricula;
	}

	public Matricula removeMatricula(Matricula matricula) {
		getMatriculas().remove(matricula);
		matricula.setAlumno(null);

		return matricula;
	}

}