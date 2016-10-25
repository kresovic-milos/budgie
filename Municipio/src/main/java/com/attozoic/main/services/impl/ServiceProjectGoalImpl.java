package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.DaoProjectGoal;
import com.attozoic.main.model.ProjectGoalIndicator;
import com.attozoic.main.services.ServiceProjectGoal;

@Service
public class ServiceProjectGoalImpl extends ServiceEntityImpl implements ServiceProjectGoal {

	@Autowired
	private DaoProjectGoal dao;

	@Override
	public DaoEntity getDaoEntity() {
		return dao;
	}
	
	@Override
	public ProjectGoalIndicator addIndicator(Long uid, ProjectGoalIndicator goalIndicator) {		
		return ((DaoProjectGoal) getDaoEntity()).addIndicator(uid, goalIndicator);
	}
	
}
