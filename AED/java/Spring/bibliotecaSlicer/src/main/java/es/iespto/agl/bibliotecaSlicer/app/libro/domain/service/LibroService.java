package es.iespto.agl.bibliotecaSlicer.app.libro.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iespto.agl.bibliotecaSlicer.app.libro.domain.Libro;
import es.iespto.agl.bibliotecaSlicer.app.libro.domain.port.primary.ILibroServicePort;
import es.iespto.agl.bibliotecaSlicer.app.libro.domain.port.secundary.ILibroRepositoryPort;

@Service
public class LibroService implements ILibroServicePort{
	@Autowired
	ILibroRepositoryPort libroRepository;

	@Override
	public List<Libro> findAll() {
		return libroRepository.findAll();
	}

	@Override
	public Libro save(Libro element) {
		return libroRepository.save(element);
	}
}
