package com.attozoic.categories.services;

import com.attozoic.categories.model.CategoryActivityGoalIndicator;

public interface ServiceCategoryActivityGoal extends ServiceCategoryEntity {
	CategoryActivityGoalIndicator addCategoryActivityGoalIndicator(Long uid, CategoryActivityGoalIndicator categoryActivityGoalIndicator);
}
