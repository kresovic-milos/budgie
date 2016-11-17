package com.attozoic.main.services;

import java.util.List;

import com.attozoic.main.model.ProjectEconomicAccount;
import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.model.SuperEconomicAccount;
import com.attozoic.main.model.dto.DtoProjectEconomicAccount;

public interface ServiceProject extends ServiceEntity {

	ProjectGoal addProjectGoal(Long uid, ProjectGoal goal);
	ProjectEconomicAccount addProjectEconomicAccount(Long uid, ProjectEconomicAccount projectEconomiAccount);
	SuperEconomicAccount getProjectEconomicAccountFooter(Long uid);
	List<DtoProjectEconomicAccount> getProjectEconomicAccountDTOsList(Long uid);
	
	
	//DtoProgrammeExpencesItem buildProjectDto(Long uid);
	//DtoProgrammeFinancialSourceItem buildProjectFinanceDto(Long uid);
}
