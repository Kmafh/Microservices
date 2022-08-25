package com.talan.microservicios.app.usuarios.talan.services;

import com.talan.microservicios.app.usuarios.common.service.CommonServiceImp;
import com.talan.microservicios.app.usuarios.talan.models.entity.Alumno;
import com.talan.microservicios.app.usuarios.talan.models.repository.IAlumnoRespository;
import org.springframework.stereotype.Service;


@Service
public class AlumnoServiceImp extends CommonServiceImp<Alumno, IAlumnoRespository> implements IAlumnoService{
    
}
