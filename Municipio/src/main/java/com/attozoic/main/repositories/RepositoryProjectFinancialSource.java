package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProjectFinancialSource;

@Repository
public interface RepositoryProjectFinancialSource extends CrudRepository<ProjectFinancialSource, Long>{

	List<ProjectFinancialSource> findAll();
	@SuppressWarnings("unchecked")
	ProjectFinancialSource save(ProjectFinancialSource finance);
	
}
