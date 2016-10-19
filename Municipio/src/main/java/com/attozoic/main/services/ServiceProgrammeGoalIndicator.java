package com.attozoic.main.services;

import org.springframework.data.domain.Page;

import com.attozoic.main.model.ProgrammeGoalIndicator;

public interface ServiceProgrammeGoalIndicator {

	Page<ProgrammeGoalIndicator> findAll();
	ProgrammeGoalIndicator save(ProgrammeGoalIndicator programmeGoalIndicator);

}
