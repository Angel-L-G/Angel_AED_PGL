package es.iespto.agl.bibliotecaSlicer.app.libro.infrastructure.adapter.secundary;

import es.iespto.agl.bibliotecaSlicer.app.libro.domain.Libro;

public class LibroDocumentMapper {
	public Libro toDomain(LibroDocument ld) {
		Libro l = null;
		
		if(ld != null) {
			l = new Libro();
			l.setId(ld.getId());
			l.setPaginas(ld.getPaginas());
			l.setTitulo(ld.getTitulo());
		}
		
		return l;
	}
	
	public LibroDocument toPersistence(Libro l) {
		LibroDocument ld = null;
		
		if(l != null) {
			ld = new LibroDocument();
			ld.setId(l.getId());
			ld.setPaginas(l.getPaginas());
			ld.setTitulo(l.getTitulo());
		}
		
		return ld;
	}
}
