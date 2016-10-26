package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.DaoProject;
import com.attozoic.main.model.EconomicAccount;
import com.attozoic.main.model.Function;
import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.services.ServiceProject;

@Service
public class ServiceProjectImpl extends ServiceEntityImpl implements ServiceProject {

	@Autowired
	private DaoProject dao;
	
	@Override
	public DaoEntity getDaoEntity() {
		return dao;
	}
	
	@Override
	public ProjectFinancialSource addFinancialSource(Long uid, ProjectFinancialSource financialSource) {		
		return ((DaoProject) getDaoEntity()).addFinancialSource(uid, financialSource);
	}
	
	@Override
	public ProjectGoal addGoal(Long uid, ProjectGoal goal) {
		return ((DaoProject) getDaoEntity()).addGoal(uid, goal);
	}

	@Override
	public Function addFunction(Long uid, Function function) {
		return ((DaoProject) getDaoEntity()).addFunction(uid, function);
	}

	@Override
	public EconomicAccount addEconomicAccount(Long uid, EconomicAccount economiAccount) {
		return ((DaoProject) getDaoEntity()).addProjectEconomicAccount(uid, economiAccount);
	}
	
}
