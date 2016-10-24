package com.attozoic.main.services;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ProgrammeGoal;

public interface ServiceProgramme extends ServiceEntity {

	ProgrammeGoal addProgrammeGoal(Long uid, ProgrammeGoal programmeGoal);
	Activity addActivity(Long uid, Activity activity);
}
