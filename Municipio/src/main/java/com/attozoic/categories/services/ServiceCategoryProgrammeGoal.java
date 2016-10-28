package com.attozoic.categories.services;

import com.attozoic.categories.model.CategoryProgrammeGoalIndicator;

public interface ServiceCategoryProgrammeGoal extends ServiceCategoryEntity {
	CategoryProgrammeGoalIndicator addCategoryProgrammeGoalIndicator(Long uid, CategoryProgrammeGoalIndicator categoryProgrammeGoalIndicator);
}
