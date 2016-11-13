package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.ProgrammeGoalIndicator;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProgrammeGoal;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoProgrammeGoal extends DaoEntity {

	@Autowired
	private RepositoryProgrammeGoal repoProgrammeGoal;
	
	@Autowired
	private RepositoryRebalancesCount repoRebalanceCount;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoProgrammeGoal;
	}
	
	@SuppressWarnings("unchecked")
	public ProgrammeGoalIndicator addProgrammeGoalIndicator(Long uid, ProgrammeGoalIndicator programmeGoalIndicator) {
		ProgrammeGoal programmeGoal = (ProgrammeGoal) getRepoEntity().findOne(uid);
		programmeGoalIndicator.setProgrammeGoal(programmeGoal);
		int numRebalances = 0;
		try {
			numRebalances = repoRebalanceCount.findOne(new Long(1)).getRebalancesCount();
		} catch (NullPointerException ex) {}
		programmeGoalIndicator.generateBalancesText(numRebalances);
		return (ProgrammeGoalIndicator) getRepoEntity().save(programmeGoalIndicator);
	}
	
}
