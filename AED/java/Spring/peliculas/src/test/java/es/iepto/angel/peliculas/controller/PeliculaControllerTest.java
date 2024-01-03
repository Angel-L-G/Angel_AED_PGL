package es.iepto.angel.peliculas.controller;

//import is()
import static org.hamcrest.CoreMatchers.is;
//import hasSize()
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

import es.iepto.angel.peliculas.config.ApplicationNoSecurity;
import es.iepto.angel.peliculas.controller.v3.PeliculaController;
import es.iepto.angel.peliculas.entity.Pelicula;
import es.iepto.angel.peliculas.service.IFileStorageService;
import es.iepto.angel.peliculas.service.IPeliculaService;

@ActiveProfiles("test")
@WebMvcTest(PeliculaController.class)
@Import(ApplicationNoSecurity.class)
public class PeliculaControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper mapper;

	@MockBean
	IPeliculaService peliculaService;

	@MockBean
	IFileStorageService fileStorageService;

	@Test
	public void findAllTest() throws Exception {
		Pelicula p1 = new Pelicula(); p1.setId(1); p1.setTitulo("uno");
		Pelicula p2 = new Pelicula(); p2.setId(1); p2.setTitulo("dos");
		List<Pelicula> peliculas = List.of( p1,p2 );
	
		when(peliculaService.findAll()).thenReturn(peliculas);
    
        mockMvc.perform(
    			MockMvcRequestBuilders
    				.get("/api/v1/peliculas")
    				.contentType(MediaType.APPLICATION_JSON)
    		)
    		.andExpect(status().isOk())
    		.andExpect(jsonPath("$",hasSize(2)))
    		.andExpect(jsonPath("$[1].titulo", is("dos")));
    		;
	}

}