package com.talan.microservicios.app.usuarios.talan.services;

import java.util.List;

import com.tala.microservicios.app.usuarios.models.entity.alumno.Alumno;
import com.talan.microservicios.app.usuarios.common.service.ICommonService;

public interface IAlumnoService extends ICommonService<Alumno>{
	public List<Alumno> findByNameOrSurname(String term);

}
