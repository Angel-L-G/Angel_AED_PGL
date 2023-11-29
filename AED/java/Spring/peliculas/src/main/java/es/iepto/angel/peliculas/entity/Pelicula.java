package es.iepto.angel.peliculas.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the Peliculas database table.
 * 
 */
@Entity
@Table(name="Peliculas")
@NamedQuery(name="Pelicula.findAll", query="SELECT p FROM Pelicula p")
public class Pelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false, length=3)
	private String id;

	@Column(length=255)
	private String actores;

	@Lob
	private String argumento;

	@Column(length=255)
	private String direccion;

	@Column(length=255)
	private String imagen;

	@Column(length=255)
	private String titulo;

	@Column(length=255)
	private String video;

	//bi-directional many-to-many association to Categoria
	@ManyToMany(mappedBy="peliculas")
	private List<Categoria> categorias;

	public Pelicula() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActores() {
		return this.actores;
	}

	public void setActores(String actores) {
		this.actores = actores;
	}

	public String getArgumento() {
		return this.argumento;
	}

	public void setArgumento(String argumento) {
		this.argumento = argumento;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getVideo() {
		return this.video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public List<Categoria> getCategorias() {
		return this.categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

}