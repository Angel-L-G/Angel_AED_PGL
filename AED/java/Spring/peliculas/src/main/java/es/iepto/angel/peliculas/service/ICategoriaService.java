package es.iepto.angel.peliculas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iepto.angel.peliculas.entity.Categoria;
import es.iepto.angel.peliculas.entity.Pelicula;
import es.iepto.angel.peliculas.repository.ICategoriaRepository;
import es.iepto.angel.peliculas.repository.IPeliculaRepository;
import jakarta.transaction.Transactional;

@Service
public class ICategoriaService implements IGenericService<Categoria, Integer>{
	@Autowired private ICategoriaRepository categoriaRepository;
	@Autowired private IPeliculaRepository peliculaRepository;

	@Override
	public Iterable<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	@Override
	public Optional<Categoria> findById(Integer id) {
		Optional<Categoria> findById = null;
		
		if(id != null) {
			findById = categoriaRepository.findById(id);
		}
	
		return findById;
	}

	@Override
	@Transactional
	public Categoria save(Categoria element) {
		if(element != null) {
			if(element.getId() != null) {
				categoriaRepository.save(element);
			}
		}
		return element;
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		if(id != null) {
			List<Pelicula> findAll = peliculaRepository.findAll();
			Optional<Categoria> findById = categoriaRepository.findById(id);
			
			for (Pelicula pelicula : findAll) {
				if(pelicula.getCategorias().contains(findById)) {
					pelicula.getCategorias().remove(findById);
				}
			}
			
			categoriaRepository.deleteById(id);
		}
	}
	
	@Transactional
	public boolean update(Categoria element) {
		boolean ok = false;
		
		if(element != null) {
			if(element.getId() != null) {
				Optional<Categoria> findById = categoriaRepository.findById(element.getId());
				ok = true;
			}
		}
		
		return ok;
	}

	@Transactional
	public boolean updateNative(Categoria element) {
		boolean ok = false;
		
		if(element != null) {
			if(element.getId() != null) {
				categoriaRepository.updateNtive(element.getNombre(), element.getId());
				ok = true;
			}
		}
		
		return ok;
	}
	
}
