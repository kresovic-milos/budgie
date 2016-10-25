package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.ProgrammeGoalIndicator;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProgrammeGoal;

@Repository
public class DaoProgrammeGoal extends DaoEntity {

	@Autowired
	private RepositoryProgrammeGoal repo;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repo;
	}
	
	@SuppressWarnings("unchecked")
	public ProgrammeGoalIndicator addProgrammeGoalIndicator(Long uid, ProgrammeGoalIndicator programmeGoalIndicator) {
		ProgrammeGoal programmeGoal = (ProgrammeGoal) getRepoEntity().findOne(uid);
		programmeGoalIndicator.setProgrammeGoal(programmeGoal);
		return (ProgrammeGoalIndicator) getRepoEntity().save(programmeGoalIndicator);
	}
	
}
