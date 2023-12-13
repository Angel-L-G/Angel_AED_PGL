package es.iepto.angel.peliculas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iepto.angel.peliculas.entity.Usuario;
import es.iepto.angel.peliculas.repository.IUsuarioRepository;

@Service
public class IUsuarioService implements IGenericService<Usuario, Integer> {
	@Autowired
	IUsuarioRepository usuariorepository;

	@Override
	public Iterable<Usuario> findAll() {
		return usuariorepository.findAll();
	}

	@Override
	public Optional<Usuario> findById(Integer id) {
		return usuariorepository.findById(id);
	}

	@Override
	public Usuario save(Usuario element) {
		return usuariorepository.save(element);
	}

	@Override
	public void deleteById(Integer id) {
		usuariorepository.deleteById(id);
	}

	public Usuario findByName(String nombre) {
		return usuariorepository.findByName(nombre);
	}
}
