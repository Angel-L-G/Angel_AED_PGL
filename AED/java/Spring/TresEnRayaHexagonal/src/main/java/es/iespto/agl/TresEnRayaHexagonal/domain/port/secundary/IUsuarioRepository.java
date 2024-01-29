package es.iespto.agl.TresEnRayaHexagonal.domain.port.secundary;

import es.iespto.agl.TresEnRayaHexagonal.domain.model.Partida;
import es.iespto.agl.TresEnRayaHexagonal.domain.model.Usuario;

public interface IUsuarioRepository {
	Usuario findById(Integer id);
	Usuario save(Usuario u);
	Iterable<Usuario> findAll();
	void deleteById(Integer id);
	boolean update(Usuario u);
	public Usuario findByName(String n);
	public Usuario findByEmail(String e);
	
	
	Usuario findById(String id);
	void deleteById(String id);
}
