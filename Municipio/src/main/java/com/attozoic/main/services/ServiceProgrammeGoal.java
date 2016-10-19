package com.attozoic.main.services;

import org.springframework.data.domain.Page;

import com.attozoic.main.model.ProgrammeGoal;

public interface ServiceProgrammeGoal {

	Page<ProgrammeGoal> findAll();
	ProgrammeGoal save(ProgrammeGoal programmeGoal);

}
