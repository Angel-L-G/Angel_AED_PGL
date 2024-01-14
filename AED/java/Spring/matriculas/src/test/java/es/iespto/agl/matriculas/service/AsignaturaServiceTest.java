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
import jakarta.transaction.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
@Sql(scripts = {"/institutoTest.sql"})
public class AsignaturaServiceTest {
	@Autowired AsignaturaService asignaturaService;
	
	@Test
    void contextLoads() {}

    @Test
    @Transactional
    void findAllAsignaturaService() {
        List<Asignatura> findAll = (List<Asignatura>) asignaturaService.findAll();
        assertNotNull(findAll);
        assertTrue(findAll.size() == 8);
    }

    @Test
    @Transactional
    void findByIdAsignaturaService() {
    	Asignatura c2 = asignaturaService.findById(2).get();
    	assertNotNull(c2);
        assertTrue(c2.getNombre().equals("PGV"));
        assertTrue(c2.getCurso().equals("2º DAM"));
    }

    @Test
    void deleteByIdAsignaturaService() {
    	asignaturaService.deleteById(1);
        Optional<Asignatura> opt = asignaturaService.findById(1);
        assertTrue(!opt.isPresent());
    }

    @Test
    void saveAsignaturaService() {
    	Asignatura c = new Asignatura();
        c.setId(1);
        c.setNombre("ABC");
        c.setCurso("1 ABC");

        Asignatura save = asignaturaService.save(c);
        assertTrue(save != null);
        assertTrue(save.getId() > 0);
    }
    
    @Test
    void UpdateAsignaturaService() {
    	Asignatura c = new Asignatura();
        c.setId(2);
        c.setNombre("ABCD");
        c.setCurso("1 ABCD");

        Asignatura save = asignaturaService.save(c);
        assertTrue(save != null);
        assertTrue(save.getId() > 0);
        assertTrue(save.getNombre().equals(c.getNombre()));
        assertTrue(save.getCurso().equals(c.getCurso()));
        
        Asignatura c2 = new Asignatura();
        c2.setId(save.getId());
        c2.setCurso("123");
        c2.setNombre("123");
        
        boolean update = asignaturaService.updateNative(c2);
        assertTrue(update);
        
        Asignatura findById = asignaturaService.findById(c2.getId()).get();
        
        assertNotNull(findById);
        assertTrue(findById.getId() > 0);
        System.out.println(findById.getNombre() +" "+ c2.getNombre());
        assertTrue(findById.getNombre().equals(c2.getNombre()));
        assertTrue(findById.getCurso().equals(c2.getCurso()));
        
    }
}
