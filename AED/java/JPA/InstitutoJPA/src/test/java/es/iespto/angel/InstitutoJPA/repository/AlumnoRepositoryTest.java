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

import es.iespto.angel.InstitutoJPA.entity.Alumno;
import es.iespto.angel.InstitutoJPA.entity.Asignatura;

public class AlumnoRepositoryTest {
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//EMFSingleton emfSingleton = EMFSingleton.getSingleton();
		//EntityManagerFactory emf = emfSingleton.getEmf();
		emf = Persistence.createEntityManagerFactory("TEST");
		
		alumnoRepository = new AlumnoRepository(emf);
	}
	static EntityManagerFactory emf;
	static AlumnoRepository alumnoRepository;
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@Test()
	@Order(1)
	void testFindById() {
		Alumno findById = alumnoRepository.findById("12345678Z");
		assertNotNull(findById);
		assertTrue(findById.getNombre().equals("Ana"));
		assertTrue(findById.getApellidos().equals("Martín"));
		assertTrue(findById.getFechanacimiento() == 968972400000L);
		
	}
	
	@Test
	@Order(2)
	void testFindAll() {
		List<Alumno> todos = alumnoRepository.findAll();
		assertTrue(todos.size()==3);
		
		Alumno a = todos.stream().filter(c->c.getNombre().equals("Ana")).findFirst().get();
		assertTrue(a.getApellidos().equals("Martín"));
		assertTrue(a.getFechanacimiento() == 968972400000L);
		
		a = todos.stream().filter(c->c.getNombre().equals("Marcos")).findFirst().get();
		assertTrue(a.getApellidos().equals("Afonso Jiménez"));
		assertTrue(a.getFechanacimiento() == 874278000000L);	
	}
	
	@Test
	@Order(3)
	void testSave() {

		Alumno a = new Alumno();
		a.setDni("999999999D");
		a.setNombre("nombrePrueba");
		a.setApellidos("apellidoPrueba");
		a.setFechanacimiento(968972400000L);
		Alumno save = alumnoRepository.save(a);
		assertNotNull(save);
		
		Alumno findById = alumnoRepository.findById("999999999D");
		assertNotNull(findById);
		assertTrue(findById.getApellidos().equals("apellidoPrueba"));
		assertTrue(findById.getNombre().equals("nombrePrueba"));
		assertTrue(findById.getFechanacimiento() == 968972400000L);
	}
	
	@Test
	@Order(4)
	void testUpdate() {
		Alumno a = new Alumno();
		a.setApellidos("apellidosmodificados");
		a.setDni("999999999D");
		a.setNombre("nombreModificado");
		a.setFechanacimiento(99999999999L);
		
		boolean okUpdate = alumnoRepository.update(a);
		assertTrue(okUpdate);
		
		Alumno findById = alumnoRepository.findById("999999999D");
		assertTrue(a.getNombre().equals(findById.getNombre()));
		assertTrue(a.getApellidos().equals(findById.getApellidos()));
		assertTrue(a.getFechanacimiento().longValue() == findById.getFechanacimiento().longValue());
	}
	
	@Test
	@Order(5)
	void testRemove() {
		boolean okBorrado = alumnoRepository.deleteById("87654321X");
		assertTrue(okBorrado);
		Alumno findById1 = alumnoRepository.findById("87654321X");
		assertNull(findById1);

	}
	
}
