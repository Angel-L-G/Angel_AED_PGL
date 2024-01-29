package es.iespto.agl.TresEnRayaHexagonal.infrastructure.adapter.secundary;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//@Repository
public interface UsuarioDocumentRepository extends MongoRepository<UsuarioDocument, String>{
	
	@Query("{'nombre': ? 0}")
    public UsuarioDocument findByNombre(@Param("nombre") String nombre);

    @Query("{'email': ?0}")
    public UsuarioDocument findByEmail(@Param("email") String email);
    
}
