package com.talan.microservicios.app.examenes.services;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.talan.microservicios.app.examenes.models.repository.AsignaturaRepository;
import com.talan.microservicios.app.examenes.models.repository.IExamenRepository;
import com.talan.microservicios.app.usuarios.common.service.CommonServiceImp;
import com.talan.microservicios.commons.examenes.models.entity.Asignatura;
import com.talan.microservicios.commons.examenes.models.entity.Examen;

@Service
public class ExamenServiceImp extends CommonServiceImp<Examen, IExamenRepository > implements IExamenService{

	@Autowired
	private AsignaturaRepository asignaturaRepository;
	@Override
	@Transactional(readOnly = true)
	public List<Examen> findByName(String term) {
		return repository.findByName(term);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Asignatura> findAllAsignaturas() {
		
		return asignaturaRepository.findAll();
	}

}
