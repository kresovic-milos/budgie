package com.attozoic.categories.services;

import com.attozoic.categories.model.CategoryActivityGoal;

public interface ServiceCategoryActivity extends ServiceCategoryEntity {
	CategoryActivityGoal addCategoryActivityGoal(Long uid, CategoryActivityGoal categoryActivityGoal);
}
