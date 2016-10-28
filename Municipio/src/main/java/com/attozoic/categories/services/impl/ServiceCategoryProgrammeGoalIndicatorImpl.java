package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryEntity;
import com.attozoic.categories.dao.DaoCategoryProgrammeGoalIndicator;
import com.attozoic.categories.services.ServiceCategoryProgrammeGoalIndicator;

@Service
public class ServiceCategoryProgrammeGoalIndicatorImpl extends ServiceCategoryEntityImpl implements ServiceCategoryProgrammeGoalIndicator {

	@Autowired
	private DaoCategoryProgrammeGoalIndicator daoProgrammeGoalIndicator;

	@Override
	public DaoCategoryEntity getDaoCategoryEntity() {
		return daoProgrammeGoalIndicator;
	}
	


}
