package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoActivity;
import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.services.ServiceActivity;

@Service
public class ServiceActivityImpl extends ServiceEntityImpl implements ServiceActivity {

	@Autowired
	private DaoActivity daoActivity;
	
	@Override
	public DaoEntity getDaoEntity() {
		return daoActivity;
	}

	@Override
	public ActivityGoal addActivityGoal(Long uid, ActivityGoal activityGoal) {
		return ((DaoActivity) getDaoEntity()).addActivityGoal(uid, activityGoal);
	}

	@Override
	public ActivityFinancialSource addActivityFinancialSource(Long uid, ActivityFinancialSource activityFinancialSource) {
		return ((DaoActivity) getDaoEntity()).addActivityFinancialSource(uid, activityFinancialSource);
	}

	@Override
	public ActivityEconomicAccount addActivityEconomicAccount(Long uid, ActivityEconomicAccount activityEconomicAccount) {
		return ((DaoActivity) getDaoEntity()).addActivityEconomicAccount(uid, activityEconomicAccount);
	}

}
