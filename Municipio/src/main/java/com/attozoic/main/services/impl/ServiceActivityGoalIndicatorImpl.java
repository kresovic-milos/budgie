package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoActivityGoalIndicator;
import com.attozoic.main.model.ActivityGoalIndicator;
import com.attozoic.main.services.ServiceActivityGoalIndicator;

@Service
public class ServiceActivityGoalIndicatorImpl implements ServiceActivityGoalIndicator {
	@Autowired
	private DaoActivityGoalIndicator daoActivityGoalIndicator;

	@Override
	public Page<ActivityGoalIndicator> findAll() {
		return daoActivityGoalIndicator.findAll();
	}

	@Override
	public ActivityGoalIndicator save(ActivityGoalIndicator activityGoalIndicator) {
		return daoActivityGoalIndicator.save(activityGoalIndicator);
	}
	
}
