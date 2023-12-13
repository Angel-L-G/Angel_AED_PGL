package es.iepto.angel.peliculas.dto;

public class UsuarioLoginDTO {
	private String nombre;

	private String password;

	public UsuarioLoginDTO() {
	}

	public UsuarioLoginDTO(String nombre, String password) {
		this.nombre = nombre;
		this.password = password;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
