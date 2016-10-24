package com.attozoic.main.services;

import com.attozoic.main.model.ProgrammeGoalIndicator;

public interface ServiceProgrammeGoal extends ServiceEntity {

	ProgrammeGoalIndicator addProgrammeGoalIndicator(Long uid, ProgrammeGoalIndicator programmeGoalIndicator);
	
}
