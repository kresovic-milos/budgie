package com.attozoic.categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryFunction;

@Repository
public interface RepositoryCategoryFunction extends CrudRepository<CategoryFunction, Long> {

	List<CategoryFunction> findAll();
	@SuppressWarnings("unchecked")
	CategoryFunction save(CategoryFunction function);
	
}