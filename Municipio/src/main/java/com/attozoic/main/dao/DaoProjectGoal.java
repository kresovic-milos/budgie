package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.model.ProjectGoalIndicator;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProjectGoal;

@Repository
public class DaoProjectGoal extends DaoEntity {

	@Autowired
	private RepositoryProjectGoal repo;
	
	@Override
	public RepositoryEntity getRepoEntity() {
		return repo;
	}
	
	public ProjectGoalIndicator addIndicator(Long uid, ProjectGoalIndicator goalIndicator) {
		ProjectGoal goal = (ProjectGoal) getRepoEntity().findOne(uid);
		goalIndicator.setProjectGoal(goal);
		return (ProjectGoalIndicator) getRepoEntity().save(goalIndicator);
	}

}
