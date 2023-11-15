package es.iespto.angel.InstitutoJPA.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import es.iespto.angel.InstitutoJPA.entity.Asignatura;
import es.iespto.angel.InstitutoJPA.entity.Matricula;

public class MatriculaRepositoryTest {
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//EMFSingleton emfSingleton = EMFSingleton.getSingleton();
		//EntityManagerFactory emf = emfSingleton.getEmf();
		emf = Persistence.createEntityManagerFactory("TEST");
		
		matriculaRepository = new MatriculaRepository(emf);
	}
	static EntityManagerFactory emf;
	static MatriculaRepository matriculaRepository;
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@Test()
	@Order(1)
	void testFindById() {
		Matricula findById = matriculaRepository.findById(1);
		assertNotNull(findById);
		assertTrue(findById.getAlumno().getDni().equals("12345678Z"));
		assertTrue(findById.getYear() == 2023);
		assertTrue(findById.getAsignaturaMatriculas().size() == 1);
	}
	
	@Test
	@Order(2)
	void testFindAll() {
		List<Matricula> todos = matriculaRepository.findAll();
		assertTrue(todos.size()==2);
		
		/*Asignatura a = todos.stream().filter(c->c.getYear() == BAE).findFirst().get();
		assertTrue(a.getCurso().equals("1º DAM"));	
		
		a = todos.stream().filter(c->c.getNombre().equals("PGV")).findFirst().get();
		assertTrue(a.getCurso().equals("2º DAM"));	*/
	}
}
