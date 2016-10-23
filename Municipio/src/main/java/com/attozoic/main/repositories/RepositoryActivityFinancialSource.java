package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActivityFinancialSource;

@Repository
public interface RepositoryActivityFinancialSource extends CrudRepository<ActivityFinancialSource, Long>{

	List<ActivityFinancialSource> findAll();
	@SuppressWarnings("unchecked")
	ActivityFinancialSource save(ActivityFinancialSource finance);
	
}
