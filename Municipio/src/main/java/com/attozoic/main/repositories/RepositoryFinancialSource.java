package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.FinancialSource;

@Repository
public interface RepositoryFinancialSource extends CrudRepository<FinancialSource, Long>{

	List<FinancialSource> findAll();
	@SuppressWarnings("unchecked")
	FinancialSource save(FinancialSource finance);
	
}
