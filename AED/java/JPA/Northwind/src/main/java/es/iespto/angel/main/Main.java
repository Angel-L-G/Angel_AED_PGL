package es.iespto.angel.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.iespto.angel.entity.Category;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Northwind");
		EntityManager em = emf.createEntityManager();

		List<Category> resultList = em.createNativeQuery("Select * from categories", Category.class).getResultList();
		
		resultList.forEach(c -> System.out.println(c.getProducts()));
		
		em.close();
		emf.close();
	}

}
