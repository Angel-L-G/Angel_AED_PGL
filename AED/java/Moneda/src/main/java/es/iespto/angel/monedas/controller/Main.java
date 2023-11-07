package es.iespto.angel.monedas.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.iespto.angel.monedas.entity.Moneda;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Monedas");
		EntityManager em = emf.createEntityManager();

		List<Moneda> resultList = em.createNamedQuery("Select * from moneda", Moneda.class).getResultList();
		
		Moneda moneda = new Moneda();
		moneda.setNombre("Lira");
		moneda.setPais("Turquía");
		em.getTransaction().begin();;
		em.getTransaction().commit();
		em.persist(moneda);
		em.close();
	}

}
