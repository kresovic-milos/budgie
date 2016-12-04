package com.attozoic.main.services;

import java.util.List;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.Project;
import com.attozoic.main.model.dto.DtoProgrammeEconomicAccount;
import com.attozoic.main.model.dto.DtoProgrammeFinances;

public interface ServiceProgramme extends ServiceEntity {
	
	//DtoProgrammeFinances getProgrammeFinancialSourceFooter(Long uid);
	DtoProgrammeFinances getProgrammeFinances(Long uid);
	DtoProgrammeEconomicAccount getProgrammeEconomicAccountFooter(Long uid);
	List<DtoProgrammeEconomicAccount> getProgrammeEconomicAccountList(Long uid);

	Activity addActivity(Long uid, Activity activity);
	Project addProject(Long uid, Project project);
	ProgrammeGoal addProgrammeGoal(Long uid, ProgrammeGoal programmeGoal);

	void generateBalancesAmounts(Long uid);
	
	List<ProgrammeGoal> getProgrammeGoals(Long uid);
	
	List<Object> getChart(double year);
	
}
