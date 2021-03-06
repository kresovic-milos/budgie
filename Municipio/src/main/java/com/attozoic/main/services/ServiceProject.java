package com.attozoic.main.services;

import java.util.List;
import java.util.Map;

import com.attozoic.main.model.Project;
import com.attozoic.main.model.ProjectEconomicAccount;
import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.model.SuperEconomicAccount;
import com.attozoic.main.model.dto.DtoProjectEconomicAccount;

public interface ServiceProject extends ServiceEntity {

	void updateAll();
	
	List<Project> getProjectsByAuthority(String authorityCode);
	
	List<SuperEconomicAccount> getProjectExpences(Long uid);
	
	Map<String, double[]> getProjectFinancialSourceMap(Long uid);
	List<Double> getProjectExpencesFooter(Long uid);
	List<DtoProjectEconomicAccount> getProjectExpencesList(Long uid);
	
	ProjectGoal addProjectGoal(Long uid, ProjectGoal goal);
	ProjectEconomicAccount addProjectEconomicAccount(Long uid, ProjectEconomicAccount projectEconomiAccount);
	
	List<ProjectGoal> getProjectGoals(Long uid);
	
}
