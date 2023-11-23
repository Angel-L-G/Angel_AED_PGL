package es.iespto.angel.monedas.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.iespto.angel.monedas.entity.Historicocambioeuro;
import es.iespto.angel.monedas.entity.Moneda;
import model.Coche;
import model.Conductor;

public class Main {

	public static void main(String[] args) {
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("Monedas");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Coche> listaCoches = em.createNamedQuery("Coche.findAll", Coche.class).getResultList();
		List<Conductor> listaConductores = em.createNamedQuery("Conductor.findAll", Conductor.class).getResultList();
		
		Coche c = listaCoches.get(0);
		c.setConductores(listaConductores);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		/*for (Coche c : coches) {
			System.out.println("coche = " + c.getMatricula());
			c.getConductores().forEach(conductor -> System.out.println("conductor = " + conductor.getNombre()));
		}*/
		
		/*Moneda moneda = new Moneda();
		moneda.setNombre("Lira");
		moneda.setPais("Turquía");
		em.getTransaction().begin();;
		em.getTransaction().commit();
		em.persist(moneda);
		em.close();*/
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Monedas");
		EntityManager em = emf.createEntityManager();
		Moneda moneda = new Moneda();
		moneda.setNombre("Lira56");
		moneda.setPais("Turquía");
		em.getTransaction().begin();
		em.persist(moneda);
		
		for (int i = 0; i <3; i++) {
			crearHistoricoDeMoneda(moneda.getIdmoneda(),em);
		}
		
		em.getTransaction().commit();
		em.close();
		System.out.println(moneda);
		System.out.println("lista de histórico: " +
		moneda.getHistoricocambioeuros());
	}
	
	public static Historicocambioeuro crearHistoricoDeMoneda(Integer
			idmoneda,EntityManager em) {
			Moneda moneda = em.find(Moneda.class, idmoneda);
			Historicocambioeuro h = new Historicocambioeuro();
			h.setEquivalenteeuro(new BigDecimal(Math.random()*9));
			h.setFecha(new Date());
			h.setMoneda(moneda);
			EntityTransaction tr= (em.isJoinedToTransaction())?
			null:em.getTransaction();
			if( tr != null)
			tr.begin();
			em.persist(h);
			if( tr != null)
			tr.commit();
			System.out.println(h);
			return h;
		}

}
