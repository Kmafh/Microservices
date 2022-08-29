package com.talan.microservicios.app.usuarios.common.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public class CommonServiceImp<E,R extends CrudRepository<E,Long>> implements ICommonService<E>{
    @Autowired
    protected R repository;
    @Override
    @Transactional(readOnly = true)
    public Iterable<E> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public E save(E entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
            repository.deleteById(id);
    }
}
