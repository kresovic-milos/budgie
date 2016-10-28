package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryActivity;
import com.attozoic.categories.dao.DaoCategoryEntity;
import com.attozoic.categories.model.CategoryActivityGoal;
import com.attozoic.categories.services.ServiceCategoryActivity;

@Service
public class ServiceCategoryActivityImpl extends ServiceCategoryEntityImpl implements ServiceCategoryActivity {

	@Autowired
	DaoCategoryActivity daoActivity;

	@Override
	public DaoCategoryEntity getDaoCategoryEntity() {
		return daoActivity;
	}

	@Override
	public CategoryActivityGoal addCategoryActivityGoal(Long uid, CategoryActivityGoal categoryActivityGoal) {
		return daoActivity.addCategoryActivityGoal(uid, categoryActivityGoal);
	}
	
}
