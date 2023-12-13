package es.iepto.angel.peliculas.dto;

import java.util.List;

import es.iepto.angel.peliculas.entity.Categoria;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

public class PeliculaDTO{
	private Integer id;

	private String actores;

	private String argumento;

	private String direccion;

	private String imagen;
	
	private String nameImagen;

	private String titulo;

	private String trailer;

	private List<Categoria> categorias;

	public PeliculaDTO() {
	}
	
	public PeliculaDTO(Integer id, String actores, String argumento, String direccion, String imagen, String nameImagen,
			String titulo, String trailer, List<Categoria> categorias) {
		super();
		this.id = id;
		this.actores = actores;
		this.argumento = argumento;
		this.direccion = direccion;
		this.imagen = imagen;
		this.setNameImagen(nameImagen);
		this.titulo = titulo;
		this.trailer = trailer;
		this.categorias = categorias;
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

	public String getNameImagen() {
		return nameImagen;
	}

	public void setNameImagen(String nameImagen) {
		this.nameImagen = nameImagen;
	}
}
