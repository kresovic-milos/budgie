package com.attozoic.main.services;

import java.util.List;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.DtoActivityProject;
import com.attozoic.main.model.DtoProgrammeFinancialSource;
import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.Project;

public interface ServiceProgramme extends ServiceEntity {

	ProgrammeGoal addProgrammeGoal(Long uid, ProgrammeGoal programmeGoal);
	Activity addActivity(Long uid, Activity activity);
	Project addProject(Long uid, Project project);
	List<DtoActivityProject> getProgrammeDTOs(Long uid);
	List<DtoProgrammeFinancialSource> getProgrammeFinanceDto(Long uid);
}
