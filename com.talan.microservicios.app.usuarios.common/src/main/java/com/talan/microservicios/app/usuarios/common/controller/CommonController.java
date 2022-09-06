package com.talan.microservicios.app.usuarios.common.controller;

import com.talan.microservicios.app.usuarios.common.service.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;
@RestController
public class CommonController<E,S extends ICommonService<E>> {

    @Autowired
    protected S service;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(service.findAll());
    }
    
    @GetMapping("/pag")
    public ResponseEntity<?> listar(Pageable pageable){
        return ResponseEntity.ok().body(service.findAll(pageable));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getAlumno(@PathVariable Long id){
        Optional<E> o= service.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(o.get());
    }
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody E entity, BindingResult result){
    	
    	if(result.hasErrors()) {
    		return this.validationEntity(result);
    	}
        E entityDb = service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAlumn( @PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    protected ResponseEntity<?> validationEntity(BindingResult result){
    	Map<String, Object> errores = new HashMap<>();
    	
    	result.getFieldErrors().forEach(err -> {
    		errores.put(err.getField(), "El campo "+err.getField() +" "+ err.getDefaultMessage());
    	});
		return ResponseEntity.badRequest().body(errores);
    }

}
