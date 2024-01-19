package es.iespto.agl.bibliotecaSlicer.app.libro.domain.port.secundary;

import java.util.List;

import es.iespto.agl.bibliotecaSlicer.app.libro.domain.Libro;

public interface ILibroRepositoryPort {
	List<Libro> findAll();
	Libro save(Libro element);
	
}
