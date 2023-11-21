package es.iespto.angel.InstitutoJPA.repository;

import java.util.List;

/**
 * @author Angel
 */
public interface ICRUD<T,E> {
	List<T> findAll();
	T findById(E id);
	boolean deleteById(E id);
	boolean update(T entity);
	T save(T entity);
}
