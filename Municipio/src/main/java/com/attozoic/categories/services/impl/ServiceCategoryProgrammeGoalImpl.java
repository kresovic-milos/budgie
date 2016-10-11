package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryProgrammeGoal;
import com.attozoic.categories.model.CategoryProgrammeGoal;
import com.attozoic.categories.services.ServiceCategoryProgrammeGoal;

@Service
public class ServiceCategoryProgrammeGoalImpl implements ServiceCategoryProgrammeGoal {

	@Autowired
	private DaoCategoryProgrammeGoal daoProgrammeGoal;
	
	@Override
	public Page<CategoryProgrammeGoal> findAll() {
		return daoProgrammeGoal.findAll();
	}

	@Override
	public CategoryProgrammeGoal save(CategoryProgrammeGoal goal) {
		return daoProgrammeGoal.save(goal);
	}

}
