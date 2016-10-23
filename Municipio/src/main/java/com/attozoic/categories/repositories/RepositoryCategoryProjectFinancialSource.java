package com.attozoic.categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryProjectFinancialSource;

@Repository
public interface RepositoryCategoryProjectFinancialSource extends CrudRepository<CategoryProjectFinancialSource, Long>{

	List<CategoryProjectFinancialSource> findAll();
	@SuppressWarnings("unchecked")
	CategoryProjectFinancialSource save(CategoryProjectFinancialSource finance);
	
}
