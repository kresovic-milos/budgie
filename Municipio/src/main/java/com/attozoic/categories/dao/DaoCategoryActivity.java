package com.attozoic.categories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryActivity;
import com.attozoic.categories.model.CategoryActivityGoal;
import com.attozoic.categories.repositories.RepositoryCategoryActivity;
import com.attozoic.categories.repositories.RepositoryCategoryEntity;

@Repository
public class DaoCategoryActivity extends DaoCategoryEntity {

	@Autowired
	private RepositoryCategoryActivity repoActivity;

	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryCategoryEntity getCategoryRepoEntity() {
		return repoActivity;
	}
	
	@SuppressWarnings("unchecked")
	public CategoryActivityGoal addCategoryActivityGoal(Long uid, CategoryActivityGoal categoryActivityGoal) {
		CategoryActivity categoryActivity = (CategoryActivity) getCategoryRepoEntity().findOne(uid);
		categoryActivityGoal.setCategoryActivity(categoryActivity);
		return (CategoryActivityGoal) getCategoryRepoEntity().save(categoryActivityGoal);
	}
	
}
