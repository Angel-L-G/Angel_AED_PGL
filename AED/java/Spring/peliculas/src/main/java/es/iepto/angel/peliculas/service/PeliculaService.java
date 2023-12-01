package es.iepto.angel.peliculas.service;

import java.util.Optional;

import es.iepto.angel.peliculas.entity.Pelicula;
import es.iepto.angel.peliculas.repository.ICategoriaRepository;
import es.iepto.angel.peliculas.repository.IPeliculaRepository;

public class PeliculaService implements IGenericService<Pelicula, Integer>{
	private IPeliculaRepository peliculaRepository;
	private ICategoriaRepository categoriaRepository;

	@Override
	public Iterable<Pelicula> findAll() {
		return peliculaRepository.findAll();
	}

	
	
	
	@Override
	public Optional<Pelicula> findById(Integer id) {
		Optional<Pelicula> findById = null;
		
		if(id != null) {
			findById = peliculaRepository.findById(id);
		}
	
		return findById;
	}

	@Override
	public Pelicula save(Pelicula element) {
		if(element != null) {
			if(element.getId() != null) {
				peliculaRepository.save(element);
			}
		}
		
		return element;
	}

	@Override
	public void deleteById(Integer id) {
		if(id != null) {
			peliculaRepository.deleteById(id);
		}
	}

	
}
