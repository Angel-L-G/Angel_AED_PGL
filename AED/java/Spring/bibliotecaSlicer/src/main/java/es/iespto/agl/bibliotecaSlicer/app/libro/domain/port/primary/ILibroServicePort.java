package es.iespto.agl.bibliotecaSlicer.app.libro.domain.port.primary;

import java.util.List;

import es.iespto.agl.bibliotecaSlicer.app.libro.domain.Libro;

public interface ILibroServicePort {
	List<Libro> findAll();
	Libro save(Libro element);
	
}
