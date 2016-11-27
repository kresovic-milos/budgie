package com.attozoic.main.model.dto;

import java.util.List;

import com.attozoic.main.model.ProjectEconomicAccount;

import lombok.Data;

@Data
public class DtoProjectEconomicAccount implements Comparable<DtoProjectEconomicAccount> {

	// Jedan red iz liste ActivityEconomicAccountDTOsList
	// Jedan grupa - ThreeDigit ActivityEconomicAccount i njegovi ActivityEconomicAccount-i
	
	private ProjectEconomicAccount projectEconomicAccount;
	
	private List<ProjectEconomicAccount> projectEconomicAccounts;
	
	public DtoProjectEconomicAccount() {}
	
	public DtoProjectEconomicAccount(ProjectEconomicAccount projectEconomicAccount, List<ProjectEconomicAccount> projectEconomicAccounts) {
		this.projectEconomicAccount = projectEconomicAccount;
		this.projectEconomicAccounts = projectEconomicAccounts;
	}

	@Override
	public int compareTo(DtoProjectEconomicAccount o) {
		return Integer.parseInt(this.getProjectEconomicAccount().getCode()) - Integer.parseInt(o.getProjectEconomicAccount().getCode());
	}
	
}
