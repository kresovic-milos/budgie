package com.attozoic.categories.services;

import org.springframework.data.domain.Page;

import com.attozoic.categories.model.CategoryProgrammeGoalIndicator;

public interface ServiceCategoryProgrammeGoalIndicator {

	Page<CategoryProgrammeGoalIndicator> findAll();
	CategoryProgrammeGoalIndicator save(CategoryProgrammeGoalIndicator indicator);
	
}
