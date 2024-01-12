package es.iespto.agl.matriculas.dto;

import jakarta.persistence.Column;

public class AlumnoDTO {
	private String dni;
	private String apellidos;
	private Long fechanacimiento;
	private String foto;
	private String nombre;
	private String img64;
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Long getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(Long fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getImg64() {
		return img64;
	}
	public void setImg64(String img64) {
		this.img64 = img64;
	}
}
