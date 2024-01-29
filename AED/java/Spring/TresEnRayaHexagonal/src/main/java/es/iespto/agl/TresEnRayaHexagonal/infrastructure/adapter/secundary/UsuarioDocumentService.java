package es.iespto.agl.TresEnRayaHexagonal.infrastructure.adapter.secundary;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iespto.agl.TresEnRayaHexagonal.domain.model.Usuario;
import es.iespto.agl.TresEnRayaHexagonal.domain.port.secundary.IUsuarioRepository;

//@Service
public class UsuarioDocumentService implements IUsuarioRepository{
	@Autowired UsuarioDocumentRepository usuariorepository;
	UsuarioDocumentMapper um = new UsuarioDocumentMapper();

	@Override
	public Usuario findById(String id) {
		return um.toDomain(usuariorepository.findById(id).get());
	}

	@Override
	public Usuario save(Usuario u) {
		return um.toDomain(usuariorepository.save(um.toPersistence(u)));
	}

	@Override
	public Iterable<Usuario> findAll() {
		List<UsuarioDocument> findAll = usuariorepository.findAll();
		List<Usuario> find = new ArrayList<>();
		
		for (UsuarioDocument pe : findAll) {
			find.add(um.toDomain(pe));
		}
		
		return find;
	}

	@Override
	public void deleteById(String id) {
		usuariorepository.deleteById(id);
	}

	@Override
	public boolean update(Usuario u) {
		return false;
	}
	
	public Usuario findByName(String n) {
		return um.toDomain(usuariorepository.findByNombre(n));
	}
	
	public Usuario findByEmail(String e) {
		return um.toDomain(usuariorepository.findByEmail(e));
	}

	@Override
	public Usuario findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}
}
