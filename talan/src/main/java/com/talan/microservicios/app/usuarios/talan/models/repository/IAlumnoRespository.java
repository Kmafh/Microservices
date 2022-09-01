package com.talan.microservicios.app.usuarios.talan.models.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tala.microservicios.app.usuarios.models.entity.alumno.Alumno;

public interface IAlumnoRespository extends CrudRepository<Alumno,Long> {

	@Query("select a from Alumno a where a.name like %?1% or a.username like %?1%")
	public List<Alumno> findByNameOrSurname(String term);
}
