package com.attozoic.main.dao.daoBalance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.model.balance.BalanceEconomicAccount;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.repositoriesBalance.RepositoryBalanceEconomicAccount;

@Repository
public class DaoBalanceEconomicAccount extends DaoEntity {

	@Autowired
	private RepositoryBalanceEconomicAccount<BalanceEconomicAccount> repoBalanceEconomicAccount;

	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoBalanceEconomicAccount;
	}
	
	// addActivityFinancialSource
	@SuppressWarnings("unchecked")
	public ActivityFinancialSource addActivityFinancialSource(Long uid, ActivityFinancialSource acivityFinancialSource) {
		BalanceEconomicAccount balanceEconomicAccount = (BalanceEconomicAccount) getRepoEntity().findOne(uid);
		acivityFinancialSource.setBalanceEconomicAccount(balanceEconomicAccount);
		return (ActivityFinancialSource) getRepoEntity().save(acivityFinancialSource);
	}
	
	// addProjectFinancialSource
	@SuppressWarnings("unchecked")
	public ProjectFinancialSource addProjectFinancialSource(Long uid, ProjectFinancialSource projectFinancialSource) {
		BalanceEconomicAccount balanceEconomicAccount = (BalanceEconomicAccount) getRepoEntity().findOne(uid);
		projectFinancialSource.setBalanceEconomicAccount(balanceEconomicAccount);
		return (ProjectFinancialSource) getRepoEntity().save(projectFinancialSource);
	}
	
}
