package com.talan.microservicios.app.usuarios.talan.models.repository;

import com.talan.microservicios.app.usuarios.talan.models.entity.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface IAlumnoRespository extends CrudRepository<Alumno,Long> {

}
