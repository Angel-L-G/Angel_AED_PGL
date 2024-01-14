package es.iespto.agl.matriculas.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import es.iespto.agl.matriculas.entity.Asignatura;
import es.iespto.agl.matriculas.entity.Matricula;
import jakarta.transaction.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
@Sql(scripts = {"/institutoTest.sql"})
public class MatriculaServiceTest {
	@Autowired MatriculaService matriculaService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	@Transactional
	void findAllService() {
		List<Matricula> findAll = (List<Matricula>) matriculaService.findAll();
		assertNotNull(findAll);
		assertTrue(findAll.size() == 1);
	}	
	
	@Test
	@Transactional
	void findByIdMatriculaService() {
		Matricula pel2 = matriculaService.findById(1).get();
		assertTrue(pel2.getAsignaturas().size() == 1);
	}
	
	@Test
	void deleteMatriculaService() {
		//borrando elemento con asignaturas
		matriculaService.deleteById(1);
		Optional<Matricula> opt = matriculaService.findById(1);
		assertTrue(!opt.isPresent());
		
		//borrando elemento sin asignaturas
		matriculaService.deleteById(3);
		opt = matriculaService.findById(3);
		assertTrue(!opt.isPresent());		
	}
	
	@Test
	void saveMatriculaService() {
		Matricula matricula = new Matricula();

		matricula.setId(0);
		matricula.setYear(1000);

		Matricula save = matriculaService.save(matricula);
		assertTrue(save != null);
		assertTrue(save.getId() > 0);

		Optional<Matricula> opt = matriculaService.findById(save.getId());
		Matricula found = opt.get();
		assertNotNull(found);
		assertTrue(found.getYear().equals(matricula.getYear()));

		matricula = new Matricula();
		matricula.setId(0);
		matricula.setYear(2222);

		matricula.setAsignaturas(new ArrayList<Asignatura>());
		Asignatura asignatura = new Asignatura();
		asignatura.setId(1);
		matricula.getAsignaturas().add(asignatura);

		asignatura = new Asignatura();
		asignatura.setId(2);
		matricula.getAsignaturas().add(asignatura);

		save = matriculaService.save(matricula);
		assertTrue(save != null);
		assertTrue(save.getId() > 0);

		opt = matriculaService.findById(save.getId());
		found = opt.get();
		assertNotNull(found);
		assertTrue(found.getYear().equals(matricula.getYear()));
		assertTrue(found.getAsignaturas().size() == 2);

		for (int id : List.of(1, 2)) {
			boolean anyMatch = found.getAsignaturas()
					.stream()
					.anyMatch(p -> p.getId() == id);

			assertTrue(anyMatch);
		}
	}
	
	@Test
	@Transactional
	void UpdateMatriculaService() {
		//SAVE
		Matricula matricula = new Matricula();
		matricula.setId(0);
		matricula.setYear(2222);

		matricula.setAsignaturas(new ArrayList<Asignatura>());
		Asignatura asignatura = new Asignatura();
		asignatura.setId(1);
		matricula.getAsignaturas().add(asignatura);

		asignatura = new Asignatura();
		asignatura.setId(2);
		matricula.getAsignaturas().add(asignatura);

		Matricula save = matriculaService.save(matricula);
		assertTrue(save != null);
		assertTrue(save.getId() > 0);
		//FIN SAVE
		
		//UPDATE
		matricula = new Matricula();
		matricula.setId(save.getId());
		matricula.setYear(3333);

		matricula.setAsignaturas(new ArrayList<Asignatura>());
		asignatura = new Asignatura();
		asignatura.setId(3);
		matricula.getAsignaturas().add(asignatura);

		asignatura = new Asignatura();
		asignatura.setId(4);
		matricula.getAsignaturas().add(asignatura);

		asignatura = new Asignatura();
		asignatura.setId(5);
		matricula.getAsignaturas().add(asignatura);
		
		boolean bool = matriculaService.updateNative(matricula);
		//FIN UPDATE

		//COMPROVACIONES
		assertTrue(bool);
		
		Optional<Matricula> opt = matriculaService.findById(save.getId());
		Matricula found = opt.get();
		
		assertNotNull(found);
		assertTrue(found.getYear().equals(matricula.getYear()));
		assertTrue(found.getAsignaturas().size() == 3);

		for (int id : List.of(3, 4, 5)) {
			boolean anyMatch = found.getAsignaturas()
					.stream()
					.anyMatch(p -> p.getId() == id);

			assertTrue(anyMatch);
		}
	}
}
