package com.attozoic.categories.services;

import org.springframework.data.domain.Page;

import com.attozoic.categories.model.CategoryProgrammeGoal;

public interface ServiceCategoryProgrammeGoal {

	CategoryProgrammeGoal findByUid(Long uid);
	Page<CategoryProgrammeGoal> findAll();
	CategoryProgrammeGoal save(CategoryProgrammeGoal goal);
}
