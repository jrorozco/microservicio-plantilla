package mx.org.index.microservicios.app.usuarios.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.org.index.microservicios.app.commonsmicroservicios.services.CommonServiceImpl;
import mx.org.index.microservicios.app.usuarios.model.entity.Alumno;
import mx.org.index.microservicios.app.usuarios.model.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository>  implements AlumnosServices{

}
