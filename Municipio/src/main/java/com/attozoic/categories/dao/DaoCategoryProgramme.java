package com.attozoic.categories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryActivity;
import com.attozoic.categories.model.CategoryProgramme;
import com.attozoic.categories.model.CategoryProgrammeGoal;
import com.attozoic.categories.repositories.RepositoryCategoryEntity;
import com.attozoic.categories.repositories.RepositoryCategoryProgramme;

@Repository
public class DaoCategoryProgramme extends DaoCategoryEntity {

	@Autowired
	private RepositoryCategoryProgramme repoProgramme;

	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryCategoryEntity getCategoryRepoEntity() {
		return repoProgramme;
	}
	
	@SuppressWarnings("unchecked")
	public CategoryProgrammeGoal addCategoryProgrammeGoal(Long uid, CategoryProgrammeGoal categoryProgrammeGoal) {
		CategoryProgramme categoryProgramme = (CategoryProgramme) getCategoryRepoEntity().findOne(uid);
		categoryProgrammeGoal.setCategoryProgramme(categoryProgramme);
		return (CategoryProgrammeGoal) getCategoryRepoEntity().save(categoryProgrammeGoal);
	}
	
	@SuppressWarnings("unchecked")
	public CategoryActivity addCategoryActivity(Long uid, CategoryActivity categoryActivity) {
		CategoryProgramme categoryProgramme = (CategoryProgramme) getCategoryRepoEntity().findOne(uid);
		categoryActivity.setCategoryProgramme(categoryProgramme);
		return (CategoryActivity) getCategoryRepoEntity().save(categoryActivity);
	}
	
}

