package com.talan.microservicios.app.cursos.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.talan.microservicios.app.cursos.models.entity.Curso;

public interface ICursoRepository extends CrudRepository<Curso, Long>{

}
