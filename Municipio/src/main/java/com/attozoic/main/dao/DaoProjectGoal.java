package com.attozoic.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.model.ProjectGoalIndicator;
import com.attozoic.main.model.RebalanceOneField;
import com.attozoic.main.model.RebalancesCount;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProjectGoal;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoProjectGoal extends DaoEntity {

	@Autowired
	private RepositoryProjectGoal repo;
	
	@Autowired
	private RepositoryRebalancesCount repoReb;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repo;
	}
	
	@SuppressWarnings("unchecked")
	public ProjectGoalIndicator addIndicator(Long uid, ProjectGoalIndicator goalIndicator) {
		try {
			RebalancesCount rc = repoReb.findOne(new Long(1));
			int numReb = rc.getRebalancesCount();
			if (numReb > 0) {
				List<RebalanceOneField> l = goalIndicator.getRebalances();
				for (int i = 0; i < numReb; i++) {
					l.add(new RebalanceOneField());
				}
				goalIndicator.setRebalances(l);
			}
		} catch(NullPointerException ex) {}
		ProjectGoal goal = (ProjectGoal) getRepoEntity().findOne(uid);
		goalIndicator.setProjectGoal(goal);
		return (ProjectGoalIndicator) getRepoEntity().save(goalIndicator);
	}

}
