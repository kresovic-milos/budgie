package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProgrammeFinancialSource;

@Repository
public interface RepositoryProgrammeFinancialSource extends CrudRepository<ProgrammeFinancialSource, Long>{

	List<ProgrammeFinancialSource> findAll();
	@SuppressWarnings("unchecked")
	ProgrammeFinancialSource save(ProgrammeFinancialSource finance);
	
}
