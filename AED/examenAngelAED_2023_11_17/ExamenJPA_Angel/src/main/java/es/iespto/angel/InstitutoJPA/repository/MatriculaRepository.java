package es.iespto.angel.InstitutoJPA.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import es.iespto.angel.InstitutoJPA.entity.Asignatura;
import es.iespto.angel.InstitutoJPA.entity.Matricula;

/**
 * @author Angel
 */
public class MatriculaRepository  implements ICRUD<Matricula, Integer>{
	private EntityManagerFactory emf;
	
	public MatriculaRepository(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<Matricula> findAll() {
		EntityManager em = emf.createEntityManager();
		List<Matricula> lista = em.createNamedQuery("Matricula.findAll",Matricula.class).getResultList();
		em.close();
		return lista;
	}
	
	
	public List<Matricula> findAllRel() {
		EntityManager em = emf.createEntityManager();
		List<Matricula> lista = em.createNamedQuery("Matricula.findAll", Matricula.class).getResultList();
		for (Matricula m: lista) {
			m.getAsignaturas().size();
		}
		em.close();
		return lista;
	}

	@Override
	public Matricula findById(Integer id) {
		Matricula res = null;
		
		if(id != null) {
			EntityManager em = emf.createEntityManager();
			res = em.find(Matricula.class, id);
			
			em.close();
		}
		
		return res;
	}
	
	public Matricula findByIdRel(Integer id) {
		Matricula res = null;
		
		if(id != null) {
			EntityManager em = emf.createEntityManager();
			res = em.find(Matricula.class, id);
			if(res.getAsignaturas().size() > 0){}
			em.close();
		}
		
		return res;
	}

	@Override
	public boolean deleteById(Integer id) {
		boolean ok = false;
		
		if(id != null) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Matricula find = em.find(Matricula.class, id);
			if(find != null) {
				if(find.getAsignaturas() != null && find.getAsignaturas().size() > 0) {
					List<Asignatura> asignaturas = find.getAsignaturas();
					for (Asignatura asignatura : asignaturas) {
						asignatura.getMatriculas().remove(find);
					}
					find.getAsignaturas().clear();;
				}
				em.remove(find);
				
				ok = true;
			}
			em.getTransaction().commit();
			em.close();
		}
		
		return ok;
	}
	
	@Override
	public boolean update(Matricula entity) {
		boolean ok = false;
		
		if(entity != null) {
			EntityManager em = emf.createEntityManager();
			
			Matricula update = em.find(Matricula.class, entity.getId());
			if(update != null) {
				em.getTransaction().begin();
				update.setYear(entity.getYear());
				if(entity.getAsignaturas() != null && !(entity.getAsignaturas().equals(update.getAsignaturas()))) {
					update.getAsignaturas().clear();
					update.setAsignaturas(entity.getAsignaturas());
				}
				em.getTransaction().commit();
				em.close();

				ok = true;
			}
		}
		
		return ok;
	}

	@Override
	public Matricula save(Matricula entity) {
		Matricula res = null;
		
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
