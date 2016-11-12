package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.daoBalance.DaoBalanceEconomicAccount;
import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.services.ServiceBalanceEconomicAccount;

@Service
public class ServiceBalanceEconomicAccountImpl extends ServiceEntityImpl implements ServiceBalanceEconomicAccount {

	@Autowired
	private DaoBalanceEconomicAccount daoBalanceEconomicAccount;
	
	@Override
	public DaoEntity getDaoEntity() {
		return daoBalanceEconomicAccount;
	}
	
	@Override
	public ActivityFinancialSource addActivityFinancialSource(Long uid, ActivityFinancialSource acivityFinancialSource) {
		return ((DaoBalanceEconomicAccount)getDaoEntity()).addActivityFinancialSource(uid, acivityFinancialSource);
	}

	@Override
	public ProjectFinancialSource addProjectFinancialSource(Long uid, ProjectFinancialSource projectFinancialSource) {
		// TODO Auto-generated method stub
		return ((DaoBalanceEconomicAccount)getDaoEntity()).addProjectFinancialSource(uid, projectFinancialSource);
	}


	

}
