package com.attozoic.main.services;

import java.util.List;
import java.util.Map;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.Project;
import com.attozoic.main.model.dto.DtoFinanceFooter;
import com.attozoic.main.model.dto.DtoProgrammeChart;
import com.attozoic.main.model.dto.DtoProgrammeEconomicAccount;

public interface ServiceProgramme extends ServiceEntity {

	DtoProgrammeChart getProgrammesChart();
	
	DtoFinanceFooter getProgrammeFinancialSourceFooter(Long uid);
	Map<String, double[]> getProgrammeFinancialSourceMap(Long uid);
	DtoProgrammeEconomicAccount getProgrammeEconomicAccountFooter(Long uid);
	List<DtoProgrammeEconomicAccount> getProgrammeEconomicAccountList(Long uid);

	Activity addActivity(Long uid, Activity activity);
	Project addProject(Long uid, Project project);
	ProgrammeGoal addProgrammeGoal(Long uid, ProgrammeGoal programmeGoal);

	
}
