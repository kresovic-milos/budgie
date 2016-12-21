package com.attozoic.main.services;

import java.util.List;

import com.attozoic.main.model.ThreeDigitEconomicAccount;

public interface ServiceThreeDigitEconomicAccount extends ServiceEntity {

	List<ThreeDigitEconomicAccount> getActivityThreeDigitEconomicAccounts(Long itemUid);
	List<ThreeDigitEconomicAccount> getProjectThreeDigitEconomicAccounts(Long itemUid);
	
}
