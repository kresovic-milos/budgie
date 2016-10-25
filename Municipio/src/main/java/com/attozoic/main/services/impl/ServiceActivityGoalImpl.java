package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoActivityGoal;
import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.model.ActivityGoalIndicator;
import com.attozoic.main.services.ServiceActivityGoal;

@Service
public class ServiceActivityGoalImpl extends ServiceEntityImpl implements ServiceActivityGoal {

	@Autowired
	private DaoActivityGoal dao;

	@Override
	public DaoEntity getDaoEntity() {
		return dao;
	}

	@Override
	public ActivityGoalIndicator addActivityGoalIndicator(Long uid, ActivityGoalIndicator activityGoalIndicator) {
		return ((DaoActivityGoal) getDaoEntity()).addActivityGoalIndicator(uid, activityGoalIndicator);
	}
	
}
