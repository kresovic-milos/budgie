package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryActivityGoal;
import com.attozoic.categories.dao.DaoCategoryEntity;
import com.attozoic.categories.model.CategoryActivityGoalIndicator;
import com.attozoic.categories.services.ServiceCategoryActivityGoal;

@Service
public class ServiceCategoryActivityGoalImpl extends ServiceCategoryEntityImpl implements ServiceCategoryActivityGoal {

	@Autowired
	private DaoCategoryActivityGoal daoActivityGoal;

	@Override
	public DaoCategoryEntity getDaoCategoryEntity() {
		return daoActivityGoal;
	}

	@Override
	public CategoryActivityGoalIndicator addCategoryActivityGoalIndicator(Long uid,
			CategoryActivityGoalIndicator categoryActivityGoalIndicator) {
		return daoActivityGoal.addCategoryActivityGoalIndicator(uid, categoryActivityGoalIndicator);
	}


}
