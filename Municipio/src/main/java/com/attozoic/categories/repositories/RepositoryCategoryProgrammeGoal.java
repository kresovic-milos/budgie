package com.attozoic.categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryProgrammeGoal;

@Repository
public interface RepositoryCategoryProgrammeGoal extends CrudRepository<CategoryProgrammeGoal, Long> {


	
	List<CategoryProgrammeGoal> findAll();
	@SuppressWarnings("unchecked")
	CategoryProgrammeGoal save(CategoryProgrammeGoal goal);
	
}
