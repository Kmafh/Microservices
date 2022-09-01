package com.talan.microservicios.app.usuarios.talan.services;

import com.tala.microservicios.app.usuarios.models.entity.alumno.Alumno;
import com.talan.microservicios.app.usuarios.common.service.CommonServiceImp;
import com.talan.microservicios.app.usuarios.talan.models.repository.IAlumnoRespository;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AlumnoServiceImp extends CommonServiceImp<Alumno, IAlumnoRespository> implements IAlumnoService{

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findByNameOrSurname(String term) {
		
		return repository.findByNameOrSurname(term);
	}
    
}
