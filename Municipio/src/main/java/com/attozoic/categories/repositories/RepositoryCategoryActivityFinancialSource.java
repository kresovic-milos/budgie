package com.attozoic.categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryActivityFinancialSource;

@Repository
public interface RepositoryCategoryActivityFinancialSource extends CrudRepository<CategoryActivityFinancialSource, Long>{

	List<CategoryActivityFinancialSource> findAll();
	@SuppressWarnings("unchecked")
	CategoryActivityFinancialSource save(CategoryActivityFinancialSource finance);
	
}
