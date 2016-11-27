package com.attozoic.main.model.dto;

import java.util.List;

import com.attozoic.main.model.ActivityEconomicAccount;

import lombok.Data;

@Data
public class DtoActivityEconomicAccount implements Comparable<DtoActivityEconomicAccount> {

	// Jedan red iz liste ActivityEconomicAccountDTOsList
	// Jedan grupa - ThreeDigit ActivityEconomicAccount i njegovi ActivityEconomicAccount-i
	
	private ActivityEconomicAccount activityEconomicAccount;
	
	private List<ActivityEconomicAccount> activityEconomicAccounts;
	
	public DtoActivityEconomicAccount() {}
	
	public DtoActivityEconomicAccount(ActivityEconomicAccount activityEconomicAccount, List<ActivityEconomicAccount> activityEconomicAccounts) {
		this.activityEconomicAccount = activityEconomicAccount;
		this.activityEconomicAccounts = activityEconomicAccounts;
	}

	@Override
	public int compareTo(DtoActivityEconomicAccount o) {
		return Integer.parseInt(this.getActivityEconomicAccount().getCode()) - Integer.parseInt(o.getActivityEconomicAccount().getCode());
	}
	
}
