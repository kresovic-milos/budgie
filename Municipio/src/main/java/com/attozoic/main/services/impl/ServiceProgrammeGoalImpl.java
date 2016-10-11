package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoProgrammeGoal;
import com.attozoic.main.model.ProgrammeGoal;

@Service
public class ServiceProgrammeGoalImpl implements ServiceProgrammeGoal {

	@Autowired
	private DaoProgrammeGoal daoProgrammeGoal;
	
	@Override
	public Page<ProgrammeGoal> findAll() {
		return daoProgrammeGoal.findAll();
	}

	@Override
	public ProgrammeGoal save(ProgrammeGoal programmeGoal) {
		return daoProgrammeGoal.save(programmeGoal);
	}

}
