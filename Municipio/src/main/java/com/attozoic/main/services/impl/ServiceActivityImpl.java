package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoActivity;
import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.model.EconomicAccount;
import com.attozoic.main.model.Function;
import com.attozoic.main.services.ServiceActivity;

@Service
public class ServiceActivityImpl extends ServiceEntityImpl implements ServiceActivity {

	@Autowired
	private DaoActivity dao;
	
	@Override
	public DaoEntity getDaoEntity() {
		return dao;
	}

	@Override
	public ActivityGoal addActivityGoal(Long uid, ActivityGoal activityGoal) {
		return ((DaoActivity) getDaoEntity()).addActivityGoal(uid, activityGoal);
	}

	@Override
	public ActivityFinancialSource addFinancialSource(Long uid, ActivityFinancialSource activityFinancialSource) {
		return ((DaoActivity) getDaoEntity()).addActivityFinancialSource(uid, activityFinancialSource);
	}

	@Override
	public Function addFunction(Long uid, Function function) {
		return ((DaoActivity) getDaoEntity()).addFunction(uid, function);
	}

	@Override
	public EconomicAccount addEconomicAccount(Long uid, EconomicAccount economiAccount) {
		return ((DaoActivity) getDaoEntity()).addActivityEconomicAccount(uid, economiAccount);
	}
	
}
