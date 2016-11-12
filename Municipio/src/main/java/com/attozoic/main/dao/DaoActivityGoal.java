package com.attozoic.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.model.ActivityGoalIndicator;
import com.attozoic.main.model.RebalancesCount;
import com.attozoic.main.model.balance.BalanceText;
import com.attozoic.main.repositories.RepositoryActivityGoal;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoActivityGoal extends DaoEntity {

	@Autowired
	private RepositoryActivityGoal repoActivityGoal;
	
	@Autowired
	private RepositoryRebalancesCount repoRebCount;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoActivityGoal;
	}
	
	@SuppressWarnings("unchecked")
	public ActivityGoalIndicator addActivityGoalIndicator(Long uid, ActivityGoalIndicator activityGoalIndicator) {
		try {
			RebalancesCount rc = repoRebCount.findOne(new Long(1));
			int numRebalances = rc.getRebalancesCount();
			if (numRebalances > 0) {
				List<BalanceText> indicatorValues = activityGoalIndicator.getBalancesText();
				for (int i = 0; i < numRebalances; i++) {
					indicatorValues.add((indicatorValues.size()-3), new BalanceText());
				}
				activityGoalIndicator.setBalancesText(indicatorValues);
			}
		} catch(NullPointerException ex) {}
		ActivityGoal activityGoal = (ActivityGoal) getRepoEntity().findOne(uid);
		activityGoalIndicator.setActivityGoal(activityGoal);
		return (ActivityGoalIndicator) getRepoEntity().save(activityGoalIndicator);
	}

}
