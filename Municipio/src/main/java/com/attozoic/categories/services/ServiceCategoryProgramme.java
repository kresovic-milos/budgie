package com.attozoic.categories.services;

import com.attozoic.categories.model.CategoryActivity;
import com.attozoic.categories.model.CategoryProgrammeGoal;

public interface ServiceCategoryProgramme extends ServiceCategoryEntity {
	CategoryProgrammeGoal addCategoryProgrammeGoal(Long uid, CategoryProgrammeGoal categoryProgrammeGoal);
	CategoryActivity addCategoryActivity(Long uid, CategoryActivity categoryActivity);
}