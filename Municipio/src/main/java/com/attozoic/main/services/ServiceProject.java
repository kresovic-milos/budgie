package com.attozoic.main.services;

import java.util.List;
import java.util.Map;

import com.attozoic.main.model.ProjectEconomicAccount;
import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.model.SuperEconomicAccount;
import com.attozoic.main.model.dto.DtoFinanceFooter;
import com.attozoic.main.model.dto.DtoProjectEconomicAccount;

public interface ServiceProject extends ServiceEntity {

	DtoFinanceFooter getProjectFinancialSourceFooter(Long uid);
	Map<String, double[]> getProjectFinancialSourceMap(Long uid);
	SuperEconomicAccount getProjectEconomicAccountFooter(Long uid);
	List<DtoProjectEconomicAccount> getProjectEconomicAccountsList(Long uid);
	
	ProjectGoal addProjectGoal(Long uid, ProjectGoal goal);
	ProjectEconomicAccount addProjectEconomicAccount(Long uid, ProjectEconomicAccount projectEconomiAccount);
	
}
