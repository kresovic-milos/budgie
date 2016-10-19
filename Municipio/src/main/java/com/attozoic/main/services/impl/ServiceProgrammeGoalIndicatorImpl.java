package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoProgrammeGoalIndicator;
import com.attozoic.main.model.ProgrammeGoalIndicator;
import com.attozoic.main.services.ServiceProgrammeGoalIndicator;

@Service
public class ServiceProgrammeGoalIndicatorImpl implements ServiceProgrammeGoalIndicator {

	@Autowired
	private DaoProgrammeGoalIndicator daoProgrammeGoalIndicator;

	@Override
	public Page<ProgrammeGoalIndicator> findAll() {
		return daoProgrammeGoalIndicator.findAll();
	}

	@Override
	public ProgrammeGoalIndicator save(ProgrammeGoalIndicator programmeGoalIndicator) {
		return daoProgrammeGoalIndicator.save(programmeGoalIndicator);
	}
	
}
