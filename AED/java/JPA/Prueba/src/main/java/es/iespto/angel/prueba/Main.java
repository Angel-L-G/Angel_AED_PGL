package es.iespto.angel.prueba;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.iespto.angel.prueba.Persona;

public class Main {

	public static void main(String[] args) {
		System.out.println("hola mundo!");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prueba");
		EntityManager em = emf.createEntityManager();
		Persona find = em.find(Persona.class, 1);
		System.out.println(find.getNombre());
		System.out.println();
		List<Persona> personas = em.createNamedQuery("Persona.findAll",Persona.class).getResultList();
		for (Persona persona : personas) {
			System.out.println(persona.getNombre());
		}
		
	}

}
