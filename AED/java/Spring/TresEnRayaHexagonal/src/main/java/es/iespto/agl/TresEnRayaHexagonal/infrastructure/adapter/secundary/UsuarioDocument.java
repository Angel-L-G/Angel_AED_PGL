package es.iespto.agl.TresEnRayaHexagonal.infrastructure.adapter.secundary;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the usuarios database table.
 * 
 */
//@Document(collection="usuarios")
public class UsuarioDocument implements Serializable {
	@Id
	private String id;
	private String nombre;
	private String password;
	private String rol;
	private String email;
	private int active;
	private String hash;

	public UsuarioDocument() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getAtive() {
		return this.active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getHash() {
		return this.hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}
	
}