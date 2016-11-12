package com.attozoic.main.services;

import com.attozoic.main.model.ProjectEconomicAccount;
import com.attozoic.main.model.ProjectGoal;

public interface ServiceProject extends ServiceEntity {

	ProjectGoal addProjectGoal(Long uid, ProjectGoal goal);
	ProjectEconomicAccount addProjectEconomicAccount(Long uid, ProjectEconomicAccount projectEconomiAccount);
	//DtoProgrammeExpencesItem buildProjectDto(Long uid);
	//DtoProgrammeFinancialSourceItem buildProjectFinanceDto(Long uid);
}
