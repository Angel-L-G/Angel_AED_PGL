package es.iespto.agl.bibliotecaSlicer.app.libro.infrastructure.adapter.secundary;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iespto.agl.bibliotecaSlicer.app.libro.domain.Libro;
import es.iespto.agl.bibliotecaSlicer.app.libro.domain.port.secundary.ILibroRepositoryPort;

@Service
public class LibroDocumentService implements ILibroRepositoryPort{
	@Autowired
	ILibroDocumentRepository documentRepository;
	
	LibroDocumentMapper mapper = new LibroDocumentMapper();
	
	@Override
	public List<Libro> findAll() {
		List<LibroDocument> lista = documentRepository.findAll();
		
		return lista.stream()
			.map(ld-> mapper.toDomain(ld))
			.collect(Collectors.toList());
	}

	@Override
	public Libro save(Libro element) {
		LibroDocument ld = mapper.toPersistence(element);
		
		LibroDocument save = documentRepository.save(ld);
		
		return mapper.toDomain(save);
	}

}
