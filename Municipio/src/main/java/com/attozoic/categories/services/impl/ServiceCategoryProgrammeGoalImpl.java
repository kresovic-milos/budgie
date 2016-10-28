package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryEntity;
import com.attozoic.categories.dao.DaoCategoryProgrammeGoal;
import com.attozoic.categories.model.CategoryProgrammeGoalIndicator;
import com.attozoic.categories.services.ServiceCategoryProgrammeGoal;

@Service
public class ServiceCategoryProgrammeGoalImpl extends ServiceCategoryEntityImpl implements ServiceCategoryProgrammeGoal {

	@Autowired
	private DaoCategoryProgrammeGoal daoProgrammeGoal;

	@Override
	public DaoCategoryEntity getDaoCategoryEntity() {
		return daoProgrammeGoal;
	}

	@Override
	public CategoryProgrammeGoalIndicator addCategoryProgrammeGoalIndicator(Long uid,
			CategoryProgrammeGoalIndicator categoryProgrammeGoalIndicator) {
		return daoProgrammeGoal.addCategoryProgrammeGoalIndicator(uid, categoryProgrammeGoalIndicator);
	}

}
