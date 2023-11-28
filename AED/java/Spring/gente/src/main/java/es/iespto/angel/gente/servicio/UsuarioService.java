package es.iespto.angel.gente.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import es.iespto.angel.gente.entity.Usuario;
import es.iespto.angel.gente.repository.IPersonaRepository;
import es.iespto.angel.gente.repository.IUsuarioRepository;
import jakarta.transaction.Transactional;

public class UsuarioService implements IGenericService<Usuario, Integer>{
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Override
	@Transactional()
	public Iterable<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	@Override
	@Transactional()
	public Optional<Usuario> findById(Integer id) {
	return usuarioRepository.findById(id);
	}

	@Override
	public Usuario save(Usuario element) {
		
		return usuarioRepository.save(element);
	}

	@Override
	public void deleteById(Integer id) {
		
		usuarioRepository.deleteById(id);
	}
}
