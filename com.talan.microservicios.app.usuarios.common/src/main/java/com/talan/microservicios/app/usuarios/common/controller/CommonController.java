package com.talan.microservicios.app.usuarios.common.controller;

import com.talan.microservicios.app.usuarios.common.service.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
public class CommonController<E,S extends ICommonService<E>> {

    @Autowired
    protected S service;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(service.findAll());
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
    public ResponseEntity<?> create(@RequestBody E entity){
        E entityDb = service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAlumn( @PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
