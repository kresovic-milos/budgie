package com.attozoic.main.model.dto;

import java.util.List;

import com.attozoic.main.model.ActivityEconomicAccount;

import lombok.Data;

@Data
public class DtoActivityEconomicAccountThreeDigitsCollection {

	private ActivityEconomicAccount activityEconomicAccount;
	
	private List<ActivityEconomicAccount> activityEconomicAccounts;
	
	public DtoActivityEconomicAccountThreeDigitsCollection() {}
	
	public DtoActivityEconomicAccountThreeDigitsCollection(ActivityEconomicAccount activityEconomicAccount, List<ActivityEconomicAccount> activityEconomicAccounts) {
		this.activityEconomicAccount = activityEconomicAccount;
		this.activityEconomicAccounts = activityEconomicAccounts;
	}
	
}
