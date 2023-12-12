package es.iepto.angel.peliculas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import es.iepto.angel.peliculas.entity.Pelicula;
import es.iepto.angel.peliculas.repository.ICategoriaRepository;
import es.iepto.angel.peliculas.repository.IPeliculaRepository;
import jakarta.transaction.Transactional;

@Service
public class IPeliculaService implements IGenericService<Pelicula, Integer>{
	@Autowired private IPeliculaRepository peliculaRepository;
	@Autowired private ICategoriaRepository categoriaRepository;

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
	@Transactional
	public Pelicula save(Pelicula element) {
		if(element != null) {
			if(element.getId() != null) {
				peliculaRepository.save(element);
			}
		}
		
		return element;
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		if(id != null) {
			peliculaRepository.deleteById(id);
		}
	}

	//NATIVOS ----------------------------------------------
	
	/*public Iterable<Pelicula> findAllNative() {
		return peliculaRepository.findAllNative();
	}
	
	public Optional<Pelicula> findByIdNative(Integer id) {
		Optional<Pelicula> findById = null;
		
		if(id != null) {
			findById = peliculaRepository.findByIdNative(id);
		}
	
		return findById;
	}
	
	public Pelicula saveNative(Pelicula element) {
		if(element != null) {
			if(element.getId() != null) {
				peliculaRepository.saveNative(element);
			}
		}
		
		return element;
	}
	
	public void deleteByIdNative(Integer id) {
		if(id != null) {
			peliculaRepository.DeleteByIdNative(id);
		}
	}
	
	public boolean updateNative(Pelicula element) {
		boolean ok = false;
		
		if(element != null) {
			if(element.getId() != null) {
				peliculaRepository.saveNative(element);
				ok = true;
			}
		}
		
		return ok;
	}*/
}
