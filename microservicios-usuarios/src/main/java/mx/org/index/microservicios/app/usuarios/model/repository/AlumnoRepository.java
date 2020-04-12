package mx.org.index.microservicios.app.usuarios.model.repository;

import org.springframework.data.repository.CrudRepository;

import mx.org.index.microservicios.app.usuarios.model.entity.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno, Long>{
	

}
