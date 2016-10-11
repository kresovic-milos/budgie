package com.attozoic.categories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryActivityGoalIndicator;
import com.attozoic.categories.repositories.RepositoryCategoryActivityGoalIndicator;

@Repository
public class DaoCategoryActivityGoalIndicator {

	@Autowired
	private RepositoryCategoryActivityGoalIndicator repoActivityGoalIndicator;
	
	public Page<CategoryActivityGoalIndicator> findAll() {
		Page<CategoryActivityGoalIndicator> page = new PageImpl<>(repoActivityGoalIndicator.findAll());
		return page;
	}
	
	public CategoryActivityGoalIndicator save(CategoryActivityGoalIndicator indicator) {
		return repoActivityGoalIndicator.save(indicator);
	}
}
