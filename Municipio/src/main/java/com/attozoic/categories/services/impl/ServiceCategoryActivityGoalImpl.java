package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryActivityGoal;
import com.attozoic.categories.model.CategoryActivityGoal;
import com.attozoic.categories.services.ServiceCategoryActivityGoal;

@Service
public class ServiceCategoryActivityGoalImpl implements ServiceCategoryActivityGoal {

	@Autowired
	private DaoCategoryActivityGoal daoActivityGoal;
	
	@Override
	public Page<CategoryActivityGoal> findAll() {
		return daoActivityGoal.findAll();
	}

	@Override
	public CategoryActivityGoal save(CategoryActivityGoal goal) {
		return daoActivityGoal.save(goal);
	}


}
