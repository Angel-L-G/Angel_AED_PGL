package es.iepto.angel.peliculas.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=255)
	private String actores;

	@Column(nullable=false, length=255)
	private String argumento;

	@Column(nullable=false, length=255)
	private String direccion;

	@Column(nullable=false, length=255)
	private String imagen;

	@Column(nullable=false, length=255)
	private String titulo;

	@Column(nullable=false, length=255)
	private String trailer;

	@ManyToMany(fetch= FetchType.LAZY)
	@JoinTable(
		name="Pelicula_Categoria"
		, joinColumns={
			@JoinColumn(name="pelicula_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="categoria_id")
			}
		)
	private List<Categoria> categorias;

	public Pelicula() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	public String getTrailer() {
		return this.trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public List<Categoria> getCategorias() {
		return this.categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", actores=" + actores + ", argumento=" + argumento + ", direccion=" + direccion
				+ ", imagen=" + imagen + ", titulo=" + titulo + ", trailer=" + trailer + "]";
	}
	
	

}