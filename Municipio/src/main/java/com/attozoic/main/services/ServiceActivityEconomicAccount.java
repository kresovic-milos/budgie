package com.attozoic.main.services;

import java.util.List;

import com.attozoic.main.model.dto.DtoBalanceFinancialSourceObject;

public interface ServiceActivityEconomicAccount extends ServiceEntity {
	
	List<DtoBalanceFinancialSourceObject> getActivityEconomicAccountDtoBalanceFinancialSourceObjectLists(Long uid);
	
}
