package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.repositories.RepositoryProgrammeGoal;

@Repository
public class DaoProgrammeGoal {

	@Autowired
	private RepositoryProgrammeGoal repoProgrammeGoal;
	
	public Page<ProgrammeGoal> findAll() {
		Page<ProgrammeGoal> page = new PageImpl<>(repoProgrammeGoal.findAll());
		return page;
	}
	
	public ProgrammeGoal save(ProgrammeGoal programmeGoal) {
		return repoProgrammeGoal.save(programmeGoal);
	}

}
