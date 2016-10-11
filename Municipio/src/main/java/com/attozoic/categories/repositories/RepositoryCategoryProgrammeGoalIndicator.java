package com.attozoic.categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryProgrammeGoalIndicator;

@Repository
public interface RepositoryCategoryProgrammeGoalIndicator extends CrudRepository<CategoryProgrammeGoalIndicator, Long> {
	
	List<CategoryProgrammeGoalIndicator> findAll();
	@SuppressWarnings("unchecked")
	CategoryProgrammeGoalIndicator save(CategoryProgrammeGoalIndicator indicator);
}
