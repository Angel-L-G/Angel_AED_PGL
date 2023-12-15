package es.iepto.angel.peliculas.service;

import es.iepto.angel.peliculas.entity.Categoria;
import es.iepto.angel.peliculas.entity.Pelicula;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
@Sql(scripts = {"/peliculas.sql"})
public class CategoriaServiceTest {
    @Autowired
    IokPeliculaRepository okRepository;
    @Autowired ICategoriaService categoriaService;

    @Test
    void contextLoads() {
    }

    @Test
    @Transactional
    void findAllService() {
        List<Categoria> findAll = (List<Categoria>) categoriaService.findAll();
        assertNotNull(findAll);
        assertTrue(findAll.size() == 10);
    }

    @Test
    @Transactional
    void findAllWithRelService() {
        List<Categoria> findAll = (List<Categoria>) categoriaService.findAll();
        assertNotNull(findAll);
        assertTrue(findAll.size() == 10);
        Optional<Categoria> opt = findAll.stream()
                .filter(p->p.getId() == 2)
                .findFirst();
        Categoria c = opt.get();
        assertTrue(!c.getPeliculas().isEmpty());
    }

    @Test
    @Transactional
    void findByIdWithRelCategoriaService() {
        Categoria c2 = categoriaService.findById(2).get();
        assertTrue(!c2.getPeliculas().isEmpty());
    }


    @Test
    void deleteWithRelCategoriaService() {
        //borrando elemento con categorias
        categoriaService.deleteById(1);
        /*Optional<Categoria> opt = IokCategoriaRepository.findByIdWithRel(1);
        assertTrue(!opt.isPresent());

        //borrando elemento sin categorias
        categoriaService.deleteById(13);
        opt = IokCategoriaRepository.findByIdWithRel(13);
        assertTrue(!opt.isPresent());*/
    }


    @Test
    void saveCategoriaService() {
        Pelicula pelicula = new Pelicula();

        pelicula.setActores("actor, actriz");
        pelicula.setArgumento("argumento");
        pelicula.setDireccion("dirección");
        pelicula.setImagen("imagen");
        pelicula.setTitulo("título");
        pelicula.setTrailer("trailer");

        Categoria c = new Categoria();
        c.setId(1);
        c.setNombre("Drama");

        List<Pelicula> p = new ArrayList<Pelicula>();
        p.add(pelicula);
        c.setPeliculas(p);

        Categoria save = categoriaService.save(c);
        assertTrue(save != null);
        assertTrue(save.getId() > 0);

        Optional<Pelicula> opt = okRepository.findByIdWithRel(save.getId());
        Pelicula found = opt.get();
        assertNotNull(found);

        assertTrue(save != null);
        assertTrue(save.getId() > 0);
        assertTrue(save.getNombre() == "Drama");

        pelicula = new Pelicula();
        pelicula.setActores("1actor, actriz");
        pelicula.setArgumento("1argumento");
        pelicula.setDireccion("1dirección");
        pelicula.setImagen("1imagen");
        pelicula.setTitulo("1título");
        pelicula.setTrailer("1trailer");

        Categoria categoria = new Categoria();
        categoria.setId(1);
        categoria.setNombre("Drama");

        p = new ArrayList<Pelicula>();
        p.add(pelicula);
        categoria.setPeliculas(p);

        save = categoriaService.save(c);
        assertTrue(save != null);
        assertTrue(save.getId() > 0);

        opt = okRepository.findByIdWithRel(save.getId());
        found = opt.get();
        assertNotNull(found);

        categoria.setId(1);
        categoria.setNombre("Drama");

        /*for (int id : List.of(1, 2)) {
            boolean anyMatch = found.getCategorias()
                    .stream()
                    .anyMatch(p -> p.getId() == id);

            assertTrue(anyMatch);
        }*/
    }
}
/*
interface IokCategoriaRepository extends JpaRepository<Categoria, Integer> {
    @Query(
        value = "select c from categoria c "
                + "left join fetch c.peliculas "
                + "where c.id = :id"
    )
    Optional<Categoria> findByIdWithRel(int id);
}*/
