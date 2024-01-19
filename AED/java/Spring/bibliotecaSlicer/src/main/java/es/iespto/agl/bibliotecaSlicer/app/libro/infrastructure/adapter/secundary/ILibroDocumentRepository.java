package es.iespto.agl.bibliotecaSlicer.app.libro.infrastructure.adapter.secundary;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibroDocumentRepository extends MongoRepository<LibroDocument, String>{

	
	
}