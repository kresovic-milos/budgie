package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryActivityGoalIndicator;
import com.attozoic.categories.model.CategoryActivityGoalIndicator;
import com.attozoic.categories.services.ServiceCategoryActivityGoalIndicator;

@Service
public class ServiceCategoryActivityGoalIndicatorImpl implements ServiceCategoryActivityGoalIndicator {

	@Autowired
	private DaoCategoryActivityGoalIndicator daoActivityGoalIndicator;
	
	@Override
	public Page<CategoryActivityGoalIndicator> findAll() {
		return daoActivityGoalIndicator.findAll();
	}

	@Override
	public CategoryActivityGoalIndicator save(CategoryActivityGoalIndicator indicator) {
		return daoActivityGoalIndicator.save(indicator);
	}

	
}
