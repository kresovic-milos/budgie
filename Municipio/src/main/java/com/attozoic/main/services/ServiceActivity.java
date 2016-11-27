package com.attozoic.main.services;

import java.util.List;
import java.util.Map;

import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.model.dto.DtoActivityEconomicAccount;
import com.attozoic.main.model.dto.DtoFinanceFooter;

public interface ServiceActivity extends ServiceEntity {

	DtoFinanceFooter getActivityFinancialSourceFooter(Long uid);
	Map<String, double[]> getActivityFinancialSourceMap(Long uid);
	//SuperEconomicAccount getActivityEconomicAccountFooter(Long uid);
	List<Double> getActivityExpencesFooter(Long uid);
	List<DtoActivityEconomicAccount> getActivityEconomicAccountsList(Long uid);

	ActivityGoal addActivityGoal(Long uid, ActivityGoal activityGoal);
	ActivityEconomicAccount addActivityEconomicAccount(Long uid, ActivityEconomicAccount activityEconomicAccount);
	
	List<ActivityGoal> getActivityGoals(Long uid);
	
}
