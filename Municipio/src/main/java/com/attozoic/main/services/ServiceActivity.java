package com.attozoic.main.services;

import java.util.List;

import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.model.SuperEconomicAccount;
import com.attozoic.main.model.dto.DtoActivityEconomicAccount;

public interface ServiceActivity extends ServiceEntity {

	ActivityGoal addActivityGoal(Long uid, ActivityGoal activityGoal);
	ActivityEconomicAccount addActivityEconomicAccount(Long uid, ActivityEconomicAccount activityEconomicAccount);
	SuperEconomicAccount getActivityEconomicAccountFooter(Long uid);
	List<DtoActivityEconomicAccount> getActivityEconomicAccountDTOsList(Long uid);
	

	//	List<DtoBalanceActivityFinancialSourceListObject> generateActivityFinancialSourceDTO(Long uid);
	//Map<ActivityEconomicAccount, List<ActivityEconomicAccount>> getActivityEconomicAccountMap(Long uid);
	//DtoProgrammeExpencesItem buildActivityDto(Long uid);
	//DtoProgrammeFinancialSourceItem buildActivityFinanceDto(Long uid);
}
