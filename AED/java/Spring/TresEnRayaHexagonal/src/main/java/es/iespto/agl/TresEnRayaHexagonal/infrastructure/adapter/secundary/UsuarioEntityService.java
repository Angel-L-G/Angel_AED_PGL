package es.iespto.agl.TresEnRayaHexagonal.infrastructure.adapter.secundary;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iespto.agl.TresEnRayaHexagonal.domain.model.Partida;
import es.iespto.agl.TresEnRayaHexagonal.domain.model.Usuario;
import es.iespto.agl.TresEnRayaHexagonal.domain.port.secundary.IUsuarioRepository;


@Service
public class UsuarioEntityService implements IUsuarioRepository{
	@Autowired UsuarioEntityRepository usuariorepository;
	UsuarioEntityMapper um = new UsuarioEntityMapper();

	@Override
	public Usuario findById(Integer id) {
		return um.toDomain(usuariorepository.findById(id).get());
	}

	@Override
	public Usuario save(Usuario u) {
		return um.toDomain(usuariorepository.save(um.toPersistence(u)));
	}

	@Override
	public Iterable<Usuario> findAll() {
		List<UsuarioEntity> findAll = usuariorepository.findAll();
		List<Usuario> find = new ArrayList<>();
		
		for (UsuarioEntity pe : findAll) {
			find.add(um.toDomain(pe));
		}
		
		return find;
	}

	@Override
	public void deleteById(Integer id) {
		usuariorepository.deleteById(id);
	}

	@Override
	public boolean update(Usuario u) {
		return false;
	}
	
	public Usuario findByName(String n) {
		return um.toDomain(usuariorepository.findByName(n));
	}
	
	public Usuario findByEmail(String e) {
		return um.toDomain(usuariorepository.findByEmail(e));
	}

	@Override
	public Usuario findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}
}
