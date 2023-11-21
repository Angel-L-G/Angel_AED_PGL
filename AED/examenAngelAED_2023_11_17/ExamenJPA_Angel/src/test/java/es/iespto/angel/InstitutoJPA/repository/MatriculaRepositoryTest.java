package es.iespto.angel.InstitutoJPA.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
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

/**
 * @author Angel
 */
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
	}
	
	@Test
	@Order(2)
	void testFindAll() {
		List<Matricula> todos = matriculaRepository.findAll();
		assertTrue(todos.size()==1);
		
		Matricula a = todos.stream().filter(c->c.getYear() == 2023).findFirst().get();
		assertTrue(a.getId() == 1);
	}
	
	@Test
	@Order(3)
	void testSave() {
		Matricula a = new Matricula();
		a.setYear(2020);
		Matricula save = matriculaRepository.save(a);
		assertNotNull(save);
		
		Matricula findById = matriculaRepository.findById(2);
		assertNotNull(findById);
		assertTrue(findById.getYear() == 2020);
		assertNull(findById.getAlumno());
	}
	
	@Test
	@Order(4)
	void testUpdate() {
		Matricula a = new Matricula();
		a.setYear(2020);
		a.setId(1);
		
		boolean okUpdate = matriculaRepository.update(a);
		assertTrue(okUpdate);
		
		Matricula findById = matriculaRepository.findById(1);
		assertTrue(a.getYear() == findById.getYear());
	}
	
	@Test
	@Order(5)
	void testRemove() {
		boolean okBorrado = matriculaRepository.deleteById(2);
		assertTrue(okBorrado);
		Matricula findById1 = matriculaRepository.findById(2);
		assertNull(findById1);

	}
	
	@Test()
	@Order(6)
	void testFindByIdRel() {
		Matricula findById = matriculaRepository.findByIdRel(1);
		assertNotNull(findById);
		assertTrue(findById.getAlumno().getDni().equals("12345678Z"));
		assertTrue(findById.getYear() == 2023);
		assertTrue(findById.getAsignaturas().size() > 0);
	}
	
	@Test
	@Order(7)
	void testFindAllRel() {
		List<Matricula> todos = matriculaRepository.findAllRel();
		System.out.println(todos.get(0).getYear());
		System.out.println(todos.get(1).getYear());
		assertTrue(todos.size() == 2);
		//assertTrue(todos.size()==1);
		
		Matricula a = todos.stream().filter(c->c.getYear() == 2023).findFirst().get();
		assertTrue(a.getId() == 1);
		assertTrue(a.getAsignaturas().size() > 0);
	}
}
