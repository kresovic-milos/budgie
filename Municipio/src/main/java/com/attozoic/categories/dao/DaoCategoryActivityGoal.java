package com.attozoic.categories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryActivityGoal;
import com.attozoic.categories.repositories.RepositoryCategoryActivityGoal;

@Repository
public class DaoCategoryActivityGoal {

	@Autowired
	private RepositoryCategoryActivityGoal repoActivityGoal;
	
	public Page<CategoryActivityGoal> findAll() {
		Page<CategoryActivityGoal> page = new PageImpl<>(repoActivityGoal.findAll());
		return page;
	}

	public CategoryActivityGoal save(CategoryActivityGoal goal) {
		return repoActivityGoal.save(goal);
	}
	
}
