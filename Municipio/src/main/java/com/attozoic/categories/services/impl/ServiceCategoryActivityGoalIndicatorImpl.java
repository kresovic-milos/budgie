package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryActivityGoalIndicator;
import com.attozoic.categories.dao.DaoCategoryEntity;
import com.attozoic.categories.services.ServiceCategoryActivityGoalIndicator;

@Service
public class ServiceCategoryActivityGoalIndicatorImpl extends ServiceCategoryEntityImpl implements ServiceCategoryActivityGoalIndicator {

	@Autowired
	private DaoCategoryActivityGoalIndicator daoActivityGoalIndicator;

	@Override
	public DaoCategoryEntity getDaoCategoryEntity() {
		return daoActivityGoalIndicator;
	}

}
