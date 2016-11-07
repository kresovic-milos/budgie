package com.attozoic.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.model.ActivityGoalIndicator;
import com.attozoic.main.model.RebalanceOneField;
import com.attozoic.main.model.RebalancesCount;
import com.attozoic.main.repositories.RepositoryActivityGoal;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoActivityGoal extends DaoEntity {

	@Autowired
	private RepositoryActivityGoal repo;
	
	@Autowired
	private RepositoryRebalancesCount repoReb;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repo;
	}
	
	@SuppressWarnings("unchecked")
	public ActivityGoalIndicator addActivityGoalIndicator(Long uid, ActivityGoalIndicator activityGoalIndicator) {
		try {
			RebalancesCount rc = repoReb.findOne(new Long(1));
			int numReb = rc.getRebalancesCount();
			if (numReb > 0) {
				List<RebalanceOneField> l = activityGoalIndicator.getRebalances();
				for (int i = 0; i < numReb; i++) {
					l.add(new RebalanceOneField());
				}
				activityGoalIndicator.setRebalances(l);
			}
		} catch(NullPointerException ex) {}
		ActivityGoal activityGoal = (ActivityGoal) getRepoEntity().findOne(uid);
		activityGoalIndicator.setActivityGoal(activityGoal);
		return (ActivityGoalIndicator) getRepoEntity().save(activityGoalIndicator);
	}

}
