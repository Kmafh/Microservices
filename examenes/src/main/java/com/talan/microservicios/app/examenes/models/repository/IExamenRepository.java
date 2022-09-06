package com.talan.microservicios.app.examenes.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.talan.microservicios.commons.examenes.models.entity.Examen;

public interface IExamenRepository extends PagingAndSortingRepository<Examen, Long>{

	@Query("Select e from Examen e where e.name like %?1%")
	public List<Examen> findByName(String term);
}
