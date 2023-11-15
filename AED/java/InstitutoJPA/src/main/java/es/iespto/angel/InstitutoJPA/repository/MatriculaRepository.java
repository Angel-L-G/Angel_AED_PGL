package es.iespto.angel.InstitutoJPA.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import es.iespto.angel.InstitutoJPA.entity.Asignatura;
import es.iespto.angel.InstitutoJPA.entity.AsignaturaMatricula;
import es.iespto.angel.InstitutoJPA.entity.Matricula;

public class MatriculaRepository  implements ICRUD<Matricula, Integer>{
	private EntityManagerFactory emf;
	
	public MatriculaRepository(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<Matricula> findAll() {
		EntityManager em = emf.createEntityManager();
		List<Matricula> lista = em.createNamedQuery("Matricula.findAll",Matricula.class).getResultList();
		//Mirar si hay que traerse toda la tabla intermedia aqui
		em.close();
		return lista;
	}

	@Override
	public Matricula findById(Integer id) {
		Matricula res = null;
		
		if(id != null) {
			EntityManager em = emf.createEntityManager();
			res = em.find(Matricula.class, id);
			if(res.getAsignaturaMatriculas().size()>0)
			
			em.close();
		}
		
		return res;
	}

	@Override
	public boolean deleteById(Integer id) {
		boolean ok = false;
		
		if(id != null) {
			EntityManager em = emf.createEntityManager();
			
			Matricula find = em.find(Matricula.class, id);
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
	public boolean update(Matricula entity) {
		boolean ok = false;
		
		if(entity != null) {
			EntityManager em = emf.createEntityManager();
			
			Matricula update = em.find(Matricula.class, entity.getId());
			//Revisar esta linea
			if(update != null && update.getAsignaturaMatriculas() != null) {
				em.getTransaction().begin();
				update.setYear(entity.getYear());
				update.setAsignaturaMatriculas(entity.getAsignaturaMatriculas());
				//Posibilidad de updatear el alumno?
				em.getTransaction().commit();
				em.close();
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
			//Preguntar si al ser un id autoincremental te lo 
			//devuelve auto o lo tienes que recojer tu
			em.persist(entity);
			//Revisar linea siguiente
			//em.persist(entity.getAsignaturaMatriculas());
			em.getTransaction().commit();
			em.close();
			
			res = entity;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return res;
	}
}
