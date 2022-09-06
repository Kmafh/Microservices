package com.talan.microservicios.app.usuarios.talan.controller;

import com.tala.microservicios.app.usuarios.models.entity.alumno.Alumno;
import com.talan.microservicios.app.usuarios.common.controller.CommonController;
import com.talan.microservicios.app.usuarios.talan.services.IAlumnoService;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

import javax.annotation.Resource;
import javax.validation.Valid;
@RestController
public class AlumnoController extends CommonController<Alumno, IAlumnoService>{

	
	@GetMapping("/uploads/img/{id}")
	public ResponseEntity<?> getImage(@PathVariable Long id){
		
		Optional<Alumno> o= service.findById(id);
        if(o.isEmpty()|| o.get().getImage()==null){
            return ResponseEntity.notFound().build();
        }
        
        ByteArrayResource img =  new ByteArrayResource(o.get().getImage());
        
        return ResponseEntity.ok()
        		.contentType(MediaType.IMAGE_JPEG)
        		.body(img);
	}
    @PutMapping("/{id}")
    public ResponseEntity<?> editAlumno(@Valid @RequestBody Alumno alumno,BindingResult result, @PathVariable Long id){
    	if(result.hasErrors()) {
    		return this.validationEntity(result);
    	}
    	
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

	@PostMapping("/crear-foto")
	public ResponseEntity<?> createWhitImage(@Valid Alumno alumno, BindingResult result, @RequestParam MultipartFile archivo) throws IOException {
		if(!archivo.isEmpty()) {
			alumno.setImage(archivo.getBytes());
		}
		return super.create(alumno, result);
	}
	@PutMapping("/edita-image/{id}")
    public ResponseEntity<?> editAlumnoWithImage(@Valid Alumno alumno,BindingResult result, 
    		@PathVariable Long id, @RequestParam MultipartFile archivo) throws IOException{
    	if(result.hasErrors()) {
    		return this.validationEntity(result);
    	}
    	
    	Optional<Alumno> o= service.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Alumno alumnoDb = o.get();
        alumnoDb.setName(alumno.getName());
        alumnoDb.setUsername(alumno.getUsername());
        alumnoDb.setEmail(alumno.getEmail());
        
        if(!archivo.isEmpty()) {
        	alumnoDb.setImage(archivo.getBytes());
		}
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
    }

    
}
