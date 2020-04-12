package mx.org.index.microservicios.app.usuarios.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mx.org.index.microservicios.app.commonsmicroservicios.controllers.CommonController;
import mx.org.index.microservicios.app.usuarios.model.entity.Alumno;
import mx.org.index.microservicios.app.usuarios.services.AlumnosServices;

@RestController
public class AlumnoController extends CommonController<Alumno, AlumnosServices> {

	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id){
		Optional<Alumno> o = service.findById(id);
		System.out.println("Alumno que encontramos en la BD " + o.get() );
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Alumno alumnoDB = o.get();
		alumnoDB.setNombre(alumno.getNombre());
		alumnoDB.setApellido(alumno.getApellido());
		alumnoDB.setEmail(alumno.getEmail());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDB));
		
	}
	
}
