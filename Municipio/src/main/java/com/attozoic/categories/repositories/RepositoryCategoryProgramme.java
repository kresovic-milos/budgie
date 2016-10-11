package com.attozoic.categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryProgramme;

@Repository
public interface RepositoryCategoryProgramme extends CrudRepository<CategoryProgramme, Long> {

	List<CategoryProgramme> findAll();
	@SuppressWarnings("unchecked")
	CategoryProgramme save(CategoryProgramme programme);
	
}
