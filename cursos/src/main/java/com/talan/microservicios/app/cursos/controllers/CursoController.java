package com.talan.microservicios.app.cursos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tala.microservicios.app.usuarios.models.entity.alumno.Alumno;
import com.talan.microservicios.app.cursos.models.entity.Curso;
import com.talan.microservicios.app.cursos.services.ICursoService;
import com.talan.microservicios.app.usuarios.common.controller.CommonController;
import com.talan.microservicios.commons.examenes.models.entity.Examen;

@RestController
public class CursoController extends CommonController<Curso,ICursoService>{

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Curso curso, @PathVariable Long id){
		
		Optional<Curso> o = this.service.findById(id);
		if(!o.isPresent()) return ResponseEntity.notFound().build();
		
		Curso dbCurso = o.get();
		dbCurso.setNombre(curso.getNombre());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
	}
	
	@PutMapping("/{id}/asignar")
	public ResponseEntity<?> asignAlumnos(@RequestBody List<Alumno> alumnos, @PathVariable Long id){
		
		Optional<Curso> o = this.service.findById(id);
		if(!o.isPresent()) return ResponseEntity.notFound().build();
		
		Curso dbCurso = o.get();
		
		alumnos.forEach(a -> {
			dbCurso.addAlumno(a);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
	}
	@PutMapping("/{id}/dell")
	public ResponseEntity<?> dellAlumno(@RequestBody Alumno alumno, @PathVariable Long id){
		
		Optional<Curso> o = this.service.findById(id);
		if(!o.isPresent()) return ResponseEntity.notFound().build();
		
		Curso dbCurso = o.get();
		dbCurso.removeAlumnos(alumno);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
	}
	
	@GetMapping("/alumno/{id}")
	public ResponseEntity<?> searhByAlumnoId(@PathVariable Long id){
		Curso curso= service.findCrusoByAlumnoId(id);
		return ResponseEntity.ok(curso);
	}
	
	@PutMapping("/{id}/asignar-exam")
	public ResponseEntity<?> asignExam(@RequestBody List<Examen> examenes, @PathVariable Long id){
		
		Optional<Curso> o = this.service.findById(id);
		if(!o.isPresent()) return ResponseEntity.notFound().build();
		
		Curso dbCurso = o.get();
		
		examenes.forEach(a -> {
			dbCurso.addExamen(a);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
	}
	
	@PutMapping("/{id}/dell-exam")
	public ResponseEntity<?> dellExam(@RequestBody Examen examen, @PathVariable Long id){
		
		Optional<Curso> o = this.service.findById(id);
		if(!o.isPresent()) return ResponseEntity.notFound().build();
		
		Curso dbCurso = o.get();
		dbCurso.removeExamen(examen);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
	}
}
