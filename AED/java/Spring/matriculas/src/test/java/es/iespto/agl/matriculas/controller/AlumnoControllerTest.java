package es.iespto.agl.matriculas.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.iespto.agl.matriculas.config.ApplicationNoSecurity;
import es.iespto.agl.matriculas.controller.v2.AlumnoControllerV2;
import es.iespto.agl.matriculas.entity.Alumno;
import es.iespto.agl.matriculas.service.AlumnoService;

@ActiveProfiles("test")
@WebMvcTest(AlumnoControllerV2.class)
@Import(ApplicationNoSecurity.class)
public class AlumnoControllerTest {
	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper mapper;

	@MockBean
	AlumnoService alumnoService;
	
	@Test
	public void findAllTest() throws Exception {
		Alumno a1 = new Alumno(); a1.setDni("1"); a1.setNombre("uno");
		Alumno a2 = new Alumno(); a2.setDni("2"); a2.setNombre("dos");
		List<Alumno> alumnos = List.of( a1,a2 );
	
		when(alumnoService.findAll()).thenReturn(alumnos);
    
        mockMvc.perform(
    			MockMvcRequestBuilders
    				.get("/api/v1/alumnos")
    				.contentType(MediaType.APPLICATION_JSON)
    		)
    		.andExpect(status().isOk())
    		.andExpect(jsonPath("$",hasSize(2)))
    		.andExpect(jsonPath("$[1].titulo", is("dos")));
    		;
	}
}
