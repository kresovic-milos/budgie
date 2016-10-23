package com.attozoic.categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryProgrammeFinancialSource;

@Repository
public interface RepositoryCategoryProgrammeFinancialSource extends CrudRepository<CategoryProgrammeFinancialSource, Long>{

	List<CategoryProgrammeFinancialSource> findAll();
	@SuppressWarnings("unchecked")
	CategoryProgrammeFinancialSource save(CategoryProgrammeFinancialSource finance);
	
}
