package mx.org.index.microservicios.app.commonsmicroservicios.services;

import java.util.Optional;


public interface CommonServices<E> {

	public Iterable<E> findAll();
	public Optional<E> findById(Long id);
	public E save(E entity);
	public void deleteById(Long id);
}
