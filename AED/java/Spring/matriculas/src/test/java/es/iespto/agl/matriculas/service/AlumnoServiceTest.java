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

import es.iespto.agl.matriculas.entity.Alumno;
import jakarta.transaction.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
@Sql(scripts = {"/institutoTest.sql"})
public class AlumnoServiceTest {
	@Autowired AlumnoService alumnoService;
	
	@Test
	void contextLoads() {}
	
	@Test
	@Transactional
	void findAllAlumnoService() {
		List<Alumno> findAll = (List<Alumno>) alumnoService.findAll();
		assertNotNull(findAll);
		assertTrue(findAll.size() == 3);
	}
	
	@Test
	@Transactional
	void findByIdAlumnoService() {
		Alumno pel2 = alumnoService.findById("12345678Z").get();
		assertTrue(pel2.getMatriculas().size() == 1);
	}

	
	@Test
	void deletePeliculaService() {
		//borrando elemento con categorias
		alumnoService.deleteById("12312312K");
		Optional<Alumno> opt = alumnoService.findById("12312312K");
		assertTrue(!opt.isPresent());
	}
	
	
	@Test
	void savePeliculaService() {
		Alumno a = new Alumno();

		a.setDni("12345");
		a.setApellidos("1");
		a.setFechanacimiento(1234567889L);
		a.setFoto("2");
		a.setNombre("3");
		
		Alumno save = alumnoService.save(a);
		assertNotNull(a);
		assertTrue(!save.getDni().isBlank());

		Optional<Alumno> findById = alumnoService.findById(a.getDni());
		assertTrue(findById.isPresent());
		
		Alumno found = findById.get();
		
		assertTrue(found.getDni().equals(a.getDni()));
		assertTrue(found.getApellidos().equals(a.getApellidos()));
		assertTrue(found.getFechanacimiento().equals(a.getFechanacimiento()));
		assertTrue(found.getFoto().equals(a.getFoto()));
		assertTrue(found.getNombre().equals(a.getNombre()));
		}
	
	@Test
	void UpdatePeliculaService() {
		Alumno a = new Alumno();

		a.setDni("12345");
		a.setApellidos("1");
		a.setFechanacimiento(1234567889L);
		a.setFoto("2");
		a.setNombre("3");
		
		Alumno save = alumnoService.save(a);
		assertNotNull(save);
		assertTrue(!save.getDni().isBlank());
		
		Alumno a2 = new Alumno();
		
		a2.setDni("12345");
		a2.setApellidos("3");
		a2.setFechanacimiento(987654321L);
		a2.setFoto("1");
		a2.setNombre("2");
		
		boolean bool = alumnoService.update(a2);
		assertTrue(bool);
		
		Optional<Alumno> findById = alumnoService.findById(a2.getDni());
		assertTrue(findById.isPresent());
		
		Alumno found = findById.get();
		
		assertTrue(found.getDni().equals(a2.getDni()));
		assertTrue(found.getApellidos().equals(a2.getApellidos()));
		//ESTE ESTA NEGADO PORQUE LA FECHA NO DEBERIA ACTUALIZARSE; 
		assertTrue(!found.getFechanacimiento().equals(a2.getFechanacimiento()));
		assertTrue(found.getFoto().equals(a2.getFoto()));
		assertTrue(found.getNombre().equals(a2.getNombre()));
	}
}