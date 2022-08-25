package com.talan.microservicios.app.cursos.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.talan.microservicios.app.cursos.models.entity.Curso;

import com.talan.microservicios.app.cursos.services.ICursoService;
import com.talan.microservicios.app.usuarios.common.controller.CommonController;

@RestController
public class CursoController extends CommonController<Curso, ICursoService>{

	@PutMapping("/{id}")
	public ResponseEntity<?> modify(@RequestBody Curso curso,@PathVariable Long id){
		Optional<Curso> o= this.service.findById(id);
		if(!o.isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		Curso dbCurso = o.get();
		dbCurso.setId(curso.getId());
		dbCurso.setName(curso.getName());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
	}
	
	
}
