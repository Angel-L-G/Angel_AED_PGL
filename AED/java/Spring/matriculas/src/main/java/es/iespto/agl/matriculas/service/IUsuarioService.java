package es.iespto.agl.matriculas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iespto.agl.matriculas.entity.Alumno;
import es.iespto.agl.matriculas.entity.Usuario;
import es.iespto.agl.matriculas.repository.IUsuarioRepository;
import jakarta.transaction.Transactional;

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
	
	public Usuario findByEmail(String email) {
		return usuariorepository.findByEmail(email);
	}
	
	@Transactional
	public boolean update(Usuario element) {
		boolean ok = false;
		if(element != null) {
			if(element.getId() != null) {
				Usuario findById = usuariorepository.findById(element.getId()).get();
				
				findById.setEmail(element.getEmail());
				findById.setPassword(element.getPassword());
				
				if(element.getRol() != null) {
					findById.setActive(element.getActive());
					findById.setRol(element.getRol());
				}
				
				ok = true;
			}
		}	
		return ok;
	}
	
	@Transactional
	public List<String> findAllEmail(){
		return usuariorepository.findAllEmails();
	}
}
