package com.attozoic.categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryFinancialSource;

@Repository
public interface RepositoryCategoryFinancialSource extends CrudRepository<CategoryFinancialSource, Long>{

	List<CategoryFinancialSource> findAll();
	@SuppressWarnings("unchecked")
	CategoryFinancialSource save(CategoryFinancialSource finance);
	
}
