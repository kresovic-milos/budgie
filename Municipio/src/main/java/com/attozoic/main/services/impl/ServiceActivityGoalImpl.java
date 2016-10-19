package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoActivityGoal;
import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.services.ServiceActivityGoal;

@Service
public class ServiceActivityGoalImpl implements ServiceActivityGoal {

	@Autowired
	private DaoActivityGoal daoActivityGoal;

	@Override
	public Page<ActivityGoal> findAll() {
		return daoActivityGoal.findAll();
	}

	@Override
	public ActivityGoal save(ActivityGoal activityGoal) {
		return daoActivityGoal.save(activityGoal);
	}
	
}
