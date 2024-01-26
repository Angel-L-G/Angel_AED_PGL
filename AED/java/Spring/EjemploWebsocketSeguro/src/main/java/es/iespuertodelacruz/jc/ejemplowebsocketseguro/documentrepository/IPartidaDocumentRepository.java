package es.iespuertodelacruz.jc.ejemplowebsocketseguro.documentrepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.iespuertodelacruz.jc.ejemplowebsocketseguro.document.PartidaDocument;

@Repository
public interface IPartidaDocumentRepository extends MongoRepository<PartidaDocument, String>{

}
