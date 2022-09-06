package com.talan.microservicios.app.examenes.services;


import java.util.List;

import com.talan.microservicios.app.usuarios.common.service.ICommonService;
import com.talan.microservicios.commons.examenes.models.entity.Asignatura;
import com.talan.microservicios.commons.examenes.models.entity.Examen;

public interface IExamenService extends ICommonService<Examen>{

	public List<Examen> findByName(String term);
	
	public Iterable<Asignatura> findAllAsignaturas();
}
