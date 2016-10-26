package com.attozoic.main.services;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ProgrammeFinancialSource;
import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.Project;

public interface ServiceProgramme extends ServiceEntity {

	ProgrammeGoal addProgrammeGoal(Long uid, ProgrammeGoal programmeGoal);
	Activity addActivity(Long uid, Activity activity);
	ProgrammeFinancialSource addProgrammeFinancialSource(Long uid, ProgrammeFinancialSource programmeFinancialSource);
	Project addProject(Long uid, Project project);
}
