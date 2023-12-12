package es.iepto.angel.peliculas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import es.iepto.angel.peliculas.entity.Categoria;
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
		Pelicula save = null;
		if(element != null) {
			if(element.getId() != null) {
				 save = peliculaRepository.save(element);
				
				List<Categoria> findAll = categoriaRepository.findAll();
				
				for (Categoria categoria : findAll) {
					if(element.getCategorias().contains(categoria)) {
						categoria.getPeliculas().add(element);
					}
				}
			}
		}
		
		return save;
	}
	
	@Transactional
	public boolean updateNative(Pelicula element) {
		boolean ok = false;
		if(element != null) {
			if(element.getId() != null) {
				int updateNtive = peliculaRepository.updateNtive(
							element.getId(), 
							element.getTitulo(), 
							element.getDireccion(), 
							element.getActores(), 
							element.getArgumento(),
							element.getImagen(), 
							element.getTrailer()
						);
				
				List<Categoria> findAll = categoriaRepository.findAll();
				Optional<Pelicula> findById = peliculaRepository.findById(element.getId());
				
				for (Categoria categoria : findAll) {
					if(findById.get().getCategorias().contains(categoria)) {
						categoria.getPeliculas().remove(findById.get());
					}
				}
				
				for (Categoria categoria : findAll) {
					if(findById.get().getCategorias().contains(categoria)) {
						categoria.getPeliculas().add(findById.get());
					}
				}
				
				ok = true;
			}
		}
		
		return ok;
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		if(id != null) {
			List<Categoria> findAll = categoriaRepository.findAll();
			Optional<Pelicula> findById = peliculaRepository.findById(id);
			
			for (Categoria c : findAll) {
				if(c.getPeliculas().contains(findById)) {
					c.getPeliculas().remove(findById);
				}
			}
			
			peliculaRepository.deleteById(id);
		}
	}
	
}
