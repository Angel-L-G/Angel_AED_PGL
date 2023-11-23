package es.iespto.angel.InstitutoJPA.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import es.iespto.angel.InstitutoJPA.entity.Alumno;
import es.iespto.angel.InstitutoJPA.entity.Asignatura;
import es.iespto.angel.InstitutoJPA.entity.Matricula;

/**
 * @author Angel
 */
public class AlumnoRepository  implements ICRUD<Alumno, String>{
	private EntityManagerFactory emf;
	
	public AlumnoRepository(EntityManagerFactory emf){
		this.emf = emf;
	}

	@Override
	public List<Alumno> findAll() {
		EntityManager em = emf.createEntityManager();
		List<Alumno> lista = em.createNamedQuery("Alumno.findAll",Alumno.class).getResultList();
		
		em.close();
		return lista;
	}

	@Override
	public Alumno findById(String id) {
		Alumno res = null;
		
		if(id != null) {
			EntityManager em = emf.createEntityManager();
			res = em.find(Alumno.class, id);
			
			em.close();
		}
		
		return res;
	}

	@Override
	public boolean deleteById(String id) {
		boolean ok = false;
		System.out.println("id: " + id);
		if(id != null) {
			EntityManager em = emf.createEntityManager();
			
			Alumno find = em.find(Alumno.class, id);
			if(find != null) {
				em.getTransaction().begin();
				em.remove(find);
				em.getTransaction().commit();
				ok = true;
			}
		}
		
		return ok;
	}

	@Override
	public boolean update(Alumno entity) {
		boolean ok = false;
		
		if(entity != null) {
			EntityManager em = emf.createEntityManager();
			
			Alumno update = em.find(Alumno.class, entity.getDni());
			if(update != null && update.getMatriculas() != null) {
				em.getTransaction().begin();
				update.setNombre(entity.getNombre());
				update.setApellidos(entity.getApellidos());
				update.setFechanacimiento(entity.getFechanacimiento());
				//Mirar si hay que ponerlo por el otro lado tambien
				//(MATRICULA) 
				em.getTransaction().commit();
				em.close();
				ok = true;
			}
		}
		
		return ok;
	}

	@Override
	public Alumno save(Alumno entity) {
		Alumno res = null;

		try{
			if(entity.getMatriculas() == null) {
				EntityManager em = emf.createEntityManager();

				em.getTransaction().begin();

				em.persist(entity);

				em.getTransaction().commit();
				em.close();

				res = entity;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return res;
	}

	public Alumno findBySubName(String subName) {
		Alumno res = null;
		
		if(subName != null) {
			EntityManager em = emf.createEntityManager();
			res = em.find(Alumno.class, subName);
			em.close();
		}
		
		return res;
	}
	
	
	public boolean deleteByIdRel(String id) {
		boolean ok = false;
		System.out.println("id: " + id);
		if(id != null) {
			EntityManager em = emf.createEntityManager();
			
			Alumno find = em.find(Alumno.class, id);
			if(find != null) {
				em.getTransaction().begin();
				//List<Matricula> matriculas = find.getMatriculas();
				
				if(find.getMatriculas() != null && find.getMatriculas().size() > 0) {
					//MatriculaRepository mr = new MatriculaRepository(emf);
					for (Matricula m : find.getMatriculas()) {
						//mr.deleteById(m.getId());
						em.remove(m);
						System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
						System.out.println(find.getMatriculas().get(0) == null);
					}
					
				}
				find.getMatriculas().clear();
				em.remove(find);
				em.getTransaction().commit();
				ok = true;
			}
		}
		
		return ok;
	}
}
