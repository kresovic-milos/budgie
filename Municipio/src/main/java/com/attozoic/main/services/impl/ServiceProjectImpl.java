package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.DaoProject;
import com.attozoic.main.model.DtoActivityProject;
import com.attozoic.main.model.DtoProgrammeFinancialSource;
import com.attozoic.main.model.ProjectEconomicAccount;
import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.model.RebalancesCount;
import com.attozoic.main.services.ServiceProject;
import com.attozoic.main.services.ServiceRebalancesCount;

@Service
public class ServiceProjectImpl extends ServiceEntityImpl implements ServiceProject {

	@Autowired
	private DaoProject daoProject;
	
	@Override
	public DaoEntity getDaoEntity() {
		return daoProject;
	}
	
	@Autowired
	private ServiceRebalancesCount serviceRebalanceCount;
	
	@Override
	public ProjectFinancialSource addProjectFinancialSource(Long uid, ProjectFinancialSource financialSource) {		
		return ((DaoProject) getDaoEntity()).addProjectFinancialSource(uid, financialSource);
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
	public DtoActivityProject buildProjectDto(Long uid) {
		return ((DaoProject) getDaoEntity()).buildProjectDto(uid);
	}
	
	@Override
	public DtoProgrammeFinancialSource buildProjectFinanceDto(Long uid) {
		int num = ((RebalancesCount)serviceRebalanceCount.findOne(new Long(1))).getRebalancesCount();
		return ((DaoProject) getDaoEntity()).buildProjectFinanceDto(uid, num);
	}
	
}
