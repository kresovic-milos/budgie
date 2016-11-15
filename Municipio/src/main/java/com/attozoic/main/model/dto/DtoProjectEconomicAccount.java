package com.attozoic.main.model.dto;

import java.util.List;

import com.attozoic.main.model.ProjectEconomicAccount;

import lombok.Data;

@Data
public class DtoProjectEconomicAccount {

	private ProjectEconomicAccount projectEconomicAccount;
	
	private List<ProjectEconomicAccount> projectEconomicAccounts;
	
	public DtoProjectEconomicAccount() {}
	
	public DtoProjectEconomicAccount(ProjectEconomicAccount projectEconomicAccount, List<ProjectEconomicAccount> projectEconomicAccounts) {
		this.projectEconomicAccount = projectEconomicAccount;
		this.projectEconomicAccounts = projectEconomicAccounts;
	}
	
}
