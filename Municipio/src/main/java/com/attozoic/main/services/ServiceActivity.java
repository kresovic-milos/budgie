package com.attozoic.main.services;

import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.model.EconomicAccount;
import com.attozoic.main.model.Function;

public interface ServiceActivity extends ServiceEntity {

	ActivityGoal addActivityGoal(Long uid, ActivityGoal activityGoal);
	ActivityFinancialSource addFinancialSource(Long uid, ActivityFinancialSource activityFinancialSource);
	Function addFunction(Long uid, Function function);
	EconomicAccount addEconomicAccount(Long uid, EconomicAccount economicAccount);
}
