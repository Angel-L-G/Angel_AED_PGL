package es.iespto.agl.TresEnRayaHexagonal.infrastructure.adapter.secundary;

import es.iespto.agl.TresEnRayaHexagonal.domain.model.Usuario;

public class UsuarioEntityMapper {
	public Usuario toDomain(UsuarioEntity u) {
		Usuario user = new Usuario();
		
		user.setId(u.getId()+"");
		user.setActive(u.getAtive());
		user.setEmail(u.getEmail());
		user.setHash(u.getHash());
		user.setNombre(u.getNombre());
		user.setPassword(u.getPassword());
		user.setRol(u.getRol());
		
		return user;
	}
	
	public UsuarioEntity toPersistence(Usuario u) {
		UsuarioEntity user = new UsuarioEntity();
		
		//user.setId(Integer.parseInt(u.getId()));
		user.setActive(u.getAtive());
		user.setEmail(u.getEmail());
		user.setHash(u.getHash());
		user.setNombre(u.getNombre());
		user.setPassword(u.getPassword());
		user.setRol(u.getRol());
		
		return user;
	}
}
