package es.iespto.agl.TresEnRayaHexagonal.infrastructure.adapter.secundary;

import es.iespto.agl.TresEnRayaHexagonal.domain.model.Usuario;

public class UsuarioDocumentMapper {
	public Usuario toDomain(UsuarioDocument u) {
		Usuario user = new Usuario();
		
		user.setId(u.getId());
		user.setActive(u.getAtive());
		user.setEmail(u.getEmail());
		user.setHash(u.getHash());
		user.setNombre(u.getNombre());
		user.setPassword(u.getPassword());
		user.setRol(u.getRol());
		
		return user;
	}
	
	public UsuarioDocument toPersistence(Usuario u) {
		UsuarioDocument user = new UsuarioDocument();
		
		user.setId(u.getId());
		user.setActive(u.getAtive());
		user.setEmail(u.getEmail());
		user.setHash(u.getHash());
		user.setNombre(u.getNombre());
		user.setPassword(u.getPassword());
		user.setRol(u.getRol());
		
		return user;
	}
}
