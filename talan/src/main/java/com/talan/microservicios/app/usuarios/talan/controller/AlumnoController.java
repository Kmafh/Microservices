package com.talan.microservicios.app.usuarios.talan.controller;

import com.tala.microservicios.app.usuarios.models.entity.alumno.Alumno;
import com.talan.microservicios.app.usuarios.common.controller.CommonController;
import com.talan.microservicios.app.usuarios.talan.services.IAlumnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
public class AlumnoController extends CommonController<Alumno, IAlumnoService>{

    @PutMapping("/{id}")
    public ResponseEntity<?> editAlumno(@RequestBody Alumno alumno, @PathVariable Long id){
        Optional<Alumno> o= service.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Alumno alumnoDb = o.get();
        alumnoDb.setName(alumno.getName());
        alumnoDb.setUsername(alumno.getUsername());
        alumnoDb.setEmail(alumno.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
    }
    
    @GetMapping("/buscar/{term}")
    public ResponseEntity<?> buscar(@PathVariable String term){
    	return ResponseEntity.ok(service.findByNameOrSurname(term));
    }

}
