package com.attozoic.main.services;

import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ActivityGoal;

public interface ServiceActivity extends ServiceEntity {

	ActivityGoal addActivityGoal(Long uid, ActivityGoal activityGoal);
	ActivityEconomicAccount addActivityEconomicAccount(Long uid, ActivityEconomicAccount activityEconomicAccount);
	//Map<ActivityEconomicAccount, List<ActivityEconomicAccount>> getActivityEconomicAccountMap(Long uid);
	//DtoProgrammeExpencesItem buildActivityDto(Long uid);
	//DtoProgrammeFinancialSourceItem buildActivityFinanceDto(Long uid);
}
