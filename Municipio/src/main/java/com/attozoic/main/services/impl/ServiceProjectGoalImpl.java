package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoProjectGoal;
import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.services.ServiceProjectGoal;

@Service
public class ServiceProjectGoalImpl implements ServiceProjectGoal {

	@Autowired
	private DaoProjectGoal daoProjectGoal;

	@Override
	public Page<ProjectGoal> findAll() {
		return daoProjectGoal.findAll();
	}

	@Override
	public ProjectGoal save(ProjectGoal projectGoal) {
		return daoProjectGoal.save(projectGoal);
	}
	
}
