package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProjectEconomicAccount;
import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.model.balance.Balance;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProjectEconomicAccount;
import com.attozoic.main.repositories.RepositoryProjectFinancialSource;
import com.attozoic.main.repositories.repositoriesBalance.RepositoryBalance;

@Repository
public class DaoProjectFinancialSource extends DaoEntity {

	@Autowired
	private RepositoryProjectFinancialSource repositoryProjectFinancialSource;
	
	@Autowired
	private RepositoryProjectEconomicAccount repoProjectEconomicAccount;
	
	@Autowired
	private RepositoryBalance repoBalance;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repositoryProjectFinancialSource;
	}
	
	@Override
	public SuperEntity update(SuperEntity superEntity) {
		ProjectFinancialSource projectFinancialSource = (ProjectFinancialSource) superEntity;
		projectFinancialSource.generateFinancialSourceAmount();
		SuperEntity afs = super.update(projectFinancialSource);
		ProjectFinancialSource afs1 = (ProjectFinancialSource) afs;
		Balance balance = repoBalance.findOne(afs1.getBalance().getUid());
		balance.generateBalanceAmount();
		repoBalance.save(balance);
		ProjectEconomicAccount projectEconomicAccount = repoProjectEconomicAccount.findOne(balance.getSuperEconomicAccount().getUid()); 
		projectEconomicAccount.generateSumExpences123();
		repoProjectEconomicAccount.save(projectEconomicAccount);
		return afs;
	}
	
}
