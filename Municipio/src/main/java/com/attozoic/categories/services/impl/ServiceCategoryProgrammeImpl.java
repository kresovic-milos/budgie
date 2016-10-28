package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryEntity;
import com.attozoic.categories.dao.DaoCategoryProgramme;
import com.attozoic.categories.model.CategoryActivity;
import com.attozoic.categories.model.CategoryProgrammeGoal;
import com.attozoic.categories.services.ServiceCategoryProgramme;

@Service
public class ServiceCategoryProgrammeImpl extends ServiceCategoryEntityImpl implements ServiceCategoryProgramme {

	@Autowired
	private DaoCategoryProgramme daoProgramme;

	@Override
	public DaoCategoryEntity getDaoCategoryEntity() {
		return daoProgramme;
	}

	@Override
	public CategoryProgrammeGoal addCategoryProgrammeGoal(Long uid, CategoryProgrammeGoal categoryProgrammeGoal) {
		return daoProgramme.addCategoryProgrammeGoal(uid, categoryProgrammeGoal);
	}

	@Override
	public CategoryActivity addCategoryActivity(Long uid, CategoryActivity categoryActivity) {
		return daoProgramme.addCategoryActivity(uid, categoryActivity);
	}

}