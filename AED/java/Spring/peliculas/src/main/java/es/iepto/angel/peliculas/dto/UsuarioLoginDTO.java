package es.iepto.angel.peliculas.dto;

public class UsuarioLoginDTO {
	private String nombre;

	private String password;
	
	private String email;

	public UsuarioLoginDTO() {
	}

	public UsuarioLoginDTO(String nombre, String password, String email) {
		this.nombre = nombre;
		this.password = password;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
