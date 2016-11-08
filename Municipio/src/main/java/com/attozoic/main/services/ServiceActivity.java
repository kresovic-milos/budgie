package com.attozoic.main.services;

import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.model.DtoActivityProject;
import com.attozoic.main.model.DtoProgrammeFinancialSource;

public interface ServiceActivity extends ServiceEntity {

	ActivityGoal addActivityGoal(Long uid, ActivityGoal activityGoal);
	ActivityFinancialSource addActivityFinancialSource(Long uid, ActivityFinancialSource activityFinancialSource);
	ActivityEconomicAccount addActivityEconomicAccount(Long uid, ActivityEconomicAccount activityEconomicAccount);
	DtoActivityProject buildActivityDto(Long uid);
	DtoProgrammeFinancialSource buildActivityFinanceDto(Long uid);
}
