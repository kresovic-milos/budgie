package com.attozoic.main.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.DaoProject;
import com.attozoic.main.model.ProjectEconomicAccount;
import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.model.dto.DtoProjectEconomicAccount;
import com.attozoic.main.services.ServiceProject;

@Service
public class ServiceProjectImpl extends ServiceEntityImpl implements ServiceProject {

	@Autowired
	private DaoProject daoProject;
	
	@Override
	public DaoEntity getDaoEntity() {
		return daoProject;
	}
	
//	@Override
//	public DtoFinanceFooter getProjectFinancialSourceFooter(Long uid) {
//		return ((DaoProject) getDaoEntity()).getProjectFinancialSourceFooter(uid);
//	}
	
	@Override
	public Map<String, double[]> getProjectFinancialSourceMap(Long uid) {
		return ((DaoProject) getDaoEntity()).getProjectFinancialSourceMap(uid);
	}
	
	@Override
	public List<Double> getProjectExpencesFooter(Long uid) {
		return ((DaoProject) getDaoEntity()).getProjectExpencesFooter(uid);
	}
	
//	@Override
//	public SuperEconomicAccount getProjectEconomicAccountFooter(Long uid) {
//		return ((DaoProject) getDaoEntity()).getProjectEconomicAccountFooter(uid);
//	}

	@Override
	public List<DtoProjectEconomicAccount> getProjectExpencesList(Long uid) {
		return ((DaoProject) getDaoEntity()).getProjectExpencesList(uid);
	}
	
	@Override
	public ProjectGoal addProjectGoal(Long uid, ProjectGoal goal) {
		return ((DaoProject) getDaoEntity()).addGoal(uid, goal);
	}

	@Override
	public ProjectEconomicAccount addProjectEconomicAccount(Long uid, ProjectEconomicAccount projectEconomicAccount) {
		return ((DaoProject) getDaoEntity()).addProjectEconomicAccount(uid, projectEconomicAccount);
	}

	@Override
	public List<ProjectGoal> getProjectGoals(Long uid) {
		return ((DaoProject) getDaoEntity()).getProjectGoals(uid);
	}
	
}
