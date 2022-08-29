package com.talan.microservicios.app.usuarios.common.service;

import java.util.Optional;

public interface ICommonService<E> {

    public Iterable<E> findAll();
    public Optional<E>  findById(Long id);
    public E save(E entity);
    public void deleteById(Long id);

}
