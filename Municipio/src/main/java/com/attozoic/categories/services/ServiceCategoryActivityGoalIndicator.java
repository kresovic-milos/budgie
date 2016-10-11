package com.attozoic.categories.services;

import org.springframework.data.domain.Page;

import com.attozoic.categories.model.CategoryActivityGoalIndicator;

public interface ServiceCategoryActivityGoalIndicator {

	Page<CategoryActivityGoalIndicator> findAll();
	CategoryActivityGoalIndicator save(CategoryActivityGoalIndicator indicator);
}
