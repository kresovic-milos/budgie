package com.attozoic.main.services;

import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.ActivityGoal;

public interface ServiceActivity extends ServiceEntity {

	ActivityGoal addActivityGoal(Long uid, ActivityGoal activityGoal);
	ActivityFinancialSource addActivityFinancialSource(Long uid, ActivityFinancialSource activityFinancialSource);
	ActivityEconomicAccount addActivityEconomicAccount(Long uid, ActivityEconomicAccount activityEconomicAccount);
}
