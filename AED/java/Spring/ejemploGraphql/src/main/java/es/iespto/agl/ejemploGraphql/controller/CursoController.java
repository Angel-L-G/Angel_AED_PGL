package es.iespto.agl.ejemploGraphql.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CursoController {
	@QueryMapping
	public List<Curso> cursos() {
		Curso c1 = new Curso();
		c1.setId(1); c1.setNombre("AED"); c1.setCategoria("DAM");
		Curso c2 = new Curso();
		c2.setId(2); c2.setNombre("PGL"); c2.setCategoria("DAM");
		
		return Arrays.asList(c1,c2);
	}
	
	@QueryMapping
	public Curso findById(@Argument int id) {
		
		return null;
	}
}

class Curso{
	public Curso() {}
	int id;
	String nombre;
	String categoria;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}