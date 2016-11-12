package com.attozoic.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.ProgrammeGoalIndicator;
import com.attozoic.main.model.RebalancesCount;
import com.attozoic.main.model.balance.BalanceText;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProgrammeGoal;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoProgrammeGoal extends DaoEntity {

	@Autowired
	private RepositoryProgrammeGoal repoProgrammeGoal;
	
	@Autowired
	private RepositoryRebalancesCount repoRebCount;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoProgrammeGoal;
	}
	
	@SuppressWarnings("unchecked")
	public ProgrammeGoalIndicator addProgrammeGoalIndicator(Long uid, ProgrammeGoalIndicator programmeGoalIndicator) {
		try {
			RebalancesCount rc = repoRebCount.findOne(new Long(1));
			int numRebalances = rc.getRebalancesCount();
			if (numRebalances > 0) {
				List<BalanceText> indicatorValues = programmeGoalIndicator.getBalancesText();
				for (int i = 0; i < numRebalances; i++) {
					indicatorValues.add((indicatorValues.size()-3), new BalanceText());
				}
				programmeGoalIndicator.setBalancesText(indicatorValues);
			}
		} catch(NullPointerException ex) {}
		ProgrammeGoal programmeGoal = (ProgrammeGoal) getRepoEntity().findOne(uid);
		programmeGoalIndicator.setProgrammeGoal(programmeGoal);
		return (ProgrammeGoalIndicator) getRepoEntity().save(programmeGoalIndicator);
	}
	
}
