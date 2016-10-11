package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryProgrammeGoalIndicator;
import com.attozoic.categories.model.CategoryProgrammeGoalIndicator;
import com.attozoic.categories.services.ServiceCategoryProgrammeGoalIndicator;

@Service
public class ServiceCategoryProgrammeGoalIndicatorImpl implements ServiceCategoryProgrammeGoalIndicator {

	@Autowired
	private DaoCategoryProgrammeGoalIndicator daoProgrammeGoalIndicator;
	
	@Override
	public Page<CategoryProgrammeGoalIndicator> findAll() {
		return daoProgrammeGoalIndicator.findAll();
	}

	@Override
	public CategoryProgrammeGoalIndicator save(CategoryProgrammeGoalIndicator indicator) {
		return daoProgrammeGoalIndicator.save(indicator);
	}

}
