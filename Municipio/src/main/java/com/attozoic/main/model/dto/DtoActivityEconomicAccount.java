package com.attozoic.main.model.dto;

import java.util.List;

import com.attozoic.main.model.ActivityEconomicAccount;

import lombok.Data;

@Data
public class DtoActivityEconomicAccount {

	private ActivityEconomicAccount activityEconomicAccount;
	
	private List<ActivityEconomicAccount> activityEconomicAccounts;
	
	public DtoActivityEconomicAccount() {}
	
	public DtoActivityEconomicAccount(ActivityEconomicAccount activityEconomicAccount, List<ActivityEconomicAccount> activityEconomicAccounts) {
		this.activityEconomicAccount = activityEconomicAccount;
		this.activityEconomicAccounts = activityEconomicAccounts;
	}
	
}
