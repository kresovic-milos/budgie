package com.attozoic.main.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.main.model.ProgrammeGoal;

@Service
public interface ServiceProgrammeGoal {

	Page<ProgrammeGoal> findAll();
	ProgrammeGoal save(ProgrammeGoal goal);

}