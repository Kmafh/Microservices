package com.talan.microservicios.app.examenes.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.talan.microservicios.app.examenes.services.IExamenService;
import com.talan.microservicios.app.usuarios.common.controller.CommonController;
import com.talan.microservicios.commons.examenes.models.entity.Examen;

@RestController
public class ExamenController extends CommonController<Examen, IExamenService>{

	
	@PutMapping("/{id}")
	public ResponseEntity<?> modify(@RequestBody Examen examen,@PathVariable Long id){
		
		Optional<Examen> o = service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Examen examenDb = o.get();
		examenDb.setName(examen.getName());
		examenDb.getPreguntas()
		.stream()
		.filter(p ->!examen.getPreguntas().contains(p))
		.forEach(examenDb::removePregunta);
		
		examenDb.setPreguntas(examen.getPreguntas());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenDb));
		
	}
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrar(@PathVariable String term){
		return ResponseEntity.ok(service.findByName(term));
	}
	
	@GetMapping("/asignaturas")
	public ResponseEntity<?> listarAsignaturas(){
		return ResponseEntity.ok(service.findAllAsignaturas());
	}
}
