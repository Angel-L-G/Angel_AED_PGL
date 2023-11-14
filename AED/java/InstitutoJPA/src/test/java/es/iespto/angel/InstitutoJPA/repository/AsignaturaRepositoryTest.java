package es.iespto.angel.InstitutoJPA.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import es.iespto.angel.InstitutoJPA.entity.Asignatura;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AsignaturaRepositoryTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//EMFSingleton emfSingleton = EMFSingleton.getSingleton();
		//EntityManagerFactory emf = emfSingleton.getEmf();
		emf = Persistence.createEntityManagerFactory("TEST");
		
		asignaturaRepository = new AsignaturaRepository(emf);
	}
	static EntityManagerFactory emf;
	static AsignaturaRepository asignaturaRepository;
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test method for {@link es.iespuertodelacruz.jc.instituto.repository.AlumnoRepository#findById(java.lang.String)}.
	 */
	@Test()
	@Order(1)
	void testFindById() {
		

		Asignatura findById = asignaturaRepository.findById(1);
		assertNotNull(findById);
		//assertTrue(findById.getMatricula().equals("matricula1"));
		//assertTrue(findById.getMarca().equals("marca1"));
		
	}
}
