package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.model.ProjectGoalIndicator;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProjectGoal;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoProjectGoal extends DaoEntity {

	@Autowired
	private RepositoryProjectGoal repoProjectGoal;
	
	@Autowired
	private RepositoryRebalancesCount repoRebalanceCount;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoProjectGoal;
	}
	
	@SuppressWarnings("unchecked")
	public ProjectGoalIndicator addProjectGoalIndicator(Long uid, ProjectGoalIndicator projectGoalIndicator) {
		ProjectGoal projectGoal = (ProjectGoal) getRepoEntity().findOne(uid);
		projectGoalIndicator.setProjectGoal(projectGoal);
		int numRebalances = 0;
		try {
			numRebalances = repoRebalanceCount.findOne(new Long(1)).getRebalancesCount();
		} catch (NullPointerException ex) {}
		projectGoalIndicator.generateBalancesText(numRebalances);
		return (ProjectGoalIndicator) getRepoEntity().save(projectGoalIndicator);
	}

}
