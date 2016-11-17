package com.attozoic.main.services;

import java.util.List;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.Project;
import com.attozoic.main.model.dto.DtoProgrammeEconomicAccount;

public interface ServiceProgramme extends ServiceEntity {

	ProgrammeGoal addProgrammeGoal(Long uid, ProgrammeGoal programmeGoal);
	Activity addActivity(Long uid, Activity activity);
	Project addProject(Long uid, Project project);
	DtoProgrammeEconomicAccount getProgrammeEconomicAccountFooter(Long uid);
	List<DtoProgrammeEconomicAccount> getProgrammeEconomicAccountList(Long uid);
	
	

	//DtoChartProgrammes getProgrammeChart();
	//List<DtoProgrammeFinancialSource> getProgrammeFinanceDto(Long uid);
	//DtoProgrammeFinancialSource getProgrammeFinanceFooterDto(Long uid);
}
