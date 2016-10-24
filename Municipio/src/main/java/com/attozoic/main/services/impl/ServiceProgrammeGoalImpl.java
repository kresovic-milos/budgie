package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.DaoProgrammeGoal;
import com.attozoic.main.model.ProgrammeGoalIndicator;
import com.attozoic.main.services.ServiceProgrammeGoal;

@Service
public class ServiceProgrammeGoalImpl extends ServiceEntityImpl implements ServiceProgrammeGoal {

	@Autowired
	private DaoProgrammeGoal dao;

	@Override
	public DaoEntity getDaoEntity() {
		return dao;
	}

	@Override
	public ProgrammeGoalIndicator addProgrammeGoalIndicator(Long uid, ProgrammeGoalIndicator programmeGoalIndicator) {
		return ((DaoProgrammeGoal) getDaoEntity()).addProgrammeGoalIndicator(uid, programmeGoalIndicator);
	}
	
}
