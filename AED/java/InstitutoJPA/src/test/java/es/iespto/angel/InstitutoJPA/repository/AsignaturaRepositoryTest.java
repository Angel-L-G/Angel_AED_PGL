package es.iespto.angel.InstitutoJPA.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

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


	@Test()
	@Order(1)
	void testFindById() {
		Asignatura findById = asignaturaRepository.findById(1);
		assertNotNull(findById);
		assertTrue(findById.getNombre().equals("BAE"));
		assertTrue(findById.getCurso().equals("1º DAM"));
		
	}
	
	@Test
	@Order(2)
	void testFindAll() {
		List<Asignatura> todos = asignaturaRepository.findAll();
		assertTrue(todos.size()==8);
		
		Asignatura a = todos.stream().filter(c->c.getNombre().equals("BAE")).findFirst().get();
		assertTrue(a.getCurso().equals("1º DAM"));	
		
		a = todos.stream().filter(c->c.getNombre().equals("PGV")).findFirst().get();
		assertTrue(a.getCurso().equals("2º DAM"));	
	}
	
	@Test
	@Order(3)
	void testSave() {

		Asignatura a = new Asignatura();
		a.setNombre("asigPrueba");
		a.setCurso("cursoPrueba");
		Asignatura save = asignaturaRepository.save(a);
		assertNotNull(save);
		
		Asignatura findById = asignaturaRepository.findById(9);
		assertNotNull(findById);
		assertTrue(findById.getCurso().equals("cursoPrueba"));
		assertTrue(findById.getNombre().equals("asigPrueba"));
	}
	
	@Test
	@Order(4)
	void testUpdate() {
		Asignatura a = new Asignatura();
		a.setCurso("cursomodificado");
		a.setId(1);
		a.setNombre("nombreModificado");
		
		boolean okUpdate = asignaturaRepository.update(a);
		assertTrue(okUpdate);
		
		Asignatura findById = asignaturaRepository.findById(1);
		assertTrue(a.getNombre().equals(findById.getNombre()));
		assertTrue(a.getCurso().equals(findById.getCurso()));
	}
	
	@Test
	@Order(5)
	void testRemove() {
		boolean okBorrado = asignaturaRepository.deleteById(1);
		assertTrue(okBorrado);
		Asignatura findById1 = asignaturaRepository.findById(1);
		assertNull(findById1);

	}

}
