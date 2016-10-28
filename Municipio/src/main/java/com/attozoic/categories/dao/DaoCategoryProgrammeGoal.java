package com.attozoic.categories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryProgrammeGoal;
import com.attozoic.categories.model.CategoryProgrammeGoalIndicator;
import com.attozoic.categories.repositories.RepositoryCategoryEntity;
import com.attozoic.categories.repositories.RepositoryCategoryProgrammeGoal;

@Repository
public class DaoCategoryProgrammeGoal extends DaoCategoryEntity {

	@Autowired
	RepositoryCategoryProgrammeGoal repoProgrammeGoal;

	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryCategoryEntity getCategoryRepoEntity() {
		return repoProgrammeGoal;
	}
	
	@SuppressWarnings("unchecked")
	public CategoryProgrammeGoalIndicator addCategoryProgrammeGoalIndicator(Long uid, CategoryProgrammeGoalIndicator categoryProgrammeGoalIndicator) {
		CategoryProgrammeGoal categoryProgrammeGoal = (CategoryProgrammeGoal) getCategoryRepoEntity().findOne(uid);
		categoryProgrammeGoalIndicator.setCategoryProgramGoal(categoryProgrammeGoal);
		return (CategoryProgrammeGoalIndicator) getCategoryRepoEntity().save(categoryProgrammeGoalIndicator);
	}
	
}
