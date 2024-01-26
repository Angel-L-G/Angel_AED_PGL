package es.iespuertodelacruz.jc.ejemplowebsocketseguro.document.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iespuertodelacruz.jc.ejemplowebsocketseguro.document.PartidaDocument;
import es.iespuertodelacruz.jc.ejemplowebsocketseguro.documentrepository.IPartidaDocumentRepository;

@Service
public class PartidaDocumentService {
	@Autowired IPartidaDocumentRepository partidarepository;
	
	public PartidaDocument findById(String id) {
		return partidarepository.findById(id).orElse(null);
	}
	
	public List<PartidaDocument> findAll(){
		return partidarepository.findAll();
	}
	
	public PartidaDocument save(PartidaDocument pd) {
		return partidarepository.save(pd);
	}
}
