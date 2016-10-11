package com.attozoic.categories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryProgrammeGoalIndicator;
import com.attozoic.categories.repositories.RepositoryCategoryProgrammeGoalIndicator;

@Repository
public class DaoCategoryProgrammeGoalIndicator {

	@Autowired
	private RepositoryCategoryProgrammeGoalIndicator repoProgrammeGoalIndicator;
	
	public Page<CategoryProgrammeGoalIndicator> findAll(){
		Page<CategoryProgrammeGoalIndicator> page = new PageImpl<>(repoProgrammeGoalIndicator.findAll());
		return page;
	}
	
	public CategoryProgrammeGoalIndicator save(CategoryProgrammeGoalIndicator indicator) {
		return repoProgrammeGoalIndicator.save(indicator);
	}
	
}
