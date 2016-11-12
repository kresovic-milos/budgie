package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProgrammeGoalIndicator;

@Repository
public class DaoProgrammeGoalIndicator extends DaoEntity {

	@Autowired
	private RepositoryProgrammeGoalIndicator repoPRogrammeGoalIndicator;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoPRogrammeGoalIndicator;
	}

}
