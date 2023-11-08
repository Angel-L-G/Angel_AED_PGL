package es.iespuertodelacruz.angel.miproyecto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.iespuertodelacruz.angel.miproyecto.entity.Persona;

public class Main {

	public static void main(String[] args) {
		System.out.println("hola mundo!");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PBVB");
		EntityManager em = emf.createEntityManager();
		Persona find = em.find(Persona.class, 1);
		System.out.println(find.getNombre());
	}

}
