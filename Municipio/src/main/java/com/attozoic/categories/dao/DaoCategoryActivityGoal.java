package com.attozoic.categories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryActivityGoal;
import com.attozoic.categories.model.CategoryActivityGoalIndicator;
import com.attozoic.categories.repositories.RepositoryCategoryActivityGoal;
import com.attozoic.categories.repositories.RepositoryCategoryEntity;

@Repository
public class DaoCategoryActivityGoal extends DaoCategoryEntity {

	@Autowired
	private RepositoryCategoryActivityGoal repoActivityGoal;

	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryCategoryEntity getCategoryRepoEntity() {
		return repoActivityGoal;
	}
	
	@SuppressWarnings("unchecked")
	public CategoryActivityGoalIndicator addCategoryActivityGoalIndicator(Long uid, CategoryActivityGoalIndicator categoryActivityGoalIndicator) {
		CategoryActivityGoal categoryActivityGoal = (CategoryActivityGoal) getCategoryRepoEntity().findOne(uid);
		categoryActivityGoalIndicator.setCategoryActivityGoal(categoryActivityGoal);
		return (CategoryActivityGoalIndicator) getCategoryRepoEntity().save(categoryActivityGoalIndicator);
	}
	
}
