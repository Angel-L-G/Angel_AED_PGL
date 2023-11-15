package es.iespto.angel.InstitutoJPA.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import es.iespto.angel.InstitutoJPA.entity.Asignatura;
import es.iespto.angel.InstitutoJPA.entity.AsignaturaMatricula;

public class AsignaturaRepository implements ICRUD<Asignatura, Integer>{
	private EntityManagerFactory emf;
	
	public AsignaturaRepository(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<Asignatura> findAll() {
		EntityManager em = emf.createEntityManager();
		List<Asignatura> lista = em.createNamedQuery("Asignatura.findAll",Asignatura.class).getResultList();
		
		em.close();
		return lista;
	}

	@Override
	public Asignatura findById(Integer id) {
		Asignatura res = null;
		
		if(id != null) {
			EntityManager em = emf.createEntityManager();
			res = em.find(Asignatura.class, id);
			
			em.close();
		}
		
		return res;
	}

	@Override
	public boolean deleteById(Integer id) {
		boolean ok = false;
		
		if(id != null) {
			EntityManager em = emf.createEntityManager();
			
			Asignatura find = em.find(Asignatura.class, id);
			if(find != null) {
				em.getTransaction().begin();
				em.remove(find);
				List<AsignaturaMatricula> lista = find.getAsignaturaMatriculas();
				if(lista.size() > 0) {
					for (AsignaturaMatricula am : lista) {
						em.remove(am);
					}
				}
				em.getTransaction().commit();
				ok = true;
			}
		}
		
		return ok;
	}

	@Override
	public boolean update(Asignatura entity) {
		boolean ok = false;
		
		if(entity != null) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Asignatura update = em.find(Asignatura.class, entity.getId());
			//Revisar esta linea
			if(update != null && update.getAsignaturaMatriculas() != null) {
				update.setCurso(entity.getCurso());
				update.setNombre(entity.getNombre());
				ok = true;
			}
			em.getTransaction().commit();
			em.close();
		}
		
		return ok;
	}

	@Override
	public Asignatura save(Asignatura entity) {
		Asignatura res = null;
		
		try{
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			em.close();
			
			res = entity;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return res;
	}
	
	
}
