package com.talan.microservicios.app.usuarios.talan.models.repository;


import org.springframework.data.repository.CrudRepository;

import com.tala.microservicios.app.usuarios.models.entity.alumno.Alumno;

public interface IAlumnoRespository extends CrudRepository<Alumno,Long> {

}
