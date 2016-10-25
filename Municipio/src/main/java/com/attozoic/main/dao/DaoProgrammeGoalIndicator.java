package com.attozoic.main.dao;

import org.springframework.stereotype.Repository;

import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProgrameGoalIndicator;

@Repository
public class DaoProgrammeGoalIndicator extends DaoEntity {

	private RepositoryProgrameGoalIndicator repo;
	
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
