package com.attozoic.main.services;

import com.attozoic.main.model.DtoActivityProject;
import com.attozoic.main.model.DtoProgrammeFinancialSource;
import com.attozoic.main.model.ProjectEconomicAccount;
import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.model.ProjectGoal;

public interface ServiceProject extends ServiceEntity {

	ProjectFinancialSource addProjectFinancialSource(Long uid, ProjectFinancialSource financialSource);
	ProjectGoal addProjectGoal(Long uid, ProjectGoal goal);
	ProjectEconomicAccount addProjectEconomicAccount(Long uid, ProjectEconomicAccount projectEconomiAccount);
	DtoActivityProject buildProjectDto(Long uid);
	DtoProgrammeFinancialSource buildProjectFinanceDto(Long uid);
}
