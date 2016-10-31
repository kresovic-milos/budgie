package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProgrameGoalIndicator;

@Repository
public class DaoProgrammeGoalIndicator extends DaoEntity {

	@Autowired
	private RepositoryProgrameGoalIndicator repo;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repo;
	}

//	@Autowired
//	private RepositoryProgrameGoalIndicator repoProgrammeGoalIndicator;
//	
//	public Page<ProgrammeGoalIndicator> findAll() {
//		Page<ProgrammeGoalIndicator> page = new PageImpl<>(repoProgrammeGoalIndicator.findAll());
//		return page;
//	}
//	
//	public ProgrammeGoalIndicator save(ProgrammeGoalIndicator programmeGoalIndicator) {
//		return repoProgrammeGoalIndicator.save(programmeGoalIndicator);
//	}

}
