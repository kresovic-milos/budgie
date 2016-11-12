package com.attozoic.main.services;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.Project;

public interface ServiceProgramme extends ServiceEntity {

	ProgrammeGoal addProgrammeGoal(Long uid, ProgrammeGoal programmeGoal);
	Activity addActivity(Long uid, Activity activity);
	Project addProject(Long uid, Project project);
	//List<DtoProgrammeExpencesItem> getProgrammeDTOs(Long uid);
	//DtoProgrammeExpencesItem getDtoProgramme(Long uid);
	//DtoChartProgrammes getProgrammeChart();
	//List<DtoProgrammeFinancialSource> getProgrammeFinanceDto(Long uid);
	//DtoProgrammeFinancialSource getProgrammeFinanceFooterDto(Long uid);
}
