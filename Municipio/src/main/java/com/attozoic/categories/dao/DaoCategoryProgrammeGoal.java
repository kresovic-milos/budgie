package com.attozoic.categories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryProgrammeGoal;
import com.attozoic.categories.repositories.RepositoryCategoryProgrammeGoal;

@Repository
public class DaoCategoryProgrammeGoal {

	@Autowired
	RepositoryCategoryProgrammeGoal repoProgrammeGoal;
	
	public CategoryProgrammeGoal findById(Long uid) {
		return repoProgrammeGoal.findOne(uid);
	}
	
	public Page<CategoryProgrammeGoal> findAll() {
		Page<CategoryProgrammeGoal> page = new PageImpl<>(repoProgrammeGoal.findAll());
		return page;
	}
	
	public CategoryProgrammeGoal save(CategoryProgrammeGoal goal) {
		return repoProgrammeGoal.save(goal);
	}
	
}
