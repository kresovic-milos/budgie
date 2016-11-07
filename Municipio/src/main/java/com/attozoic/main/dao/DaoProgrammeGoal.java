package com.attozoic.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.ProgrammeGoalIndicator;
import com.attozoic.main.model.RebalanceOneField;
import com.attozoic.main.model.RebalancesCount;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProgrammeGoal;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoProgrammeGoal extends DaoEntity {

	@Autowired
	private RepositoryProgrammeGoal repo;
	
	@Autowired
	private RepositoryRebalancesCount repoReb;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repo;
	}
	
	@SuppressWarnings("unchecked")
	public ProgrammeGoalIndicator addProgrammeGoalIndicator(Long uid, ProgrammeGoalIndicator programmeGoalIndicator) {
		try {
			RebalancesCount rc = repoReb.findOne(new Long(1));
			int numReb = rc.getRebalancesCount();
			if (numReb > 0) {
				List<RebalanceOneField> l = programmeGoalIndicator.getRebalances();
				for (int i = 0; i < numReb; i++) {
					l.add(new RebalanceOneField());
				}
				programmeGoalIndicator.setRebalances(l);
			}
		} catch(NullPointerException ex) {}
		ProgrammeGoal programmeGoal = (ProgrammeGoal) getRepoEntity().findOne(uid);
		programmeGoalIndicator.setProgrammeGoal(programmeGoal);
		getRepoEntity().save(programmeGoal);
		return (ProgrammeGoalIndicator) getRepoEntity().save(programmeGoalIndicator);
	}
	
}
