package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoProjectGoalIndicator;
import com.attozoic.main.model.ProjectGoalIndicator;
import com.attozoic.main.services.ServiceProjectGoalIndicator;

@Service
public class ServiceProjectGoalIndicatorImpl implements ServiceProjectGoalIndicator {
	@Autowired
	private DaoProjectGoalIndicator daoProjectGoalIndicator;

	@Override
	public Page<ProjectGoalIndicator> findAll() {
		return daoProjectGoalIndicator.findAll();
	}

	@Override
	public ProjectGoalIndicator save(ProjectGoalIndicator projectGoalIndicator) {
		return daoProjectGoalIndicator.save(projectGoalIndicator);
	}
	
}
