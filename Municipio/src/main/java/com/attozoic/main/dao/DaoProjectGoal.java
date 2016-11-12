package com.attozoic.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.model.ProjectGoalIndicator;
import com.attozoic.main.model.RebalancesCount;
import com.attozoic.main.model.balance.BalanceText;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProjectGoal;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoProjectGoal extends DaoEntity {

	@Autowired
	private RepositoryProjectGoal repoProjectGoal;
	
	@Autowired
	private RepositoryRebalancesCount repoRebCount;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoProjectGoal;
	}
	
	@SuppressWarnings("unchecked")
	public ProjectGoalIndicator addIndicator(Long uid, ProjectGoalIndicator projectGoalIndicator) {
		try {
			RebalancesCount rc = repoRebCount.findOne(new Long(1));
			int numRebalances = rc.getRebalancesCount();
			if (numRebalances > 0) {
				List<BalanceText> indicatorValues = projectGoalIndicator.getBalancesText();
				for (int i = 0; i < numRebalances; i++) {
					indicatorValues.add((indicatorValues.size()-3), new BalanceText());
				}
				projectGoalIndicator.setBalancesText(indicatorValues);
			}
		} catch(NullPointerException ex) {}
		ProjectGoal projectGoal = (ProjectGoal) getRepoEntity().findOne(uid);
		projectGoalIndicator.setProjectGoal(projectGoal);
		return (ProjectGoalIndicator) getRepoEntity().save(projectGoalIndicator);
	}

}
