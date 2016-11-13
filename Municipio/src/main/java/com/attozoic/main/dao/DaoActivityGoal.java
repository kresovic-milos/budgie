package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.model.ActivityGoalIndicator;
import com.attozoic.main.repositories.RepositoryActivityGoal;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoActivityGoal extends DaoEntity {

	@Autowired
	private RepositoryActivityGoal repoActivityGoal;
	
	@Autowired
	private RepositoryRebalancesCount repoRebalanceCount;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoActivityGoal;
	}
	
	@SuppressWarnings("unchecked")
	public ActivityGoalIndicator addActivityGoalIndicator(Long uid, ActivityGoalIndicator activityGoalIndicator) {
		ActivityGoal activityGoal = (ActivityGoal) getRepoEntity().findOne(uid);
		activityGoalIndicator.setActivityGoal(activityGoal);
		int numRebalances = 0;
		try {
			numRebalances = repoRebalanceCount.findOne(new Long(1)).getRebalancesCount();
		} catch (NullPointerException ex) {}
		activityGoalIndicator.generateBalancesText(numRebalances);
		return (ActivityGoalIndicator) getRepoEntity().save(activityGoalIndicator);
	}

}
