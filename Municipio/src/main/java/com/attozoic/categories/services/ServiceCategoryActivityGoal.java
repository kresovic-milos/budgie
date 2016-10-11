package com.attozoic.categories.services;

import org.springframework.data.domain.Page;

import com.attozoic.categories.model.CategoryActivityGoal;

public interface ServiceCategoryActivityGoal {

	Page<CategoryActivityGoal> findAll();
	CategoryActivityGoal save(CategoryActivityGoal goal);
	
}
