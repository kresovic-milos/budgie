package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.model.ActivityGoalIndicator;
import com.attozoic.main.repositories.RepositoryActivityGoal;
import com.attozoic.main.repositories.RepositoryEntity;

@Repository
public class DaoActivityGoal extends DaoEntity {

	@Autowired
	private RepositoryActivityGoal repo;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repo;
	}
	
	@SuppressWarnings("unchecked")
	public ActivityGoalIndicator addActivityGoalIndicator(Long uid, ActivityGoalIndicator activityGoalIndicator) {
		ActivityGoal activityGoal = (ActivityGoal) getRepoEntity().findOne(uid);
		activityGoalIndicator.setActivityGoal(activityGoal);
		return (ActivityGoalIndicator) getRepoEntity().save(activityGoalIndicator);
	}

}
