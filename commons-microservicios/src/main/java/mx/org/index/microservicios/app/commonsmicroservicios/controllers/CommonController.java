package mx.org.index.microservicios.app.commonsmicroservicios.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import mx.org.index.microservicios.app.commonsmicroservicios.services.CommonServices;

public class CommonController<E, S extends CommonServices<E>> {

	@Autowired
	protected S service;
	
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){
		Optional<E> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		E entity = o.get();
		return ResponseEntity.ok(entity);
		
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody E entity){
		E alumnoDB =service.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDB);
		
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
